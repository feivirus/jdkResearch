package com.feivirus.designpattern.behavior.chainofresponsibility.base;

public interface Filter {
	public void doFilter(Request request, Response response, FilterChain filterChain) ;
}
