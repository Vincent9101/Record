package com.vincent.design.J2EE.intercepting_filter_pattern;

public class AuthenticationFilter implements Filter {

	public AuthenticationFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(String request) {
		// TODO Auto-generated method stub
		System.out.println("Authenticating request: " + request);

	}

}
