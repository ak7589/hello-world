package com.pluralsight.corejava8new.streamslambda;

import java.util.ArrayList;
import java.util.List;

public class City {

	private String name;
	private List<Person> personList = new ArrayList<>();
	
	
	public City(String name) {
		this.name = name;
	}
	
	public City(String name, List<Person> personList) {
		this.name = name;
		this.personList = personList;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Person> getPersonList() {
		return personList;
	}
	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}
	
	
}
