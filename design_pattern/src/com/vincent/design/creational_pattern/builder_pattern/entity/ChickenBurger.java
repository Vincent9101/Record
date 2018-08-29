package com.vincent.design.creational_pattern.builder_pattern.entity;

import com.vincent.design.creational_pattern.builder_pattern.Burger;

public class ChickenBurger extends Burger {

	public ChickenBurger() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "chicken burger";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 55.5f;	}
 
}
