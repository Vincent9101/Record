package com.vincent.design.structural_pattern.proxy_pattern;

public class ImageEntity implements Image{

	public ImageEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public void show() {
		System.out.println("ENTITYIamge 展示中");
	}

}
