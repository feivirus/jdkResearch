package com.feivirus.commonclass;

import java.util.HashMap;
import java.util.Map;

public class HashMapClass {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        //大于等于64个元素碰撞，转为红黑树
        map.put(2, "v2");
        for(int i = 0; i < 65; i++) {
            int key = 16 * i + 1;
            //i是32时转红黑树,16-32-64
            map.put(key, "v" + key);
        }

        String value = map.get(1);
        System.out.println("map get (1) " + value);
        System.out.println("max compacity: " + (1 << 30));
    }
}

