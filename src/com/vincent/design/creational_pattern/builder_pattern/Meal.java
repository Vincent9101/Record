package com.vincent.design.creational_pattern.builder_pattern;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.AALOAD;

public class Meal {

	private List<MealItem> items=new ArrayList<>();

	public Meal() {
		// TODO Auto-generated constructor stub
	}

	public void addItem(MealItem itemParam) {
		items.add(itemParam);
	}

	public void addItems(List<MealItem> itemsParam) {
		items.addAll(itemsParam);
	}

	public float getCost() {
		float cost = 0.0f;
		for (MealItem item : items) {
			cost += item.price(); 
		}

		return cost;
	}

	public void showMealItems() {
		for (MealItem item : items) {
			System.out.println("name:" + item.name());
			System.out.println("price:" + item.price());
			System.out.println("packing:" + item.packing().pack());
		}
	}

}
