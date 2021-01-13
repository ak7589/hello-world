package com.testprgs.designpattern.proxy;

public class TestProxyPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee emp = new Employee("Amit", 10);
		
		InternetProxy proxy = new InternetProxy(emp);
		proxy.grantInternetAccess();
		
			
		Employee emp2 = new Employee("Vidut", 8);
		
		InternetProxy proxy2 = new InternetProxy(emp2);
		proxy2.grantInternetAccess();

	}

}
