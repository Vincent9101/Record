package com.vincent.design.behavioral_pattern.interpreter_pattern;

public class AndExpression implements Expression {

	private Expression expr1 = null;
	private Expression expr2 = null;

	public AndExpression() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean interpret(String context) {
		// TODO Auto-generated method stub
		return expr1.interpret(context) && expr2.interpret(context);
	}

}
