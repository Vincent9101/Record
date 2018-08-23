package com.vincent.design.bahaivoral_pattern.observer_pattern;

/**
 * 
 * @author Vincent
 * <p>八进制</p>
 *
 */
public class OctalObserver extends Observer {

	public OctalObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
	}
}