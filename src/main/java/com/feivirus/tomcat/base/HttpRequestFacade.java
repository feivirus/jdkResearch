package com.feivirus.tomcat.base;

public class HttpRequestFacade {
	private HttpServletRequest request;
	
	public HttpRequestFacade(HttpRequest request) {
		this.request = request;
	}
}
