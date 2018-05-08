package com.feivirus.dynamicproxy;

public class RealSubject implements Subject{
	
	public void rent() {
		System.out.println("I am in RealSubject.rent");
		
	}
	
	public void hello(String msg) {
		System.out.println("I am in RealSubject.hello + " + msg);
	}
	
}
