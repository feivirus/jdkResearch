package com.feivirus.hotspot.objectstruct;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @author feivirus
 * 对象Object布局
 * https://segmentfault.com/a/1190000012354736
 */
public class ObjectStruct {

    public static void main(String[] args) {
        System.out.println("---------------------vm参数");
        System.out.println(VM.current().details());

        System.out.println("---------------------类属性结构");
        System.out.println(ClassLayout.parseClass(ReorderObjectChild.class).toPrintable());
        System.out.println("---------------------对象堆结构");
        SynchronizedDemo demo = new SynchronizedDemo();
        System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        System.out.println("---------------------数组结构");
        System.out.println(ClassLayout.parseInstance(new Boolean[1]).toPrintable());
        System.out.println("---------------------synchronized锁对象结构");
        synchronized (demo) {
            System.out.println("lock demo:" + demo.hashCode() + " binary:" + Integer.toBinaryString(demo.hashCode()));
            System.out.println(ClassLayout.parseInstance(demo).toPrintable());
        }
    }
}

class SynchronizedDemo {

}

class ReorderObject {
    private byte a;
    private int b;
    private boolean c;
    private float d;
    private Object e;
}

class ReorderObjectChild extends ReorderObject{
    private float d;
}
