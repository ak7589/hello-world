package com.testprgs.designpattern.proxy;

public class RealInternetAccess implements InternetAccess {
	
	private Employee employee;
	
	

	public RealInternetAccess(Employee employee) {
		this.employee = employee;
	}



	@Override
	public void grantInternetAccess() {
		// TODO Auto-generated method stub
		
		System.out.println(employee.getName() + " Granted Internet Access");

	}

}
