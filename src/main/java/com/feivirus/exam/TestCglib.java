package com.feivirus.exam;

import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCglib {

    public static void main(String[] argu) throws Exception{
        MyOperation myOperation = new MyOperation();
        MyInvocationInterceptor myInvocationInterceptor = new MyInvocationInterceptor(myOperation);

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyOperation.class);
        enhancer.setCallback(myInvocationInterceptor);
        MyOperation myOperationProxy = (MyOperation)enhancer.create();
        myOperationProxy.doSomething();

        testRun(myOperationProxy);

        //makeClass(enhancer);
    }

    public static void testRun(MyOperation operationProxy){
        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 100000000; i++){
            operationProxy.doSomething();
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    public static void makeClass(Enhancer enhancer) throws Exception{
        String path = "/Users/zhouqishi/Desktop/workspace/workspace2018/demoTest/MyOperation$$EnhancerByCGLIB.class";
        DefaultGeneratorStrategy defaultGeneratorStrategy = DefaultGeneratorStrategy.INSTANCE;
        byte[] classFile = defaultGeneratorStrategy.generate(enhancer);
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
