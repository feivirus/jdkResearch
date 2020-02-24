package com.feivirus.multithread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class ThreadPool {
    private final static Integer TASK__QUEUE_SIZE = 10;
    private final static Integer ONE_LOOP_RECORD_COUNT = 5;
    private final static Integer THREAD_POOL_SIZE = 5;
    private final static Integer TOTAL_RECORDS_COUNT_INTEGER = 103;
    private BlockingQueue<String> taskQueue = new LinkedBlockingDeque<String>(TASK__QUEUE_SIZE);
    private CountDownLatch stopLatch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception {
        ThreadPool threadPool = new ThreadPool();

        threadPool.listenerThreadPool();
    }

    class TaskProducer implements Runnable {
        public volatile Integer currentRow = 0;

        public void offerTask() {
            System.out.println("name " + Thread.currentThread().getName());
            Integer eachSqlCountInteger = ONE_LOOP_RECORD_COUNT;

            String sql = "each retrive sql recoreds, current row, limit " + currentRow + "," + eachSqlCountInteger;
            System.out.println(sql);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < eachSqlCountInteger; i++) {
                try {
                    if ((i + currentRow) < TOTAL_RECORDS_COUNT_INTEGER) {
                        taskQueue.put("task " + (i + currentRow));
                        System.out.println("put task in queue " + (i + currentRow));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentRow += eachSqlCountInteger;
        }

        public boolean needStop() {
            Integer totalCount = TOTAL_RECORDS_COUNT_INTEGER;
            if ((currentRow >= totalCount) &&
                 taskQueue.isEmpty()) {
                return true;
            }
            return false;
        }

        @Override
        public void run() {
            while (true) {
                if (taskQueue.isEmpty()) {
                    offerTask();
                }
               
                if (needStop()) {
                    stopLatch.countDown();
                    System.out.println("task producer exit " + Thread.currentThread().getName());
                    break;
                } 
            }           
        }
    }

    class RPCTracker implements Callable<String> {

        @Override
        public String call() throws Exception {
            while(true) {
                if (!taskQueue.isEmpty()) {
                    takeRPC();
                }
                if (stopLatch.await(100, TimeUnit.MILLISECONDS)) {
                    System.out.println("rpc tracker exit " + Thread.currentThread().getName());
                    break;
                }
            }
            return null;
        }

        public void takeRPC() {
            try {
                String task = taskQueue.poll(500, TimeUnit.MILLISECONDS);
                String odpsRPC = "execute rpc " + task + " " + Thread.currentThread().getName();
                System.out.println(odpsRPC);
                Thread.sleep(500);
                odpsRPC += " finish";
                System.out.println(odpsRPC);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void listenerThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);
        TaskProducer taskProducer = new TaskProducer();
        listeningExecutorService.submit(taskProducer);

        ListenableFuture<String> listenableFuture1 = listeningExecutorService.submit(new RPCTracker());
        ListenableFuture<String> listenableFuture2 = listeningExecutorService.submit(new RPCTracker());
        ListenableFuture<String> listenableFuture3 = listeningExecutorService.submit(new RPCTracker());
        ListenableFuture<String> listenableFuture4 = listeningExecutorService.submit(new RPCTracker());

//        listenableFuture1.addListener(taskProducer, listeningExecutorService);
//        listenableFuture2.addListener(taskProducer, listeningExecutorService);
//        listenableFuture3.addListener(taskProducer, listeningExecutorService);
//        listenableFuture4.addListener(taskProducer, listeningExecutorService);

        try {
            if (stopLatch.await(2, TimeUnit.HOURS)) {
                listeningExecutorService.shutdown();
                try {
                    while (!listeningExecutorService.awaitTermination(1, TimeUnit.SECONDS)) {
                        System.out.println("等待线程池关闭..." + " " + Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程池结束" + " " + Thread.currentThread().getName());
            } else {
                System.out.println("warn, task timeout");
            }
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    public void normalThreadPool() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> futureList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Future<String> future = executorService.submit(new Callable<String>() {

                @Override
                public String call() throws Exception {
                    System.out.println("thread id " + Thread.currentThread().getName());
                    return "hello";
                }

            });

            futureList.add(future);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(futureList.get(i).get());
        }
        executorService.shutdown();
    }

}
