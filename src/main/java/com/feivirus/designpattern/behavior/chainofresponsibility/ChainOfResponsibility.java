package com.feivirus.designpattern.behavior.chainofresponsibility;

import com.feivirus.designpattern.behavior.chainofresponsibility.base.FilterChain;
import com.feivirus.designpattern.behavior.chainofresponsibility.base.Request;
import com.feivirus.designpattern.behavior.chainofresponsibility.base.Response;

/**
 * 职责链模式
 * @author feivirus
 * 参考链接: https://www.cnblogs.com/ysw-go/p/5432921.html
 */
public class ChainOfResponsibility {
	public static void main(String[] args) {
		Request request = new Request();
		Response response = new Response();
		FilterChain filterChain = new FilterChain();
		
		request.setRequestMsg("123456abcdefg");
		response.setResponseMsg("");
		filterChain.addFilter(new HTMLFilter()).addFilter(new SensitiveFilter());
		filterChain.doFilter(request, response, filterChain);
		
		System.out.println("request: " + request.getRequestMsg());
		System.out.println("response: " + response.getResponseMsg());
	}
}
