package com.feivirus.tomcat.base;

public class ServletProcessor {
	public void process(HttpRequest request, HttpResponse response) {
		/**
		 * 1.解析url里面的servlet的name
		 *  2.通过URLClassLoader装载servlet类
		 *  3. 调用servlet类的service方法 struts, springmvc, webx
		 */
		
		
	}
}
