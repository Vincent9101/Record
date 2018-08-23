package com.vincent.design.behavioral_pattern.memento_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Vincent
 * 
 * 管理者角色(CareTaker)：负责保存好备忘录。
 *
 */
public class CareTaker {

	public CareTaker() {
		// TODO Auto-generated constructor stub
	}

	private List<Memento> mementoList = new ArrayList<Memento>();

	public void add(Memento state) {
		mementoList.add(state);
	}

	public Memento get(int index) {
		return mementoList.get(index);
	}
}
