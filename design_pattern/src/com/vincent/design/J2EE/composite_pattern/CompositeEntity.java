package com.vincent.design.J2EE.composite_pattern;

public class CompositeEntity {

	public CompositeEntity() {
		// TODO Auto-generated constructor stub
	}

	private CoarseGrainedObject cgo = new CoarseGrainedObject();

	public void setData(String data1, String data2) {
		cgo.setData(data1, data2);
	}

	public String[] getData() {
		return cgo.getData();
	}

}
