package com.feivirus.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class UserDaoProxy implements MethodInterceptor{

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before intercept");
        //proxy.invoke(obj, args);
        proxy.invokeSuper(obj, args);
        System.out.println("after intercept");
        return obj;
    }
    
}
