package com.pluralsight.corejava8.general;


/*
 * Nested class example. In this case nested class is static. Nested class
 * is static, it means that static inner class is in-dependent of outer / enclosing
 * class. But if we want to access non-static methof of outer class then we 
 * need to create instance of outer class, and then pass it to methid of inner
 * static class, so that it can call the non-static method of outer / enclosing 
 * class.
 */

public class Outer2 {
	
	
	private String message = "Hello There from Outer class !!!";
	
	public void printMsg() {
		System.out.println(message);
	}
	
	public static class Inner {
		
		private String message = "Hello There from static Inner class !!!";
		
		public void printText() {
			System.out.println(message);
		}
		
		public void printText2(Outer2 out) {
			out.printMsg();
		}
		
		/*
		 * Below static method is added to show that nested static class
		 * can have static method. Note that static class only show that
		 * inner class is in-dependent of outer class
		 */
		public static void testInnerStatic() {
			System.out.println("Message from Static method in Static Inner class...");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Outer2 outer = new Outer2();
		
		Outer2.Inner inner = new Outer2.Inner();
		
		inner.printText();
		inner.printText2(outer);
		inner.testInnerStatic();
		

	}

}
