package com.vincent.design.behavioral_pattern.state_pattern;

public class StartState implements State {

	public StartState() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(Context context) {
		// TODO Auto-generated method stub
			System.out.println("Player is in start state");
			context.setState(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Start State";
	}

}
