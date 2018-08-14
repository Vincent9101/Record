package com.vincent.design;

import com.vincent.design.creational_pattern.abstract_factory_pattern.AbstractFactory;
import com.vincent.design.creational_pattern.abstract_factory_pattern.Color;
import com.vincent.design.creational_pattern.abstract_factory_pattern.FactoryProducer;
import com.vincent.design.creational_pattern.abstract_factory_pattern.entity.Circle;
import com.vincent.design.creational_pattern.abstract_factory_pattern.entity.Square;
import com.vincent.design.creational_pattern.factory_pattern.Shape;
import com.vincent.design.creational_pattern.factory_pattern.ShapeFactory;
import org.junit.Test;

public class TestDemo {

	@Test
	public void test_abstractFactory() {
	
		AbstractFactory shapeFac = FactoryProducer.getFactory("ShapeFactory");
		com.vincent.design.creational_pattern.abstract_factory_pattern.Shape rec = shapeFac.getShape("Rectangle");
		com.vincent.design.creational_pattern.abstract_factory_pattern.Shape cricle = shapeFac.getShape("Circle");
		com.vincent.design.creational_pattern.abstract_factory_pattern.Shape square = shapeFac.getShape("Square");

		rec.draw();
		cricle.draw();
		square.draw();

		AbstractFactory colorFac = FactoryProducer.getFactory("ColorFactory");
		Color red = colorFac.getColor("Red");
		Color blue = colorFac.getColor("Blue");
		Color green = colorFac.getColor("Green");
		
		red.fill();
		blue.fill();
		green.fill();

	}

//	 @Test
	public void test_factory() {
		// TODO Auto-generated constructor stub
		Shape rec = ShapeFactory.getShape("Rectangle");
		Shape circle = ShapeFactory.getShape("Circle");
		Shape square = ShapeFactory.getShape("Square");
		rec.draw();
		circle.draw();
		square.draw();
	}

}
