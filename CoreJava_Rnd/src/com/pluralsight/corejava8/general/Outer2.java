package com.pluralsight.corejava8.general;


/*
 * Nested class example
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
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Outer2 outer = new Outer2();
		
		Outer2.Inner inner = new Outer2.Inner();
		
		inner.printText();
		inner.printText2(outer);
		

	}

}
