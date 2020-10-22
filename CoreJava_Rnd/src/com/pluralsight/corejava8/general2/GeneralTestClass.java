package com.pluralsight.corejava8.general2;

import com.pluralsight.corejava8.general.TestClass;

public class GeneralTestClass extends TestClass {
	
	/*
	 * public void testSetProtected() {
	 * 
	 * j =99; //k = 98;
	 * 
	 * }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//MyOuter myOuter = new MyOuter();
		
		//Visibility error, because u r calling a private method
		//myOuter.multiply();
		
		GeneralTestClass obj = new GeneralTestClass();
		
		//obj.i = 99;
		obj.j =99;
		//obj.k = 98;
		
		
		obj.display();

	}

}
