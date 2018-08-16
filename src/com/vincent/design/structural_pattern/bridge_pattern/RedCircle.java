package com.vincent.design.structural_pattern.bridge_pattern;

public class RedCircle implements DrawAPI {

	public RedCircle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawCircle(int radius, int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("draw Circle[ color: red radius  " + radius + " x:" + x + " y:" + y+" ]");
	}

}
