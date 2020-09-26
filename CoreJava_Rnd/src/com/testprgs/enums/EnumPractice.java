package com.testprgs.enums;

public class EnumPractice {

	public enum Season {
		WINTER, SPRING, SUMMER, FALL
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hi Amit, Welcome to EnumPractice class...");

		for (Season s : Season.values()) {
			System.out.println(s);
		}

		// See output of below imp statements
		System.out.println("Value of WINTER is: " + Season.valueOf("WINTER"));
		System.out.println("Index of WINTER is: " + Season.valueOf("WINTER").ordinal());
		System.out.println("Index of SUMMER is: " + Season.valueOf("SUMMER").ordinal());

		// RND on Currencey enum
		for (Currency c : Currency.values()) {
			System.out.println(c + " Its Value : " + c.getValue());
		}

		Currency c1 = Currency.valueOf("RUPEE");

		System.out.println(c1);
		System.out.println(c1.getValue());

		// Call this method and do RND
		testMethod1(Currency.RUPEE);
		
		//call another method
		//testMethod2("DOLLAR1");
		testMethod2("DOLLAR");

	}

	private static void testMethod2(String currency) {
		// TODO Auto-generated method stub
		
		Currency c1 = Currency.valueOf(currency);
		System.out.println("Passed currency to testMethod2 : " + c1);
		
	}

	private static void testMethod1(Currency c1) {
		// TODO Auto-generated method stub

		System.out.println("testMethod1 Start -----");

		// Switch case on enum example
		switch (c1) {

		case RUPEE:
			System.out.println("Rupee received");
			break;

		case DOLLAR:
			System.out.println("Rupee received");

		default:
			System.out.println("Currency not supported");

		}

		System.out.println("testMethod1 End -----");

	}

}
