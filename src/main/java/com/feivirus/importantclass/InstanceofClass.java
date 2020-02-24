package com.feivirus.importantclass;

public class InstanceofClass {
    public static void main(String[] args) {
        Double value = 10d;
        
        if (value instanceof Double) {
            System.out.println("double double ");
        }
        if (value instanceof Object) {
            System.out.println("double object");
        }
        if (value instanceof Number) {
            System.out.println("double number ");
        }
        if (value.getClass().equals(Double.class)) {
            System.out.println(value.getClass());
            System.out.println("double getclass double ");
        }
        if (value.getClass().equals(Number.class)) {
            System.out.println("double getclass Number ");
        }
        if (value.getClass().equals(Object.class)) {
            System.out.println("double getclass Object ");
        }
//        if (value instanceof Integer) {
//            System.out.println("integer ");
//        }
        
        Object obj = value;
        
        if (obj instanceof Double) {
            System.out.println("Object double ");
        }
        if (obj instanceof Object) {
            System.out.println("Object object");
        }
        if (obj instanceof Number) {
            System.out.println("Object number ");
        }
        if (obj instanceof Integer) {
            System.out.print("Object Integer");
        }
        
        Number number = value;
        if (obj instanceof Double) {
            System.out.println("Number double ");
        }
        if (obj instanceof Object) {
            System.out.println("Number object");
        }
        if (obj instanceof Number) {
            System.out.println("Number number ");
        }
        if (obj instanceof Integer) {
            System.out.print("Number Integer");
        }
        
    
    }
}
