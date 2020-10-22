package com.pluralsight.corejava8.general;

/*
 * This is a demo class to show the example of 
 * java accessibility. Example has been taken for
 * private, protected and default access modifier
 * Test program which uses this class is present in
 * the com.pluralsight.corejava8.general2 package.
 */

public class TestClass {

	private int i;
	
	protected int j;
	
	int k;
	
	
	public TestClass() {
	
		i = 50;
		j=51;
		k=52;
	}
	
	public void display() {
		
		System.out.println("I IS : " + i);
		System.out.println("J IS : " + j);
		System.out.println("K IS : " + k);
	}
	

}
