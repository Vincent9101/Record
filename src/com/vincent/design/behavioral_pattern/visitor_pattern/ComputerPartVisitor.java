package com.vincent.design.behavioral_pattern.visitor_pattern;

import javax.management.monitor.Monitor;

import com.vincent.design.structural_pattern.facade_pattern.Computer;

public interface ComputerPartVisitor {

	public void visit(Mouse mouse);

	public void visit(Keyboard keyboard);

	public void visit(com.vincent.design.behavioral_pattern.visitor_pattern.Monitor monitor);

	public void visit(com.vincent.design.behavioral_pattern.visitor_pattern.Computer computer);
}