package com.feivirus.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author feivirus
 * 1.如果线程池中的线程数量小于corePoolSize=3，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理任务。x<3
 * 2.如果线程池中的线程数量等于corePoolSize=3，但是缓冲队列workQueue=4未满，即线程数小于corePoolSize+capacity队列大小(3+4),
 *  那么任务被放入缓冲队列。x<3+4
 * 如果此时线程池中的数量大于corePoolSize=3，缓冲队列workQueue=4满，并且线程池中的线程数量小于maximumPoolSize=6，
 *  建新的线程来处理被添加的任务。x< (3+max(4,6))
 * 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，
 * 那么通过 handler所指定的策略来处理此任务。x > (3+max(4,6))
 * 也就是：处理任务的优先级为：
 * 核心线程corePoolSize、任务队列workQueue、最大线程maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
 * 当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。
 */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 5,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(4));

        for(int i = 0; i < 15; i++) {
            try {
                String value = "task-" + i;
                System.out.println("main start " + value);
                executor.execute(new DemoTask(value));
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
