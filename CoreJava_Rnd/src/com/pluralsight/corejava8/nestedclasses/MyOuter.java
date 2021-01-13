package com.pluralsight.corejava8.nestedclasses;

public class MyOuter {
	
	
	private int innerCounter;
	
	class Inner {
		
		Inner(){
			
			innerCounter++;
		}
		
		public String toString() {
			return String.valueOf(innerCounter);
		}
	}
	
	private void multiply() {
		Inner inner = new Inner();
		this.new Inner();
		System.out.println(inner);
		
		inner = new MyOuter().new Inner();
		System.out.println(inner);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//new MyOuter().multiply();
		
		MyOuter myOuter = new MyOuter();
		myOuter.multiply();
		//myOuter.innerCounter = 9;
		

	}
	
	

}
