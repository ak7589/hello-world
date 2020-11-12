package com.testprgs;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to online test...");
		
		//String str = "aka";
		String str = "Racecar";
		checkPlaindrone(str);
		
		 System.out.println("Classloader of this class:"
			        + TestClass.class.getClassLoader());

	}

	private static boolean checkPlaindrone(String str) {
		// TODO Auto-generated method stub
		
		boolean retval = false;
		
		char[] inputArray = str.toCharArray();
		
		char[] reversed = new char[inputArray.length];
		
		for(int i = inputArray.length -1,index =0 ; i >=0 ; i --, index++ ) {
			
			reversed[index] = inputArray[i];
			
		}
		
		String reversedArray = new String(reversed);
		
		if (str.equalsIgnoreCase(reversedArray)) {
			
			retval = true;
		}
		
		System.out.println("Check Plain : " + retval);
		return retval;
	}

}
