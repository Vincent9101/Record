package com.vincent.design.creational_pattern.builder_pattern;

import com.vincent.design.creational_pattern.builder_pattern.entity.Wrapper;

public abstract class Burger implements MealItem{

	public Burger() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return new Wrapper();
	}
	
	public abstract float price();


}
