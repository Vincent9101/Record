package com.vincent.design.creational_pattern.abstract_factory_pattern.entity;

import com.vincent.design.creational_pattern.abstract_factory_pattern.Color;

public class Red  implements Color{

	public Red() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fill() {
		// TODO Auto-generated method stub
		System.out.println("in RED fill");
	}

}
