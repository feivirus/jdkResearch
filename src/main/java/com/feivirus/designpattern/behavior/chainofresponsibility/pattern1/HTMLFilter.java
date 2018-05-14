package com.feivirus.designpattern.behavior.chainofresponsibility.pattern1;

public class HTMLFilter  implements Filter{

	public void doFilter(Request request, Response response, FilterChain filterChain) {
		String content = request.getRequestMsg();
		
		content = content.replace('1', 'a');
		request.setRequestMsg(content + "<html>--");
		//response.setResponseMsg(content + "<html>--");
		
		filterChain.doFilter(request, response, filterChain);
		String responseMsg = response.getResponseMsg();
		responseMsg += "--<html>";
		response.setResponseMsg(responseMsg);
	}
}
