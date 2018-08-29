package com.vincent.design.creational_pattern.singleton_pattern;

public class Singleton_unsupport_multithread {

	private Singleton_unsupport_multithread() {
		// TODO Auto-generated constructor stub
	}

	private static Singleton_unsupport_multithread instance;

	public static Singleton_unsupport_multithread getSingleton() {

		if (instance == null) {
			instance = new Singleton_unsupport_multithread();
		}

		return instance;
	}

	public void println() {
		System.out.println("In unsupport_multithread");
	}

}
