package com.feivirus.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyClient {
	public static void main(String[] args) {
		Subject realSubject = new RealSubject();
		InvocationHandler handler = new DynamicProxy(realSubject);
		
		Subject proxySubject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), 
				realSubject.getClass().getInterfaces(), 
				handler);
		System.out.println("proxyClassName: " + proxySubject.getClass().getName());
		proxySubject.rent();
		proxySubject.hello("feivirus");
	}
}
