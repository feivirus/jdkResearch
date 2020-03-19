package com.feivirus.importantclass.synchronizedword;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author feivirus
 */
public class DemoExample1 {
    static TestDemo testDemo;

    public static void main(String[] args) {
        testDemo = new TestDemo();
        System.out.println(ClassLayout.parseInstance(testDemo).toPrintable());
        synchronized (testDemo) {
            System.out.println("synchronized testDemo");
            testDemo.hashCode();
            System.out.println(ClassLayout.parseInstance(testDemo).toPrintable());
        }
    }
}

class TestDemo {
}
