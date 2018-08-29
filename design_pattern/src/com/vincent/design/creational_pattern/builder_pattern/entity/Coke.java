package com.vincent.design.creational_pattern.builder_pattern.entity;

import com.vincent.design.creational_pattern.builder_pattern.ColdDrink;

public class Coke extends ColdDrink {

	public Coke() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Coke cola";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 88.88f;
	}

}
