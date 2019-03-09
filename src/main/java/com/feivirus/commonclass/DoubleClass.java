package com.feivirus.commonclass;

public class DoubleClass {
    public static void main(String[] args) {
        Double doubleValue = 100.0 / 10.0d;
        Double double1 = 10d;
        Integer intValue = 10;
        
        System.out.println("100/10:" + doubleValue);
        System.out.println(doubleValue.equals(intValue)); 
        Object obj = intValue;
        if (obj instanceof Double) {
            System.out.println("instanceof: true");
        } else {
            System.out.println("instanceof: false");
        }
        System.out.println("double,float:" + doubleValue.equals(intValue.doubleValue()));        
        System.out.println("double 100/10: " + Double.doubleToLongBits(doubleValue));
        System.out.println(doubleValue.equals(double1));
    }
}
