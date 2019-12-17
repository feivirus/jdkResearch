package com.feivirus.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author feivirus
 */
public class DirectMemoryOOM {
    private static final int _100MB = 1024 * 1024 * 100;

    public static void main(String[] args) throws  Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];

        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_100MB);
        }
    }
}
