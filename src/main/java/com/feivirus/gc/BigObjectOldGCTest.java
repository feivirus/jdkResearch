package com.feivirus.gc;

/**
 * @author feivirus
 * -verbose:gc -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xms20M -Xmx20M -Xmn10M -XX:PretenureSizeThreshold=3145728
 */
public class BigObjectOldGCTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        /**
         * 新生代，老年代各10MB大小
         * gc过程:
         * 新生代 4mb, 新生代 4mb, 新生代回收8mb,移到老年代8mb, 触发full gc(老年代回收8mb，新生代清零)
         * 新年代 4mb, 老年代4mb(大对象直接进入老年代), 老年代4mb. 触发full gc(老年代回收8mb，新生代清零)
         * 新年代 4mb,老年代4mb, 老年代4mb. 触发full gc(老年代回收8mb，新生代清零)
         */
        for (int i = 1; i < 11; i++) {
            byte []allocation = new byte[4 * _1MB];
            System.out.println("分配4MB  " + i);
        }
    }
}
