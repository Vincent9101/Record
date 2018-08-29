package com.vincent.design.behavioral_pattern.observer_pattern;

public class BinaryObserver extends Observer {

	public BinaryObserver() {
		// TODO Auto-generated constructor stub
	}
	
	public BinaryObserver(Subject subject)
	{
		this.subject=subject;
		this.subject.attach(this);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println( "Binary String: " 
			      + Integer.toBinaryString( subject.getState() ) ); 
	}

}
