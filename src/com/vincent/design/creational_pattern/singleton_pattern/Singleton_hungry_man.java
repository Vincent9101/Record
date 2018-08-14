package com.vincent.design.creational_pattern.singleton_pattern;

/**
 * 
 * @author Vincent
 * 线程安全 但是容易产生垃圾对象，没有加锁执行效率会比较高 
 * 但不是懒加载 类一加载的时候就进行初始化 浪费内存
 *
 */
public class Singleton_hungry_man {

	private Singleton_hungry_man() {
		// TODO Auto-generated constructor stub
	}

	private static Singleton_hungry_man instance = new Singleton_hungry_man();

	public static Singleton_hungry_man getInstance() {

		return instance;

	}

}
