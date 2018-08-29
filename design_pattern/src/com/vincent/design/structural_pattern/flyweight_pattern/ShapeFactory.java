package com.vincent.design.structural_pattern.flyweight_pattern;

import java.util.HashMap;
import java.util.Map;

import com.sun.org.glassfish.external.statistics.Statistic;
import com.vincent.design.structural_pattern.flyweight_pattern.entity.Circle;

public class ShapeFactory {

	public ShapeFactory() {
		// TODO Auto-generated constructor stub
		super();

	}

	private static final Map<String, Circle> circle = new HashMap<String, Circle>();

	public static Shape getCircle(String color) {

		if (circle.get(color) == null) {
			System.out.println("created  a new circle");
			circle.put(color, new Circle());
		}
		return circle.get(color);
	}

}
