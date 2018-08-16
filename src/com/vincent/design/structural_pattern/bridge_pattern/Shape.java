package com.vincent.design.structural_pattern.bridge_pattern;

public abstract class Shape {

	protected DrawAPI drawAPI;

	protected Shape(DrawAPI drawAPIParam) {
		drawAPI = drawAPIParam;
	}

	//橋接在這裏就可以體現出來
	public abstract void draw();

}
