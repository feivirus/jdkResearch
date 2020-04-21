package com.feivirus.dynamicproxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * Proxy动态代理源码分析
 * https://blog.csdn.net/feivirus/article/details/104231404
 *
 * 也可以使用hsdb创建代理生成对象的class文件
 */
public class DynamicProxyClient {
	public static void main(String[] args) {
		Subject realSubject = new RealSubject();
		InvocationHandler handler = new DynamicProxy(realSubject);
		
		Subject proxySubject = (Subject)Proxy.newProxyInstance(handler.getClass().getClassLoader(), 
				realSubject.getClass().getInterfaces(), 
				handler);
		System.out.println("proxyClassName: " + proxySubject.getClass().getName());
		System.out.println("proxyClass: " + proxySubject.getClass());
		proxySubject.rent();
		proxySubject.hello("feivirus");

		System.out.println("start generate proxy object...");
		String objName = getObjectName(proxySubject.getClass().getName());
		generateProxyClassFile(objName, new Class<?>[]{Subject.class});
		System.out.println("end generate proxy object...");
	}

	public static String getObjectName(String fullName) {
		String[] nameList = fullName.split("\\.");
		return nameList[nameList.length - 1];
	}

	public static void generateProxyClassFile(String objectName,
											  Class<?>[] interfaces) {
		byte [] contents = ProxyGenerator.generateProxyClass(objectName, interfaces);
		String directory = "/Users/feivirus/Downloads";
		String fullPath = "/" + objectName + ".class";
		File file = new File(directory);

		if (!file.exists()) {
			file.mkdir();
		}
		fullPath = file.getAbsolutePath() + fullPath;
		file = new File(fullPath);

		if (file.exists()) {
			file.delete();
		}

		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(fullPath);
			fos.write(contents, 0, contents.length);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
