package com.vincent.design.creational_pattern.prototype_pattern.entity;

import com.vincent.design.creational_pattern.prototype_pattern.Shape;

public class Square extends Shape {

	private String type;
	public Square() {
		// TODO Auto-generated constructor stub
		type = "Square";
	}

	public void draw() {
		// TODO Auto-generated method stub

		System.out.println("drawing Square");
	}

}
