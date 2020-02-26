package com.feivirus.multithread;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author feivirus
 * synchronized关键字
 */
public class SynchronizedKeyWord {

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();

        System.out.println(ClassLayout.parseInstance(demo).toPrintable());

        System.out.println("---------------------");
        synchronized (demo) {
            System.out.println("lock demo:" + demo.hashCode() + " binary:" + Integer.toBinaryString(demo.hashCode()));
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }
    }
}

class SynchronizedDemo {

}
