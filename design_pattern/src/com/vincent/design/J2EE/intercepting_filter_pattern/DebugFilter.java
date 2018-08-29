package com.vincent.design.J2EE.intercepting_filter_pattern;

public class DebugFilter implements Filter {

	public DebugFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(String request) {
		// TODO Auto-generated method stub
		System.out.println("request log: " + request);

	}

}
