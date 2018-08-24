package com.vincent.design;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.vincent.design.behavioral_pattern.chain_of_resonsibility_pattern.AbstractLogger;
import com.vincent.design.behavioral_pattern.chain_of_resonsibility_pattern.ConsoleLogger;
import com.vincent.design.behavioral_pattern.chain_of_resonsibility_pattern.ErrorLogger;
import com.vincent.design.behavioral_pattern.chain_of_resonsibility_pattern.FileLogger;
import com.vincent.design.behavioral_pattern.command_pattern.Broker;
import com.vincent.design.behavioral_pattern.command_pattern.BuyStock;
import com.vincent.design.behavioral_pattern.command_pattern.SellStock;
import com.vincent.design.behavioral_pattern.command_pattern.Stock;
import com.vincent.design.behavioral_pattern.iterator_pattern.Iterator;
import com.vincent.design.behavioral_pattern.iterator_pattern.NameRepsitory;
import com.vincent.design.behavioral_pattern.mediator_pattern.User;
import com.vincent.design.behavioral_pattern.memento_pattern.CareTaker;
import com.vincent.design.behavioral_pattern.memento_pattern.Originator;
import com.vincent.design.behavioral_pattern.observer_pattern.BinaryObserver;
import com.vincent.design.behavioral_pattern.observer_pattern.HexObserver;
import com.vincent.design.behavioral_pattern.observer_pattern.OctalObserver;
import com.vincent.design.behavioral_pattern.observer_pattern.Subject;
import com.vincent.design.behavioral_pattern.state_pattern.Context;
import com.vincent.design.behavioral_pattern.state_pattern.StartState;
import com.vincent.design.behavioral_pattern.state_pattern.StopState;
import com.vincent.design.creational_pattern.abstract_factory_pattern.AbstractFactory;
import com.vincent.design.creational_pattern.abstract_factory_pattern.Color;
import com.vincent.design.creational_pattern.abstract_factory_pattern.FactoryProducer;
import com.vincent.design.creational_pattern.builder_pattern.Meal;
import com.vincent.design.creational_pattern.builder_pattern.MealBuilder;
import com.vincent.design.creational_pattern.factory_pattern.Shape;
import com.vincent.design.creational_pattern.factory_pattern.ShapeFactory;
import com.vincent.design.creational_pattern.prototype_pattern.ShapeCache;
import com.vincent.design.structural_pattern.adapter_pattern.entity.AudioPlayer;
import com.vincent.design.structural_pattern.bridge_pattern.GreenCircle;
import com.vincent.design.structural_pattern.bridge_pattern.RedCircle;
import com.vincent.design.structural_pattern.composite_pattern.Employee;
import com.vincent.design.structural_pattern.decorator_pattern.ShapeDecorator;
import com.vincent.design.structural_pattern.decorator_pattern.entity.Circle;
import com.vincent.design.structural_pattern.decorator_pattern.entity.Rectangle;
import com.vincent.design.structural_pattern.decorator_pattern.entity.RedShapeDecorator;
import com.vincent.design.structural_pattern.facade_pattern.Computer;
import com.vincent.design.structural_pattern.filter_pattern.Criteria;
import com.vincent.design.structural_pattern.filter_pattern.entity.AndCriteria;
import com.vincent.design.structural_pattern.filter_pattern.entity.CriteriaFemale;
import com.vincent.design.structural_pattern.filter_pattern.entity.CriteriaMale;
import com.vincent.design.structural_pattern.filter_pattern.entity.CriteriaSingle;
import com.vincent.design.structural_pattern.filter_pattern.entity.OrCriteria;
import com.vincent.design.structural_pattern.filter_pattern.entity.Person;
import com.vincent.design.structural_pattern.proxy_pattern.Image;
import com.vincent.design.structural_pattern.proxy_pattern.ImageEntity;
import com.vincent.design.structural_pattern.proxy_pattern.ProxyImage;

public class TestDemo {

	@Test
	public void test_state() {
		Context context = new Context();
		new StartState().doAction(context);
		System.out.println(context.getState().toString());
		new StopState().doAction(context);
		System.out.println(context.getState().toString());
	}

