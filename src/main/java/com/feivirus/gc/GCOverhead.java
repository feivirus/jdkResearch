package com.feivirus.gc;

import java.util.Map;
import java.util.Random;

/**
 * @author feivirus
 * -verbose:gc -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xms20M -Xmx20M -Xmn10M
 */
public class GCOverhead {
    public static void main(String[] args) {
        Map map = System.getProperties();
        Random r = new Random();

        while (true) {
            map.put(r.nextInt(), "value");
        }
    }
}
