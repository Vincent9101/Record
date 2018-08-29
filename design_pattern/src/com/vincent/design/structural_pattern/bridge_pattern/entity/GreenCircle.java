 package com.vincent.design.structural_pattern.bridge_pattern.entity;

import com.vincent.design.structural_pattern.bridge_pattern.DrawAPI;

public class GreenCircle implements DrawAPI {

	public GreenCircle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drawCircle(int radius, int x, int y) {
		// TODO Auto-generated method stub
		System.out.println("draw Circle[ color: green radius  " + radius + "  x: " + x + " y:" + y + " ]");
	}

}
