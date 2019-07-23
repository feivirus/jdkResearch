package com.feivirus.bit;

import org.springframework.beans.BeanUtils;

public class BitOperation {
    public static void main(String [] args) {
        byte a = 30;
        byte b = -3;
        int value = 50;
        
        String strInt = String.format("%32s", Integer.toBinaryString(value)).replace(" ", "0");
        System.out.println(strInt);
        String strByte = String.format("%8s", Integer.toBinaryString(value)).replace(" ", "0");
        System.out.println(strByte);
        String strFirstByte = String.format("%8s", Integer.toBinaryString(value&0x80)).replace(" ", "0");
        System.out.println(strFirstByte);
        String sencondByte = String.format("%8s", Integer.toBinaryString(value&0x40)).replace(" ", "0");
        System.out.println(sencondByte);
        String thirdByte = String.format("%8s", Integer.toBinaryString(value&0x20 >> 4)).replace(" ", "0");
        System.out.println(thirdByte);
        
    }
}
