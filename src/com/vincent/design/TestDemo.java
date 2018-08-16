package com.vincent.design;

import java.util.ArrayList;
import java.util.List;

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
import com.vincent.design.structural_pattern.bridge_pattern.GreenCircle;
import com.vincent.design.structural_pattern.bridge_pattern.RedCircle;
import com.vincent.design.structural_pattern.filter_pattern.Criteria;
import com.vincent.design.structural_pattern.filter_pattern.entity.AndCriteria;
import com.vincent.design.structural_pattern.filter_pattern.entity.CriteriaFemale;
import com.vincent.design.structural_pattern.filter_pattern.entity.CriteriaMale;
import com.vincent.design.structural_pattern.filter_pattern.entity.CriteriaSingle;
import com.vincent.design.structural_pattern.filter_pattern.entity.OrCriteria;
import com.vincent.design.structural_pattern.filter_pattern.entity.Person;

public class TestDemo {
	  public static void printPersons(List<Person> persons){
	      for (Person person : persons) {
	         System.out.println("Person : [ Name : " + person.getName() 
	            +", Gender : " + person.getGender() 
	            +", Marital Status : " + person.getMaritalStatus()
	            +" ]");
	      }
	   }      
	@Test
	public void test_criteria() {
		 List<Person> persons = new ArrayList<Person>();
		 
	      persons.add(new Person("Robert","Male", "Single"));
	      persons.add(new Person("John","Male", "Married"));
	      persons.add(new Person("Laura","Female", "Married"));
	      persons.add(new Person("Diana","Female", "Single"));
	      persons.add(new Person("Mike","Male", "Single"));
	      persons.add(new Person("Bobby","Male", "Single"));
	 
	      Criteria male = new CriteriaMale();
	      Criteria female = new CriteriaFemale();
	      Criteria single = new CriteriaSingle();
	      Criteria singleMale = new AndCriteria(single, male);
	      Criteria singleOrFemale = new OrCriteria(single, female);
	 
	      System.out.println("Males: ");
	      printPersons(male.meetCriteria(persons));
	 
	      System.out.println("\nFemales: ");
	      printPersons(female.meetCriteria(persons));
	 
	      System.out.println("\nSingle Males: ");
	      printPersons(singleMale.meetCriteria(persons));
	 
	      System.out.println("\nSingle Or Females: ");
	      printPersons(singleOrFemale.meetCriteria(persons));
	}
//	@Test
	public void test_bridge() {
		com.vincent.design.structural_pattern.bridge_pattern.Shape redCircle,greenCircle;
		redCircle=new com.vincent.design.structural_pattern.bridge_pattern.Circle(2, 3, new RedCircle());
		greenCircle=new com.vincent.design.structural_pattern.bridge_pattern.Circle(2, 4, new GreenCircle());
		redCircle.draw();
		greenCircle.draw();
	}
	
//	@Test
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
