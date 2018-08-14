package com.vincent.design.creational_pattern.abstract_factory_pattern.enity;

import com.vincent.design.creational_pattern.abstract_factory_pattern.Shape;

public class Rectangle implements Shape {

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("in rectangle draw");
	}

}
