package com.vincent.design.creational_pattern.builder_pattern.entity;

import com.vincent.design.creational_pattern.builder_pattern.Burger;

public class VegBurger extends Burger{

	public VegBurger() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "vegbuger";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 33.5f;
	}

}
