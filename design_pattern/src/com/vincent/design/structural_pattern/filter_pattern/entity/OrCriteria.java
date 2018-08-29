package com.vincent.design.structural_pattern.filter_pattern.entity;

import java.util.List;

import org.w3c.dom.ls.LSInput;

import com.vincent.design.structural_pattern.filter_pattern.Criteria;
/**
 * 
 * @author Vincent
 * 
 * <p>逻辑或的筛选</p>
 *
 */
public class OrCriteria implements Criteria {
	private Criteria criteria;
	private Criteria otherCriteria;

	public OrCriteria(Criteria criteria, Criteria otherCriteria) {
		super();
		this.criteria = criteria;
		this.otherCriteria = otherCriteria;
	}

	public OrCriteria() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		// TODO Auto-generated method stub
		List <Person> firstCriteriaItems=criteria.meetCriteria(persons);
		List<Person> otherCriteriaItems=otherCriteria.meetCriteria(persons);
		
		for(Person person : otherCriteriaItems)
		{
			if(!firstCriteriaItems.contains(person))
				firstCriteriaItems.add(person);
		}
		
		return firstCriteriaItems;
	}
		
	
}
