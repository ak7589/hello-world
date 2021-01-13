package com.testprgs.designpattern.proxy;

public class InternetProxy implements InternetAccess {
	
	private Employee emp;
	
	private RealInternetAccess internetAccess;
	

	public InternetProxy(Employee emp) {
		this.emp = emp;
	}

	@Override
	public void grantInternetAccess() {
		// TODO Auto-generated method stub
		
		/*
		 * Check role of employee. If employee role is greater
		 * than 9, then provide internet access to the client
		 */
		
		if (emp.getRole() > 9) {
			
			internetAccess = new RealInternetAccess(emp);
			internetAccess.grantInternetAccess();
			
		}
		else {
			System.out.println("Internet Access Denied to " + emp.getName());
		}

	}

	/*
	 * public void setInternetAccess(RealInternetAccess internetAccess) {
	 * this.internetAccess = internetAccess; }
	 */

}
