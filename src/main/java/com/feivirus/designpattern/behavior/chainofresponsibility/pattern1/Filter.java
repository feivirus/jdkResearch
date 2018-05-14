package com.feivirus.designpattern.behavior.chainofresponsibility.pattern1;

public interface Filter {
	public void doFilter(Request request, Response response, FilterChain filterChain) ;
}
