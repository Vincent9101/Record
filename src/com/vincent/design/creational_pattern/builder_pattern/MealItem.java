package com.vincent.design.creational_pattern.builder_pattern;

import com.vincent.design.creational_pattern.builder_pattern.entity.Packing;

public interface MealItem {

	public Packing packing();
	public float price();
	public String name();
}
