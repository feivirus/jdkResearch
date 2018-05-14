package com.feivirus.designpattern.behavior.chainofresponsibility.pattern1;

public class SensitiveFilter implements Filter{

	public void doFilter(Request request, Response response, FilterChain filterChain) {
			String content = request.getRequestMsg();
			
			content = content.replace('2', 'b');
			request.setRequestMsg(content + "<sensitive>--");
			//response.setResponseMsg(content + "<sensitive>");
			
			filterChain.doFilter(request, response, filterChain);
			String responseContent = response.getResponseMsg();
			responseContent = responseContent + "--<sensitive>";
			response.setResponseMsg(responseContent);
	}

}
