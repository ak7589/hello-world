package com.testprgs;

public class BasicConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("BasicConcept Start ---");
		
		stringToCharArrayEx();
		
		System.out.println("BasicConcept End ---");
		
	}

	private static void stringToCharArrayEx() {
		// TODO Auto-generated method stub
		
		System.out.println("stringToCharArrayEx Start ---");
		
		String test = "Hello Amit";
		
		char[] charArray = test.toCharArray();
		
		System.out.println("Char Array Length : " + charArray.length);
		
		for(int i=0; i < charArray.length ; i++) {
			System.out.println(charArray[i]);
		}
		
		System.out.println("stringToCharArrayEx End ---");
		
	}

}
