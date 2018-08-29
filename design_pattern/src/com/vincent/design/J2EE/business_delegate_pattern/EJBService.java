package com.vincent.design.J2EE.business_delegate_pattern;

public class EJBService implements BusinessService{

	public EJBService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doProcessing() {
		// TODO Auto-generated method stub
		 System.out.println("Processing task by invoking EJB Service");
	}

}
