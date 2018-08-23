package com.vincent.design.behavioral_pattern.observer_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Vincent
 *         <p>
 *         被监听的对象
 *         </p>
 *
 */
public class Subject {

	private int state;
	private List<Observer> observerList = new ArrayList<Observer>();

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public void attach(Observer observer) {
		observerList.add(observer);
	}
	public void notifyAllObservers() {
		for(Observer observer:observerList)
		{
			observer.update();
		}
	}
}
