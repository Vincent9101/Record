package com.vincent.design.creational_pattern.singleton_pattern;

public class Singleton_support_multithread {

	private Singleton_support_multithread() {
		// TODO Auto-generated constructor stub
	}

	private static volatile Singleton_support_multithread instance;

	/**
	 * 第一个判断可以减少锁住对象的情况 如果不为空直接返回 效率更高 
	 * 第二个判断就是懒加载的判断
	 * 
	 * @return
	 */
	public static Singleton_support_multithread getInstance() {
		if (instance == null) {
			synchronized (Singleton_support_multithread.class) {
				if (instance == null)
					instance = new Singleton_support_multithread();
			}
		}

		return instance;
	}

}
