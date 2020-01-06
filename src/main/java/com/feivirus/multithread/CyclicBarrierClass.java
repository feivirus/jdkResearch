package com.feivirus.multithread;

import java.util.concurrent.CyclicBarrier;

/**
 * 等待指定数量的进程进入栅栏,处于等待状态时，再执行操作.
 */
public class CyclicBarrierClass {
    private static CyclicBarrier barrier;

    public static void main(String[] args) {
        barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("线程创建完成");
            }
        });

        for (int i = 0; i < 5; i++) {
            new CyclcBarrierThread().start();
        }
    }

    static class CyclcBarrierThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " 到了");
            try {
                barrier.await();
            } catch (Exception ex) {{
                ex.printStackTrace();
            }}
        }
    }


}
