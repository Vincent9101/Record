package com.vincent.design.behavioral_pattern.null_object_pattern;

public abstract class AbstractCustomer {

	protected String name;

	public abstract boolean isNill();

	public abstract String getName();

	public void setName(String name) {
		this.name = name;
	}

}
