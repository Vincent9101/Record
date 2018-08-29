package com.vincent.design.structural_pattern.decorator_pattern.entity;

import com.vincent.design.structural_pattern.decorator_pattern.Shape;
import com.vincent.design.structural_pattern.decorator_pattern.ShapeDecorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape shape) {
		super(shape);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shapeDecorating(Shape shape) {
		// TODO Auto-generated method stub
		
			System.out.println("变成红色");
				
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		shape.draw();
		shapeDecorating(shape);
	   
	}

}
