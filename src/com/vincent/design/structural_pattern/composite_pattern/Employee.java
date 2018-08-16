package com.vincent.design.structural_pattern.composite_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Vincent
 *         <p>
 *         员工对象 由于职位关系因此会有组合的情况
 *         </p>
 *
 */
public class Employee {
	private String name;
	private String dept;
	private int salary;
	private List<Employee> subordinates;

	// 构造函数
	public Employee(String name, String dept, int sal) {
		this.name = name;
		this.dept = dept;
		this.salary = sal;
		subordinates = new ArrayList<Employee>();
	}

	public void add(Employee e) {
		subordinates.add(e);
	}

	public void remove(Employee e) {
		subordinates.remove(e);
	}

	public List<Employee> getSubordinates() {
		return subordinates;
	}

	public String toString() {
		return ("Employee :[ Name : " + name + ", dept : " + dept + ", salary :" + salary + " ]");
	}
}