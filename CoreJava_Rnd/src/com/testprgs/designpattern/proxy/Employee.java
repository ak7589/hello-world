package com.testprgs.designpattern.proxy;

public class Employee {
	
	private String name;
	private int role;

	
	public Employee(String name, int role) {
		this.name = name;
		this.role = role;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", role=" + role + "]";
	}
	
	

}
