package com.feivirus.multithread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author feivirus
 * 参考链接:
 * http://www.importnew.com/26049.html
 */
public class ConcurrentHashMapClass {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();

        map.put("a", "123");
        map.put("b", "456");
        map.put("c", "789");

        System.out.println(map.get("a"));
    }
}
