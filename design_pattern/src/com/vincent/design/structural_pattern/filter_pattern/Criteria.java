package com.vincent.design.structural_pattern.filter_pattern;

import java.util.List;

import com.vincent.design.structural_pattern.filter_pattern.entity.Person;

public interface Criteria {

	public List<Person>meetCriteria(List<Person> persons);

}
