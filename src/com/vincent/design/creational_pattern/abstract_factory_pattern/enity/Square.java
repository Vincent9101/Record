package com.vincent.design.creational_pattern.abstract_factory_pattern.enity;

import com.vincent.design.creational_pattern.abstract_factory_pattern.Shape;

public class Square implements Shape {

	public Square() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
			System.out.println("in square draw");
	}

}
