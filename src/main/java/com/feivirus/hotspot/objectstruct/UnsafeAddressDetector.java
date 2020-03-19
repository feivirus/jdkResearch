package com.feivirus.hotspot.objectstruct;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author feivirus
 * 通过unsafe获取对象地址
 */
public class UnsafeAddressDetector {
    private static Unsafe unsafe;

    public static boolean init() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static long detectAddress(Object obj) {
        Object[] array = new Object[] { obj };
        int baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress = 0;

        switch (addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                break;
        }
        return objectAddress;
    }

    //调用这个方法会崩溃
    public static void printMemoryBytes(long address, int num) {
        for (int i = 0; i < num; i++) {
            int value = unsafe.getByte(address + i);
            System.out.print((char)value);
        }
        System.out.println("print bytes end-------");
    }

    public static void main(String[] args) {
        Object object = new UnsafeAddressDetector();
        UnsafeAddressDetector.init();
        long address = detectAddress(object);
        System.out.println("object address: " + address);

        //printMemoryBytes(address, 4);

    }

}
