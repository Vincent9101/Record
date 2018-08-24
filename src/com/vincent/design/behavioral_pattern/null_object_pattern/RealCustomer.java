package com.vincent.design.behavioral_pattern.null_object_pattern;

public class RealCustomer extends AbstractCustomer {

	public RealCustomer(String name) {
		// TODO Auto-generated constructor stub
		setName(name);
	}

	@Override
	public boolean isNill() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
