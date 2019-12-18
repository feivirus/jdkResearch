package com.feivirus.gc;

/**
 * @author feivirus
 * 修改-XX:MaxTenuringThreshold=1 或者15
 * -verbose:gc -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xms20M -Xmx20M -Xmn10M
 */
public class LongLiveObjectGCTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte [] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB / 4];
        System.out.println("分配256k");
        allocation2 = new byte[4 * _1MB];
        System.out.println("分配4mb");
        allocation3 = new byte[4 * _1MB];
        System.out.println("分配4mb");
        allocation3 = null;
        System.out.println("指针null");
        allocation3 = new byte[4 * _1MB];
        System.out.println("分配4mb");
    }
}
