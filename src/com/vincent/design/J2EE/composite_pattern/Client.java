package com.vincent.design.J2EE.composite_pattern;

public class Client {

	public Client() {
		// TODO Auto-generated constructor stub
	}

	private CompositeEntity compositeEntity = new CompositeEntity();

	public void printData() {
		for (int i = 0; i < compositeEntity.getData().length; i++) {
			System.out.println("Data: " + compositeEntity.getData()[i]);
		}
	}

	public void setData(String data1, String data2) {
		compositeEntity.setData(data1, data2);
	}
}
