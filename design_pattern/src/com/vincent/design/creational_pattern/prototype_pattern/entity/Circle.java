package com.vincent.design.creational_pattern.prototype_pattern.entity;

import com.vincent.design.creational_pattern.prototype_pattern.Shape;

public class Circle extends Shape {

	
	public Circle() {
		// TODO Auto-generated constructor stub
		this.type = "Circle";
	}

	public void draw() {
		// TODO Auto-generated method stub

		System.out.println("drawing Circle");
	}

}
