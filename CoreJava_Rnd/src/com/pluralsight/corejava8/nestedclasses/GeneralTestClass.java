package com.pluralsight.corejava8.nestedclasses;

public class GeneralTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//MyOuter myOuter = new MyOuter();
		
		//Visibility error, because u r calling a private method
		//myOuter.multiply();
		
		TestClass obj = new TestClass();
		
		//obj.i = 99;
		obj.j =99;
		obj.k = 98;
		
		
		obj.display();

	}

}
