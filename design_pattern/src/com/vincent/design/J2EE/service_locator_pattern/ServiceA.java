package com.vincent.design.J2EE.service_locator_pattern;

public class ServiceA implements Service {

	public ServiceA() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ServiceA";
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Executing ServiceA");
	}

}
