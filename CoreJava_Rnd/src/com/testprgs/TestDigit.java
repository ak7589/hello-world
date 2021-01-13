package com.testprgs;

public class TestDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to TestDigit class...");
		
		int[] array1 = {1,2,3,4};
		
		DigitArray digit1 = new DigitArray(array1);
		
		System.out.println("digit1 length : " + digit1.length);
		
		//digit1.printArray();
		
		System.out.println(digit1.pop());

		//digit1.printArray();
		
		digit1.unshift(99);
		System.out.println("After printing 99....");
		//digit1.printArray();
		
		DigitArray digit2 = new DigitArray();
		System.out.println("digit2 length : " + digit2.length);
		//digit2.printArray();
		digit2.unshift(199);
		System.out.println("Printing digit2 after calling unshifting with 199 arg");
		//digit2.printArray();
		
	}

}
