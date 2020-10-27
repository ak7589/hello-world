package com.testprgs.designpattern.adapter;

import java.util.ArrayList;
import java.util.List;


public class EmployeeFromDB implements Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public EmployeeFromDB(int id, String firstName, String lastName, String email) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	
	public static List<Employee> getEmployees(){
		
		List<Employee> emps = new ArrayList<>();
		
		emps.add(new EmployeeFromDB(1234,"Amit","Kumar","ak160310@gmail.com"));
		emps.add(new EmployeeFromDB(2345,"Gunjan","Kumar","gunjan@gmail.com"));
		emps.add(new EmployeeFromDB(3246,"Vidut","Kumar","Vidut@gmail.com"));
		
		return emps;
	}


	@Override
	public String toString() {
		return "EmployeeFromDB [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	

}