	// @Test
	public void test_observer() {
		Subject subject = new Subject();

		new HexObserver(subject);
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15);
		System.out.println("Second state change: 10");
		subject.setState(10);
	}

	// @Test
	public void test_memento() {
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		originator.setState("State #1");
		originator.setState("State #2");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("State #3");
		careTaker.add(originator.saveStateToMemento());
		originator.setState("State #4");

		System.out.println("Current State: " + originator.getState());
		originator.recovery(careTaker.get(0));
		System.out.println("First saved State: " + originator.getState());
		originator.recovery(careTaker.get(1));
		System.out.println("Second saved State: " + originator.getState());

	}

	// @Test
	public void test_mediator() {
		User robert = new User("Robert");
		User john = new User("John");
		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Robert!");
	}

	// @Test
	public void test_Iterator() {

		NameRepsitory nameRepsitory = new NameRepsitory();
		for (Iterator iterato = nameRepsitory.getIterator(); iterato.hasNext();) {
			System.out.println(iterato.next());
		}

	}

	// @Test
	public void test_interpreter() {

	}

	// @Test
	public void test_command() {
		Stock abcStock = new Stock();

		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStockOrder = new SellStock(abcStock);

		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);

		broker.placeOrders();
	}

	// @Test
	public void test_chain_of_responsibility() {
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		AbstractLogger loggerChain = errorLogger;
		loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
		loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
		loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
	}

	// @Test
	public void test_proxy() {
		Image image = new ImageEntity();
		ProxyImage imgProxy = new ProxyImage(image);
		imgProxy.show();

	}

	// @Test
	public void test_flyWeight() {
		com.vincent.design.structural_pattern.flyweight_pattern.ShapeFactory.getCircle("red");
	}

	// @Test
	public void test_facade() {
		Computer computer = new Computer();
		computer.start();
		computer.shutDown();
	}

	// @Test
	public void test_decorator() {
		com.vincent.design.structural_pattern.decorator_pattern.Shape circle = new Rectangle(), rec = new Circle();
		ShapeDecorator decorator = new RedShapeDecorator(rec);
		decorator.draw();
		decorator = new RedShapeDecorator(circle);
		decorator.draw();

	}

	// @Test
	public void test_composit() {
		Employee CEO = new Employee("Vincent", "CEO", 30000);

		Employee headSales = new Employee("Robert", "Head Sales", 20000);
		Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

		Employee clerk1 = new Employee("Laura", "Marketing", 10000);
		Employee clerk2 = new Employee("Bob", "Marketing", 10000);

		Employee salesExecutive1 = new Employee("Richard", "Sales", 10000);
		Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

		CEO.add(headSales);
		CEO.add(headMarketing);

		headSales.add(salesExecutive1);
		headSales.add(salesExecutive2);

		headMarketing.add(clerk1);
		headMarketing.add(clerk2);

		System.out.println(CEO);
		for (Employee headEmployee : CEO.getSubordinates()) {
			System.out.println(headEmployee);
			for (Employee employee : headEmployee.getSubordinates()) {
				System.out.println(employee);
			}
		}
	}

	// @Test
	public void test_criteria() {
		List<Person> persons = new ArrayList<Person>();

		persons.add(new Person("Robert", "Male", "Single"));
		persons.add(new Person("John", "Male", "Married"));
		persons.add(new Person("Laura", "Female", "Married"));
		persons.add(new Person("Diana", "Female", "Single"));
		persons.add(new Person("Mike", "Male", "Single"));
		persons.add(new Person("Bobby", "Male", "Single"));

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

	public static void printPersons(List<Person> persons) {
		for (Person person : persons) {
			System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender()
					+ ", Marital Status : " + person.getMaritalStatus() + " ]");
		}
	}

	// @Test
	public void test_bridge() {
		com.vincent.design.structural_pattern.bridge_pattern.Shape redCircle, greenCircle;
		redCircle = new com.vincent.design.structural_pattern.bridge_pattern.Circle(2, 3, new RedCircle());
		greenCircle = new com.vincent.design.structural_pattern.bridge_pattern.Circle(2, 4, new GreenCircle());
		redCircle.draw();
		greenCircle.draw();
	}

	// @Test
	public void test_adapter() {
		AudioPlayer audioPlayer = new AudioPlayer();
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
