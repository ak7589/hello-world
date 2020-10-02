package com.testprgs.enums;

public class EnumPractice {

	public enum Season {
		WINTER, SPRING, SUMMER, FALL
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hi Amit, Welcome to EnumPractice class...");

		//currencyEnumPractice0();

		// Call this method and do RND
		//currencyEnumPractice1(Currency.RUPEE);

		// call another method
		// testMethod2("DOLLAR1");
		//currencyEnumPractice1("DOLLAR");

		// Season enums practice
		//seasonsEnumPractice1();
		
		//Water level enum practice
		waterLevelEnum1();

	}

	private static void waterLevelEnum1() {
		// TODO Auto-generated method stub
		
		System.out.println("waterLevelEnum1 Start -----");
		
		//Usage of values() method of Enum
		for(WaterLevel level : WaterLevel.values()) {
			
			System.out.println(level + " Water Height : " + level.getLevel());
		}
		
		//Usage of valueOf method of Enum
		WaterLevel test = WaterLevel.valueOf("MEDIUM");
		
		//System.out.println("test value is : " + test);
		
		if(test == WaterLevel.HIGH) {
			System.out.println("HIGH water level...");
		}
		else if(test == WaterLevel.LOW) {
			System.out.println("LOW water level...");
		}
		else if(test == WaterLevel.MEDIUM) {
			System.out.println("MEDIUM water level...");
		}
		else {
			System.out.println("UNKNOWN water level...");
		}
		//Usage of if-else on WaterLevel enum
		
		//I can just print water level height in mumber like this
		System.out.println("High water level height : " + WaterLevel.HIGH.getLevel());
		
		
		//Apply toString() method on the enum and see the result
		String highVal = WaterLevel.HIGH.toString();
		System.out.println("highVal value in string, using toString() method : " + highVal);
		
		
		
		System.out.println("waterLevelEnum1 End -----");
		
		
	}

	private static void currencyEnumPractice0() {
		// TODO Auto-generated method stub

		// RND on Currencey enum
		for (Currency c : Currency.values()) {
			System.out.println(c + " Its Value : " + c.getValue());
		}

		Currency c1 = Currency.valueOf("RUPEE");

		System.out.println(c1);
		System.out.println(c1.getValue());

	}

	private static void seasonsEnumPractice1() {
		// TODO Auto-generated method stub

		for (Season s : Season.values()) {
			System.out.println(s);
		}

		// See output of below imp statements
		System.out.println("Value of WINTER is: " + Season.valueOf("WINTER"));
		System.out.println("Index of WINTER is: " + Season.valueOf("WINTER").ordinal());
		System.out.println("Index of SUMMER is: " + Season.valueOf("SUMMER").ordinal());

	}

	private static void currencyEnumPractice1(String currency) {
		// TODO Auto-generated method stub

		Currency c1 = Currency.valueOf(currency);
		System.out.println("Passed currency to testMethod2 : " + c1);

	}

	private static void currencyEnumPractice1(Currency c1) {
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
