package com.feivirus.exam;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] argu) {

        Class<IOperation> mapperInterface = IOperation.class;
        Class<?>[] classes = new Class[]{mapperInterface};

        MyOperation myOperation = new MyOperation();
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(myOperation);

        IOperation operationProxy = (IOperation)Proxy.newProxyInstance(TestProxy.class.getClassLoader(), classes, myInvocationHandler);
        operationProxy.doSomething();

        testRun(operationProxy);

        //makeClass();

    }

    public static void testRun(IOperation operationProxy){
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 100000000; i++){
            operationProxy.doSomething();
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    public static void makeClass() {
        String path = "/Users/zhouqishi/Desktop/workspace/workspace2018/demoTest/$Proxy0.class";
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", MyOperation.class.getInterfaces());
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(path);
            out.write(classFile);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
