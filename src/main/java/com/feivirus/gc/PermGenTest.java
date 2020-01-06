package com.feivirus.gc;

import javassist.ClassPool;

/**
 * @author feivirus
 * -verbose:gc -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xms20M -Xmx20M -Xmn10M -XX:MaxPermSize10M
 */
public class PermGenTest {
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 100000000; i++) {
            generateClass("com.feivirus.gc" + i);
        }
    }

    public static Class generateClass(String name) throws Exception{
        ClassPool pool = ClassPool.getDefault();

        return pool.makeClass(name).toClass();
    }
}
