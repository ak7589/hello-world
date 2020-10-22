package com.pluralsight.corejava8.general;

/* 
 * Nested class demo
 * This is to show that if we have static inner class
 * and if it is trying to access static member of say 
 * outer class, through its static method , then we do not need to create instance 
 * of inner object
 */
class TestOuter2 {
	static int data = 30;

	static class Inner {
		static void msg() {
			System.out.println("data is " + data);
		}
	}

	public static void main(String args[]) {
		TestOuter2.Inner.msg();// no need to create the instance of static nested class
	}
}