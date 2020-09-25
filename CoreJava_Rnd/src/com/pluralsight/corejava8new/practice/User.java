package com.pluralsight.corejava8new.practice;

public class User {
	
	private String firstName;
	
	private int age;
	
	public User(String firstName) {
		this.firstName = firstName;
	}
	
	public User(String firstName,int age) {
		this.firstName = firstName;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", age=" + age + "]";
	}

	
	
	

}
