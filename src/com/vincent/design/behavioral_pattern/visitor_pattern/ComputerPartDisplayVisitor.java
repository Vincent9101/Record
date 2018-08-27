package com.vincent.design.behavioral_pattern.visitor_pattern;

import com.vincent.design.structural_pattern.facade_pattern.Computer;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

	@Override
	public void visit(Mouse mouse) {
		System.out.println("Displaying Mouse.");
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Displaying Keyboard.");
	}

	@Override
	public void visit(com.vincent.design.behavioral_pattern.visitor_pattern.Monitor monitor) {
		// TODO Auto-generated method stub
		System.out.println("Displaying Monitor.");
	}

	@Override
	public void visit(com.vincent.design.behavioral_pattern.visitor_pattern.Computer computer) {
		// TODO Auto-generated method stub
		System.out.println("Displaying Computer.");
	}

	public void visit(Computer computer) {
		// TODO Auto-generated method stub
		
	}

}
