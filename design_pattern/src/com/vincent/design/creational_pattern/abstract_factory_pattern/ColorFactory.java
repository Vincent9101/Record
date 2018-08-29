package com.vincent.design.creational_pattern.abstract_factory_pattern;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sun.net.www.content.text.plain;

public class ColorFactory extends AbstractFactory {

	public ColorFactory() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public Color getColor(String colorName) {
		// TODO Auto-generated method stub

		Color color = null;
		try {
			color = (Color) Class.forName(shapeWithColorProperties.getProperty(colorName)).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return color;
	}

	@Override
	public Shape getShape(String shape) {
		// TODO Auto-generated method stub
		return null;
	}

}
