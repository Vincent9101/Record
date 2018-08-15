package com.vincent.design.creational_pattern.builder_pattern;

import com.vincent.design.creational_pattern.builder_pattern.entity.ChickenBurger;
import com.vincent.design.creational_pattern.builder_pattern.entity.Coke;
import com.vincent.design.creational_pattern.builder_pattern.entity.Pepsi;
import com.vincent.design.creational_pattern.builder_pattern.entity.VegBurger;

public class MealBuilder {

	public MealBuilder() {
		// TODO Auto-generated constructor stub
	}

	public Meal getVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;

	}

	public Meal getNonVegMeal() {
		Meal meal = new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;

	}

}
