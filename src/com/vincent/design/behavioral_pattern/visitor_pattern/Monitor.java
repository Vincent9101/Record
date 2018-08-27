package com.vincent.design.behavioral_pattern.visitor_pattern;

public class Monitor implements ComputerPart {

	public Monitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		// TODO Auto-generated method stub
			computerPartVisitor.visit(this);
	}

}
