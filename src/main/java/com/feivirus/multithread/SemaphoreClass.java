package com.feivirus.multithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可用数量,获取到一个Semaphore，可用数量减1.Semaphore为0时，线程等待.
 */
public class SemaphoreClass {

    public static void main(String[] args) {
        Parking parking = new Parking(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    parking.park();
                }
            }).start();
        }
    }

}


class Parking {
    private Semaphore semaphore;

    Parking(int count) {
        semaphore = new Semaphore(count);
    }

    public void park() {
        try {
            semaphore.acquire();
            long time = (long)(Math.random() * 10);
            System.out.println(Thread.currentThread().getName() + " 休息 " + time + " 秒");
            Thread.sleep(time);
            System.out.println(Thread.currentThread().getName() + " 启动 ");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}