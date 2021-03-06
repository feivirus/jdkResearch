package com.feivirus.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler {
	
	//要代理的真实对象
	private Object subject;	
	
	public DynamicProxy(Object subject) {
		this.subject = subject;
	}	

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("do something before real call");
		System.out.println("Method: " + method);
		
		method.invoke(subject, args);
		
		System.out.println("after real call");
		/**
		 * 因为return null, 所以调用Proxy.newProxyInstance返回的对象debug时，显示null
		 */
		return null;
	}
	
}
