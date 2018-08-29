package com.vincent.design.behavioral_pattern.memento_pattern;
/**
 * 
 * @author Vincent
 * 
 * 备忘录角色(Memento):
 * 负责存储Originator对象的内部状态，并可以防止Originator以外的其他对象访问备忘录。
 *
 */
public class Memento {

	private String state;

	public Memento(String state) {
		// TODO Auto-generated constructor stub
		this.state = state;

	}

	public String getState() {
		return state;
	}

}
