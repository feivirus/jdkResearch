package com.feivirus.exam;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.atomic.AtomicInteger;;

public class HelloWorld {
	public static void main(String[] args)  throws Exception{
	    System.out.println("Hello 1");
	    Thread.sleep(1000);
		System.out.println("Hello feivirus!");
		System.out.println("Hello 2");
		System.out.println("Hello 3");
		System.out.println("Hello 4");
		
		while(true) {
		    Thread.sleep(1000);
		    System.out.println("hello ");
		}
	}
}
