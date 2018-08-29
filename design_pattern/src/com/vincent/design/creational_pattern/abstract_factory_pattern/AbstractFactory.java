package com.vincent.design.creational_pattern.abstract_factory_pattern;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * TODO:后续应该考虑写成XML配置模式
 */
public abstract class AbstractFactory {

	public abstract Color getColor(String color);

	public abstract Shape getShape(String shape);

	protected static Properties shapeWithColorProperties;

	static {
		shapeWithColorProperties = new Properties();
		InputStream inputStream = AbstractFactory.class.getClassLoader()
				.getResourceAsStream("shapeWithColor.properties");
		try {
			shapeWithColorProperties = new Properties();
			shapeWithColorProperties.load(inputStream);
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

}
