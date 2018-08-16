package com.vincent.design.structural_pattern.bridge_pattern;

import static org.hamcrest.CoreMatchers.notNullValue;

public class Circle extends Shape {

	private int x, y, radius;

	public Circle(int x, int y, DrawAPI drawAPIParam) {
		// TODO Auto-generated constructor stub
		super(drawAPIParam);
		this.x = x;
		this.y = y;

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		drawAPI.drawCircle(radius, x, y);

	}

}
