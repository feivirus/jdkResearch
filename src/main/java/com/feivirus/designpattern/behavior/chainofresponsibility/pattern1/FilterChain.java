package com.feivirus.designpattern.behavior.chainofresponsibility.pattern1;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{
	private List<Filter> filterList = new ArrayList<Filter>();
	
	private int index = 0;
	
	public FilterChain addFilter(Filter filter) {
		filterList.add(filter);
		return this;
	}

	public void doFilter(Request request, Response response, FilterChain filterChain) {
		if (index == filterList.size()) {
			response.setResponseMsg(request.getRequestMsg());
			return;
		}
		
		Filter filter = filterList.get(index);
		index++;
		filter.doFilter(request, response, filterChain);
	}
}
