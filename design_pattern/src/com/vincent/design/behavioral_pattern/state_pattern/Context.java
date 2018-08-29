package com.vincent.design.behavioral_pattern.state_pattern;

public class Context {

	private State state;

	/**
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(State state) {
		this.state = state;
	}

	public Context() {
		// TODO Auto-generated constructor stub
	}

}
