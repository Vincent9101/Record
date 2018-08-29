package com.vincent.design.behavioral_pattern.state_pattern;

public class StopState implements State {

	public StopState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Context context) {
		// TODO Auto-generated method stub
		System.out.println("Plaer is in stop state");
		context.setState(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stop State";
	}

}
