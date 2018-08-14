package com.vincent.design.creational_pattern.builder_pattern;

public interface MealItem {

	public Packing packing();
	public float price();
	public String name();
}
