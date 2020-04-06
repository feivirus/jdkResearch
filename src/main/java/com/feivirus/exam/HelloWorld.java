package com.feivirus.exam;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.atomic.AtomicInteger;;

public class HelloWorld {
	public static void main(String[] args)  throws Exception{
		Integer a = 1;
		if (a == 2 || a == 3) {
			return;
		}
		System.out.println("helloworld");
	}
}
