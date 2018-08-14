package com.vincent.design.creational_pattern.abstract_factory_pattern;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author Vincent 工厂创造器: 用于创建工厂
 */
public class FactoryProducer {

	public FactoryProducer() {
		// TODO Auto-generated constructor stub
	}

	private static Properties shapeWithColorProperties;

	static {
		shapeWithColorProperties=new Properties();
		InputStream inputStream = FactoryProducer.class.getClassLoader().getResourceAsStream("shapeWithColor.properties");
		try {
			shapeWithColorProperties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}

	public static AbstractFactory getFactory(String factoryName) {
		AbstractFactory abstractFactory = null;

		try {
			abstractFactory = (AbstractFactory) Class.forName(shapeWithColorProperties.getProperty(factoryName)).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return abstractFactory;

	}

}
