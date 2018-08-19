package com.vincent.design.structural_pattern.flyweight_pattern.entity;

import com.vincent.design.structural_pattern.flyweight_pattern.Shape;

public class Circle implements Shape {

	private int x;
	private int y;
	private int radius;
	private String color;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", radius=" + radius + ", color=" + color + "]";
	}

	public Circle(int x, int y, int radius, String color) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
	}

	public Circle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius
	 *            the radius to set
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass() + "is drawing\n" + this);
	}

}
