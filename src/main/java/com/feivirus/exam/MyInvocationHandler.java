package com.feivirus.exam;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    //被代理对象，Object类型
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //System.out.println("准备向执行操作");
        Object returnvalue = method.invoke(target, args);
        //System.out.println("执行完操作");

        return returnvalue;
    }

}
