package com.vincent.design.structural_pattern.proxy_pattern;

public class ProxyImage implements Image {

	private Image myImage;

	public ProxyImage(Image image) {
		myImage = image;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("代理前");
		myImage.show();
		System.out.println("代理后");
	}

}
