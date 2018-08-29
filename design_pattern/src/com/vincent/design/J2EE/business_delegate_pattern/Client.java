package com.vincent.design.J2EE.business_delegate_pattern;

public class Client {

	private BusinessDelegate businessService;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(BusinessDelegate businessService) {
		this.businessService = businessService;
	}

	public void doTask() {
		businessService.doTask();
	}

}
