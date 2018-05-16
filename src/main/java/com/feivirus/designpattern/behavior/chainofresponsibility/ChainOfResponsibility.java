package com.feivirus.designpattern.behavior.chainofresponsibility;

import com.feivirus.designpattern.behavior.chainofresponsibility.pattern1.FilterChain;
import com.feivirus.designpattern.behavior.chainofresponsibility.pattern1.HTMLFilter;
import com.feivirus.designpattern.behavior.chainofresponsibility.pattern1.Request;
import com.feivirus.designpattern.behavior.chainofresponsibility.pattern1.Response;
import com.feivirus.designpattern.behavior.chainofresponsibility.pattern1.SensitiveFilter;
import com.feivirus.designpattern.behavior.chainofresponsibility.pattern2.DeptManager;
import com.feivirus.designpattern.behavior.chainofresponsibility.pattern2.Handler;
import com.feivirus.designpattern.behavior.chainofresponsibility.pattern2.ProjectManager;

/**
 * 职责链模式
 * @author feivirus
 * 参考链接: https://www.cnblogs.com/ysw-go/p/5432921.html
 */
public class ChainOfResponsibility {
	public static void main(String[] args) {
		//patter1
		Request request = new Request();
		Response response = new Response();
		FilterChain filterChain = new FilterChain();
		
		request.setRequestMsg("123456abcdefg");
		response.setResponseMsg("");
		filterChain.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
		filterChain.doFilter(request, response, filterChain);
		
		System.out.println("request: " + request.getRequestMsg());
		System.out.println("response: " + response.getResponseMsg());
		
		//patter2
		Handler deptManager = new DeptManager();
		Handler projectManager = new ProjectManager();
		
		projectManager.setSuccessor(deptManager);
		
		String result = projectManager.handleRequest("hello", 100);
		System.out.println(result);
		result = projectManager.handleRequest("feivirus", 800);
		System.out.println(result);
		result = projectManager.handleRequest("feivirus", 5000);
		System.out.println("结果" + result);
	}
}
