package com.testprgs.designpattern.adapter;

public class EmployeeAdapter implements Employee {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public EmployeeAdapter(EmployeeLdap empLdap) {
	
		id = empLdap.getCn();
		firstName = empLdap.getName();
		lastName = empLdap.getName2();
		email = empLdap.getMail();
		
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "EmployeeAdapter [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	

}
