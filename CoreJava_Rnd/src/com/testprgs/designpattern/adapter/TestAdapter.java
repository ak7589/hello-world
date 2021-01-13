package com.testprgs.designpattern.adapter;

import java.util.List;

public class TestAdapter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> emps = EmployeeFromDB.getEmployees();
		
		emps.forEach(emp -> System.out.println(emp));
		
		//Create instance of EmployeeLdap
		EmployeeLdap empLdap = new EmployeeLdap(234,"Manoj","Sinha","manoj@abc.com");
		
		
		//emps.add(empLdap);
		
		emps.add(new EmployeeAdapter(empLdap));
		
		System.out.println("Employee from Ldap added to the list...");
		
		emps.forEach(emp -> System.out.println(emp));
		

	}

}
