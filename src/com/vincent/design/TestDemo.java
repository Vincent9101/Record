package com.vincent.design;

import org.junit.Test;

import com.vincent.design.creational_pattern.abstract_factory_pattern.AbstractFactory;
import com.vincent.design.creational_pattern.abstract_factory_pattern.Color;
import com.vincent.design.creational_pattern.abstract_factory_pattern.FactoryProducer;
import com.vincent.design.creational_pattern.builder_pattern.Meal;
import com.vincent.design.creational_pattern.builder_pattern.MealBuilder;
import com.vincent.design.creational_pattern.factory_pattern.Shape;
import com.vincent.design.creational_pattern.factory_pattern.ShapeFactory;
import com.vincent.design.creational_pattern.prototype_pattern.ShapeCache;
import com.vincent.design.structural_pattern.adapter_pattern.AudioPlayer;

public class TestDemo {
	
	
	@Test
	public void test_adapter() {
		AudioPlayer audioPlayer=new AudioPlayer();
		audioPlayer.play("mp3", "仙劍");
		audioPlayer.play("Mp4", "蠟筆小新");
		audioPlayer.play("Vlc", "叮噹貓");
		audioPlayer.play("mmp", "啊呸");
	
		
	}

	// @Test
	public void test_prototype() {
		ShapeCache.loadShapeCache();
		com.vincent.design.creational_pattern.prototype_pattern.Shape circle = (com.vincent.design.creational_pattern.prototype_pattern.Shape) ShapeCache
				.getShape("Circle1");
		com.vincent.design.creational_pattern.prototype_pattern.Shape circle2 = (com.vincent.design.creational_pattern.prototype_pattern.Shape) ShapeCache
				.getShape("Circle1");
		// 说明了是克隆的内容一样但不是一个对象	
		System.out.println(circle == circle2);
	}

	// @Test
	public void test_builder() {
		MealBuilder builder = new MealBuilder();
		Meal nonVegMeal = builder.getNonVegMeal();
		Meal vegMeal = builder.getVegMeal();
		System.out.println("nonVegMeal  " + nonVegMeal.getCost());
		nonVegMeal.showMealItems();

		System.out.println("-----\nvegMeal  " + vegMeal.getCost());
		vegMeal.showMealItems();

	}

	// @Test
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

	// @Test
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
