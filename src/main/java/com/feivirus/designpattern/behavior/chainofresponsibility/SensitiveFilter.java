package com.feivirus.designpattern.behavior.chainofresponsibility;

import com.feivirus.designpattern.behavior.chainofresponsibility.base.Filter;
import com.feivirus.designpattern.behavior.chainofresponsibility.base.FilterChain;
import com.feivirus.designpattern.behavior.chainofresponsibility.base.Request;
import com.feivirus.designpattern.behavior.chainofresponsibility.base.Response;

public class SensitiveFilter implements Filter{

	public void doFilter(Request request, Response response, FilterChain filterChain) {
			String content = request.getRequestMsg();
			
			content = content.replace('2', 'b');
			request.setRequestMsg(content);
			response.setResponseMsg(content + "<sensitive>");
			
			filterChain.doFilter(request, response, filterChain);
			String responseContent = response.getResponseMsg();
			responseContent = responseContent + "--<sensitive>";
			response.setResponseMsg(responseContent);
	}

}
