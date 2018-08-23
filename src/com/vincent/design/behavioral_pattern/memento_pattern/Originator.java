package com.vincent.design.bahaivoral_pattern.memento_pattern;

/**
 * 
 * @author Vincent
 * 
 *         发起者角色(Originator)： 负责创建一个备忘录用以记录当前时刻它的内部状态，并可以使用备忘录恢复内部状态。
 *
 */
public class Originator {

	private String state;

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	public Memento saveStateToMemento() {
		return new Memento(state);
	}

	/**
	 * 
	 * @param memento
	 *            <p>
	 * 			从管理者哪里恢复获得备忘录对象数据
	 *            </p>
	 */
	public void recovery(Memento memento) {
		state = memento.getState();
	}

	public Originator() {
		// TODO Auto-generated constructor stub
	}

}
