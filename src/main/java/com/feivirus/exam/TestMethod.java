package com.feivirus.exam;

import java.lang.reflect.Method;

public class TestMethod {

    public static void main(String[] argu) throws Exception{
        MyOperation myOperation = new MyOperation();

        testRun(myOperation);
        testRun1(myOperation);
    }

    public static void testRun(MyOperation operationProxy){
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 100000000; i++){
            operationProxy.doSomething();
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    public static void testRun1(MyOperation operationProxy) throws Exception {
        Method method = operationProxy.getClass().getMethod("doSomething");
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 100000000; i++){
            method.invoke(operationProxy);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
