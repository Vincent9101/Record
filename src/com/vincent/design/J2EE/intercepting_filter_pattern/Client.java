package com.vincent.design.J2EE.intercepting_filter_pattern;

public class Client {

	private FilterManager filterManager;

	public void setFilterManager(FilterManager filterManager) {
		this.filterManager = filterManager;
	}

	public void sendRequest(String request) {
		filterManager.filterRequest(request);
	}

}
