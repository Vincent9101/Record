package com.vincent.design.creational_pattern.prototype_pattern;

public abstract class Shape implements Cloneable {
	private String id;
	protected String type;

	public abstract void draw();

	public String getType() {
		return type;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;

	}

	@Override
	public Object clone() {
		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return object;

	}

	public Shape() {
		// TODO Auto-generated constructor stub
	}

}
