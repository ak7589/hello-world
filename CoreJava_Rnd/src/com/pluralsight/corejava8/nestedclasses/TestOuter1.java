package com.pluralsight.corejava8.nestedclasses;

/* 
 * Nested class demo
 * This is to show that if we have static inner class
 * and if it is trying to access static member of say 
 * outer class, through its non-static method , then we  need to create instance 
 * of inner object
 */

public class TestOuter1 {
	
	static int data = 30;

	static class Inner {
		
		void msg() {
		
			/* 
			 * Static class can access static data of the outer class
			 */
			System.out.println("data is " + data);
		}
	}

	public static void main(String args[]) {
		
		TestOuter1.Inner obj = new TestOuter1.Inner();
		//obj.msg();
		
		//TestOuter1.Inner.msg();
		
		//TestOuter1.Inner.msg();
		
	}
}