package com.vincent.design.J2EE.business_delegate_pattern;

public class BusinessDelegate {

	public BusinessDelegate() {
		// TODO Auto-generated constructor stub
	}

	private BusinessLookup lookupService = new BusinessLookup();
	private BusinessService businessService;
	private String serviceType;

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public void doTask() {
		businessService = lookupService.getBusinessService(serviceType);
		businessService.doProcessing();
	}
}
