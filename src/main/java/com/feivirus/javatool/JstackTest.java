package com.feivirus.javatool;

/**
 * jstack -l 1908
 */
public class JstackTest {
    private Double count = 1000d;

    public Double getCount() {
        return count;
    }

    public static void loopTest() {
        JstackTest test = new JstackTest();

        for (int i = 0; i < test.getCount(); i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }, "testLockThread");

        thread.start();
    }

    public static void main(String[] args) {
        //loopTest();
        Object obj = new Object();
        createLockThread(obj);
    }
}
