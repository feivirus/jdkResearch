package com.feivirus.exam;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSemaphore {

    static Lock lock = new ReentrantLock();

    static class SemaphoreThread implements Runnable {

        private int i;

        volatile Semaphore semaphore;

        public SemaphoreThread(Semaphore semaphore, int i) {
            this.semaphore = semaphore;
            this.i = i;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("acquire currThread-" + Thread.currentThread().getId() + ", i=" + i + ", semaphore=" + semaphore.availablePermits());

                //lock.lock();
                int n = 1;
                if(i < 5) {
                    n = i % 5 + 1;
                }
                Thread.sleep(n * 2000);
            } catch (Exception e){

            } finally {
                semaphore.release();
                System.out.println("------ release currThread-" + Thread.currentThread().getId() + ", i=" + i + ", semaphore=" + semaphore.availablePermits());
                //lock.unlock();
            }

        }
    }

    public static void main(String[] argu) throws Exception {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 20; i ++){
            new Thread(new SemaphoreThread(semaphore, i)).start();
        }
        //semaphore.release();
    }

}