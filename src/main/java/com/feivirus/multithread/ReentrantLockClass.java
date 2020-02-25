package com.feivirus.multithread;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 主要用来看AbstractQueuedSynchronizer原理
 */
public class ReentrantLockClass {

    public static void main(String[] args) {
        //ReentrantReadWriteLock writeLock = new ReentrantReadWriteLock();
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            new Thread(new SimpleRunnable(lock)).start();
        }
    }
}

class SimpleRunnable implements Runnable {
    private ReentrantLock lock;

    public SimpleRunnable (ReentrantLock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " start run");
            Thread.sleep(1000 * 60 * 60);
            System.out.println(Thread.currentThread().getName() + " finish run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
