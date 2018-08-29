package com.vincent.design.creational_pattern.abstract_factory_pattern;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.org.glassfish.external.statistics.Statistic;

public class ShapeFactory extends AbstractFactory {


	public ShapeFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getColor(String colorName) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public Shape getShape(String shapeName) {
		// TODO Auto-generated method stub
		Shape shape = null;
		try {
			shape = (Shape) Class.forName(shapeWithColorProperties.getProperty(shapeName)).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shape;
	}

}
