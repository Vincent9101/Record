package com.vincent.design.structural_pattern.filter_pattern.entity;

import java.util.ArrayList;
import java.util.List;

import com.vincent.design.structural_pattern.filter_pattern.Criteria;

/**
 * 
 * @author Vicent
 * <p>篩選單身</p>
 *
 */
public class CriteriaSingle implements Criteria {

	public CriteriaSingle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Person> meetCriteria(List<Person> persons) {
		// TODO Auto-generated method stub

		List<Person> singlePerson = new ArrayList<Person>();
		for (Person person : persons) {
			if (person.getMaritalStatus().equalsIgnoreCase("Single")) {
				singlePerson.add(person);
			}
		}
		return singlePerson;
	}

}
