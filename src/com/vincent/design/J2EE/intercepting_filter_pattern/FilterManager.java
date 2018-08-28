package com.vincent.design.J2EE.intercepting_filter_pattern;

public class FilterManager {

	public FilterManager() {
		// TODO Auto-generated constructor stub
	}

	FilterChain filterChain;

	public FilterManager(Target target) {
		filterChain = new FilterChain();
		filterChain.setTarget(target);
	}

	public void setFilter(Filter filter) {
		filterChain.addFilter(filter);
	}

	public void filterRequest(String request) {
		filterChain.execute(request);
	}
}
