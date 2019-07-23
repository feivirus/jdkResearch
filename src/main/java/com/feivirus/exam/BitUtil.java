package com.feivirus.exam;

/**
 * 
 * @author feivirus
 *
 */
public class BitUtil {
    public static void main(String [] args) {
        System.out.println("false " + getBit(20, 2));
        Byte byteValue = 20;
        System.out.println("true " + getBit(byteValue, 3));
        System.out.println("22 " + setBit(20, 2));
        System.out.println("16 " + clearBit(20, 3));
    }
    
    /**
     * 返回value的第 i 位是1 还是0
     * @param value
     * @param i 从1 开始
     * @return
     */
    public static <T extends Number> boolean getBit(T value, int i) {
        if (!(value instanceof Number)) {
            return false;
        }
        if ((value.longValue() & (1 << ( i - 1 ))) == 0) {
            return false;
        }
        return true;
    }   
    
    /**
     * 设置value的第i位 为1
     * @param value
     * @param i 从1开始
     * @return
     */
    public static int setBit(int value, int i) {
        return value | ( 1 << (i - 1));
    }    
    
    /**
     * 设置value的第i位 为1
     * @param value
     * @param i 从1开始
     * @return
     */
    public static byte setBit(byte value, int i) {
        return (byte) (value | ( 1 << (i - 1)));
    }    
    
    /**
     * 设置value的第i位 为1
     * @param value
     * @param i 从1开始
     * @return
     */
    public static <T extends Number> long setBit(T value, int i) {
        return (long) (value.longValue() | ( 1 << (i - 1)));
    }    
    
    /**
     * 设置value的第 i 位 为 0
     * @param value
     * @param i 从1开始
     * @return
     */
    public static int clearBit(int value, int i) {
        int mask = ~(1 << (i  - 1));
        
        return value & mask;
    }
    
    /**
     * 设置value的第 i 位 为 0
     * @param value
     * @param i 从1开始
     * @return
     */
    public static byte clearBit(byte value, int i) {
        int mask = ~(1 << (i  - 1));
        
        return (byte) (value & mask);
    }
    
    /**
     * 设置value的第 i 位 为 0
     * @param value
     * @param i 从1 开始
     * @return
     */
    public static <T extends Number> long clearBit(T value, int i) {
        int mask = ~(1 << (i  - 1));
        
        return (long) (value.longValue() & mask);
    }

}
