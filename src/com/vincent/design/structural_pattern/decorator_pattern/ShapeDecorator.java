package com.vincent.design.structural_pattern.decorator_pattern;

public abstract class ShapeDecorator implements Shape {

	protected Shape shape;

	public ShapeDecorator(Shape shape) {
		this.shape = shape;
	}

	public abstract void shapeDecorating(Shape shape);

	@Override
	public abstract void draw();

}
