package com.vincent.design.J2EE.intercepting_filter_pattern;

public class Target {

	public Target() {
		// TODO Auto-generated constructor stub
	}

	public void execute(String request) {
		System.out.println("Executing request: " + request);
	}
}
