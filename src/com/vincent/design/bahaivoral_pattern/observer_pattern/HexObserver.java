package com.vincent.design.bahaivoral_pattern.observer_pattern;

/**
 * 
 * @author Vincent
 *
 */
public class HexObserver extends Observer {

	public HexObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
	}
}