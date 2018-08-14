package com.vincent.design.creational_pattern.singleton_pattern;

/**
 * 
 * @author Vincent
 * 登记注册式 单例
 * 这里其实与前面的饿汉单例模式有点类似 但是由于利用了ClassLoaderDe特性 
 * 使在不调用的getInstance的时候不会初始化instance 实现了懒加载
 *
 */

public class Singleton_register {

	private static class SingletonHolder {
		private static Singleton_register instance = new Singleton_register();
	}

	private Singleton_register() {
		// TODO Auto-generated constructor stub
	}

	public static final Singleton_register getInstance() {
		return SingletonHolder.instance;
	}

}
