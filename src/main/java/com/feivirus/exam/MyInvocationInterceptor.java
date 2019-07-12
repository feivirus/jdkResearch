package com.feivirus.exam;

import net.sf.cglib.core.DefaultGeneratorStrategy;
import net.sf.cglib.core.GeneratorStrategy;
import net.sf.cglib.core.NamingPolicy;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.reflect.FastClass;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationInterceptor implements MethodInterceptor {

    //被代理对象，Object类型
    private Object target;

    public MyInvocationInterceptor() {

    }

    public MyInvocationInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        //生成class
        //makeClass(proxy);
        //makeClass2(proxy);

        //System.out.println("准备向执行操作-cglib");
        //Object returnvalue = proxy.invokeSuper(obj, args);
        Object returnvalue = proxy.invoke(target, args);
        //Object returnvalue = proxy.invoke(obj, args);
        //Object returnvalue = method.invoke(target, args);
        //System.out.println("执行完操作-cglib");
        return null;
    }

    private void makeClass(MethodProxy proxy) throws Throwable {
        //获取CreateInfo
        Object object = getObject(proxy, "createInfo");

        Object c1 = getObject(object, "c1");
        Object namingPolicy = getObject(object, "namingPolicy");
        Object strategy = getObject(object, "strategy");
        Object attemptLoad = getObject(object, "attemptLoad");

        FastClass.Generator g = new FastClass.Generator();
        g.setType((Class) c1);
        g.setClassLoader(object.getClass().getClassLoader());
        g.setNamingPolicy((NamingPolicy)namingPolicy);
        g.setStrategy((GeneratorStrategy)strategy);
        g.setAttemptLoad((boolean)attemptLoad);

        Field classNameField = g.getClass().getSuperclass().getDeclaredField("className");
        classNameField.setAccessible(true);
        classNameField.set(g, "MyOperation$$FastClassByCGLIB");

        DefaultGeneratorStrategy defaultGeneratorStrategy = DefaultGeneratorStrategy.INSTANCE;
        byte[] classFile = defaultGeneratorStrategy.generate(g);

        String path = "/Users/zhouqishi/Desktop/workspace/workspace2018/demoTest/MyOperation$$FastClassByCGLIB.class";
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

    private void makeClass2(MethodProxy proxy) throws Throwable {
        //获取CreateInfo
        Object object = getObject(proxy, "createInfo");

        Object c1 = getObject(object, "c2");
        Object namingPolicy = getObject(object, "namingPolicy");
        Object strategy = getObject(object, "strategy");
        Object attemptLoad = getObject(object, "attemptLoad");

        FastClass.Generator g = new FastClass.Generator();
        g.setType((Class) c1);
        g.setClassLoader(object.getClass().getClassLoader());
        g.setNamingPolicy((NamingPolicy)namingPolicy);
        g.setStrategy((GeneratorStrategy)strategy);
        g.setAttemptLoad((boolean)attemptLoad);

        Field classNameField = g.getClass().getSuperclass().getDeclaredField("className");
        classNameField.setAccessible(true);
        classNameField.set(g, "MyOperation$$FastClassByCGLIB2");

        DefaultGeneratorStrategy defaultGeneratorStrategy = DefaultGeneratorStrategy.INSTANCE;
        byte[] classFile = defaultGeneratorStrategy.generate(g);

        String path = "/Users/zhouqishi/Desktop/workspace/workspace2018/demoTest/MyOperation$$FastClassByCGLIB2.class";
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

    private Object getObject(Object obj, String filedName) throws Throwable {
        Field field =  obj.getClass().getDeclaredField(filedName);
        field.setAccessible(true);
        Object fieldObj = field.get(obj);

        return fieldObj;
    }

}
