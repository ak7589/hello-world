package com.pluralsight.corejava8.general;

/*
 * Nested class example
 */


public class Outer {
	
	
	private String message = "Hello There from Outer !!!";
	
	public class Inner {
		
		private String message = "Hello There from Inner !!!";
		
		public void printText() {
			System.out.println(message);
			System.out.println(Outer.this.message);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Outer outer = new Outer();
		
		Outer.Inner inner = outer.new Inner();
		
		inner.printText();
		

	}

}
