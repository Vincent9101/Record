package com.vincent.design.creational_pattern.builder_pattern;

/**
 * 套餐项目
 * @author vincent
 *
 */
public interface MealItem {

	public Packing packing();
	public float price();
	public String name();
}
