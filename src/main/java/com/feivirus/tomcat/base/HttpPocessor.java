package com.feivirus.tomcat.base;

import java.io.OutputStream;
import java.net.Socket;


public class HttpPocessor {
	private HttpConnector connector;
	
	private HttpRequest request;
	
	private HttpResponse response;
	
	HttpPocessor(HttpConnector httpConnector) {
		this.connector = httpConnector;
	}
	
	public void process(Socket socket) {
		SocketInputStream input  = null;
		OutputStream output = null;
		
		try {
			input = new SocketInputStream(socket.getInputStream(), 2048);
			output = socket.getOutputStream();
			
			request = new HttpRequest(input);
			
			response = new HttpResponse(output);
			response.setRequest(request);
			response.setHeader("Server", "feivirus Servlet Container");
			
			//parseRequest(input, output);
			//parseHeaders(input);
			
			if (request.getRequestURI().startsWith("/servlet/")) {
				ServletProcessor processor = new ServletProcessor();
				processor.process(request, response);
			} else {
				StaticResourceProcessor processor = new StaticResourceProcessor();
				processor.process(request, response);
			}
			
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
