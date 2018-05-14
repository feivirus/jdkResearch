package com.feivirus.designpattern.behavior.chainofresponsibility;

import com.feivirus.designpattern.behavior.chainofresponsibility.base.Filter;
import com.feivirus.designpattern.behavior.chainofresponsibility.base.FilterChain;
import com.feivirus.designpattern.behavior.chainofresponsibility.base.Request;
import com.feivirus.designpattern.behavior.chainofresponsibility.base.Response;

public class HTMLFilter  implements Filter{

	public void doFilter(Request request, Response response, FilterChain filterChain) {
		String content = request.getRequestMsg();
		
		content = content.replace('1', 'a');
		request.setRequestMsg(content);
		//response.setResponseMsg(content + "<html>--");
		
		filterChain.doFilter(request, response, filterChain);
		String responseMsg = response.getResponseMsg();
		responseMsg += "--<html>";
		response.setResponseMsg(responseMsg);
	}
}
