package com.vincent.design.creational_pattern.factory_pattern;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.vincent.design.creational_pattern.factory_pattern.Shape;


public class ShapeFactory {

	

	private static Properties shapeProperties;
	static {
		shapeProperties = new Properties();
		InputStream inputStream = ShapeFactory.class.getClassLoader().getResourceAsStream("shape.properties");
		try {
			shapeProperties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public ShapeFactory() {
		// TODO Auto-generated constructor stub
	}

	public static Shape getShape(String shapeName) {
		Shape shape = null;
		try {
			Class clazz = Class.forName(shapeProperties.getProperty(shapeName));
			shape = (Shape) clazz.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return shape;
	}

}
