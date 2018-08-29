package com.vincent.design.behavioral_pattern.template_pattern;

public class Cricket extends Game {

	public Cricket() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void endPlay() {
		System.out.println("Cricket Game Finished!");
	}

	@Override
	protected void initialize() {
		System.out.println("Cricket Game Initialized! Start playing.");
	}

	@Override
	protected void startPlay() {
		System.out.println("Cricket Game Started. Enjoy the game!");
	}
}
