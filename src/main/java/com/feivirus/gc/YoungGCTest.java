package com.feivirus.gc;

/**
 * @author feivirus
 * -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps
 */
public class YoungGCTest {
    private static  final int  _1MB = 1024 * 1024;
    private static  int count = 0;

    public static void main(String[] args) {
        //年轻代gc
        for(int i = 1; i < 11; i++) {
            testAllocation();
            System.out.println("合计又分配了10MB " + count);
        }
    }

    public static  void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        count+=2;
        System.out.println("分配了2MB " + count);

        allocation2 = new byte[2 * _1MB];
        count+=2;
        System.out.println("分配了2MB " + count);

        allocation3 = new byte[2 * _1MB];
        count+=2;
        System.out.println("分配了2MB " + count);

        allocation4 = new byte[4 * _1MB];
        count+=4;
        System.out.println("分配了4MB " + count);
    }
}
