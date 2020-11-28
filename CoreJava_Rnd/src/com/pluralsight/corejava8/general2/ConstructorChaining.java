package com.pluralsight.corejava8.general2;

public class ConstructorChaining {
	
	private int x;
	private int y;
	
	
	

	public ConstructorChaining(int x, int y) {
		this(y);
		this.x = x;
		
		System.out.println("Constructor 1...");
	}




	public ConstructorChaining(int y) {
		this.y = y;
		System.out.println("Constructor 2...");
	}


	@Override
	public String toString() {
		return "ConstructorChaining [x=" + x + ", y=" + y + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Good morning...");
		
		ConstructorChaining temp = new ConstructorChaining(10,20);
		
		System.out.println(temp);

	}

}
