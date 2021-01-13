package com.pluralsight.corejava8.nestedclasses;

/*
 * Nested class example. This example shows the two possible
 * ways by which instance of nested inner class can be 
 * created.
 */


public class Outer {
	
	
	private String message = "Hello There from Outer !!!";
	
	public static void testOuterStatic() {
		System.out.println("Static method in Outer class...");
	}
	
	public class Inner {
		
		private String message = "Hello There from Inner !!!";
		
		public void printText() {
			System.out.println(message);
			System.out.println(Outer.this.message);
		}
		
		/*
		 * Below method is purposely added to show the fact that 
		 * static methods are only allowed in top level class
		 * or nested static class.static keyword in nested. Note that
		 * static keyword used in definition of nested class only show
		 * that inner class is independent of outer class.
		 */
		//public static void testInnerStatic() {
			//System.out.println("Static method in Inner class...");
		//}
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//Mark below 2-Styles of creating objects
		
		//Style - 1
		
		//Outer outer = new Outer();
		
		//Outer.Inner inner = outer.new Inner();
		
		//Style - 2
		
		Outer.Inner inner = new Outer().new Inner();
		inner.printText();
		

	}

}
