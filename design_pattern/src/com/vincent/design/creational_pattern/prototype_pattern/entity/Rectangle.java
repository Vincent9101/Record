package com.vincent.design.creational_pattern.prototype_pattern.entity;

import com.vincent.design.creational_pattern.prototype_pattern.Shape;

public class Rectangle extends Shape {

	private String type;
	public Rectangle() {
		// TODO Auto-generated constructor stub
		type = "Rectangle";
	}

	public void draw() {
		// TODO Auto-generated method stub

		System.out.println("drawing Rectangle");
	}

}
