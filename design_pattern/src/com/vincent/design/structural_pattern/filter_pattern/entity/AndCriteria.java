package com.vincent.design.structural_pattern.filter_pattern.entity;

import java.util.List;

import com.vincent.design.structural_pattern.filter_pattern.Criteria;

/**
 * 
 * @author Vincent
 *         <p>
 *         逻辑与的筛选
 *         </p>
 *
 */
public class AndCriteria implements Criteria {

	private Criteria criteria;
	private Criteria otherCriteria;

	public AndCriteria(Criteria criteria, Criteria otherCriteria) {
		super();
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	public AndCriteria() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		// TODO Auto-generated method stub
		List<Person> firstCriteriaPersons = criteria.meetCriteria(persons);

		return otherCriteria.meetCriteria(firstCriteriaPersons);
	}

}
