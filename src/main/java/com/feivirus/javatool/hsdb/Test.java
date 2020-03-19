package com.feivirus.javatool.hsdb;

public class Test {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        
        test1.fun1();
    }
}

class Test1 {
    private Integer a = 20;
    
    public static Test2 test2 = new Test2();
    
    public void fun1() {
        int i = 0;
        
        System.out.println(i);
    }
}

class Test2 {
    public int a = 10;
}
