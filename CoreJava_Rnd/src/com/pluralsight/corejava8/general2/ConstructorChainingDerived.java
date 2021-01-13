package com.pluralsight.corejava8.general2;

public class ConstructorChainingDerived extends ConstructorChaining {
	
	private int z;
	

	public ConstructorChainingDerived(int x, int y, int z) {
		super(x, y);
		this.z = z;
		
		System.out.println("Constructor 3...");
	}

		

	@Override
	public String toString() {
		return "ConstructorChainingDerived [z=" + z + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Good morning...");
		
		ConstructorChainingDerived temp = new ConstructorChainingDerived(10,20,30);
		
		System.out.println(temp);

	}

}
