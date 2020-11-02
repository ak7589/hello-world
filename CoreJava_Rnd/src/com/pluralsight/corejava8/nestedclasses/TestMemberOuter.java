package com.pluralsight.corejava8.nestedclasses;

/*
 * This demo is to show that instance of inner class
 * can be created in two ways. 
 */

class TestMemberOuter {
	private int data = 30;

	class Inner {
		
		void msg() {
			System.out.println("data is " + data);
		}
		
	}

	public static void main(String args[]) {
		
		//Approach 1 to create object of outer class and nested inner class
		
		//TestMemberOuter obj = new TestMemberOuter();
		//TestMemberOuter.Inner in = obj.new Inner();
		
		//Approach 2 to create object of outer class and nested inner class
		
		TestMemberOuter.Inner in = new TestMemberOuter().new Inner();
		in.msg();
	}
}