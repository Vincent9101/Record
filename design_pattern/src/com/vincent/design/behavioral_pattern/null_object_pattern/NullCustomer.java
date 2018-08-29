package com.vincent.design.behavioral_pattern.null_object_pattern;

public class NullCustomer extends AbstractCustomer {

	public NullCustomer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isNill() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Not Available in Customer Database";
	}

}
