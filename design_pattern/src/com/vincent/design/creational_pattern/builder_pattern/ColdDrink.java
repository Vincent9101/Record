package com.vincent.design.creational_pattern.builder_pattern;

import com.vincent.design.creational_pattern.builder_pattern.entity.Bottle;

public abstract class ColdDrink implements MealItem{

	public ColdDrink() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Packing packing() {
		// TODO Auto-generated method stub
		return new Bottle();
	}


	public abstract float price();


}
