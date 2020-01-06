package com.feivirus.multithread;

/**
 * @author feivirus
 * i 有时会是 0
 */
public class ReorderDemo {
    int a = 0;
    boolean flag = false;

    public void write() {
        System.out.println("write");
        a = 1;
        System.out.println("a = 1");
        flag = true;
    }

    public void reader() {
        System.out.println("reader");
        int i =0;

        if (flag) {
            i = a * a;
            System.out.println("flag=true, i= " + i);
        } else {
            System.out.println("flag=false,i= " + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            System.out.println("new loop");
            ReorderDemo reorderDemo = new ReorderDemo();

            Thread a = new Thread(new Runnable() {
                @Override
                public void run() {
                    reorderDemo.write();
                }
            });
            Thread b = new Thread(new Runnable() {
                @Override
                public void run() {
                    reorderDemo.reader();
                }
            });

            a.start();
            b.start();
            System.out.println("new loop");
        }

    }
}
