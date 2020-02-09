package com.feivirus.multithread;

import java.util.concurrent.CountDownLatch;

/**
 * 允许N个线程等待其他线程执行完成
 */
public class CountDownLatchClass {
    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    static class BossThread extends Thread {
        @Override
        public void run() {
            System.out.println("boss等待 " + countDownLatch.getCount());
            try {
                countDownLatch.await();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("boss等待结束 ");
        }
    }

    static class WorkerThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " ok");
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        new BossThread().start();

        for (long i = 0, j = countDownLatch.getCount(); i < j; i++) {
            new WorkerThread().start();
        }
    }
}
