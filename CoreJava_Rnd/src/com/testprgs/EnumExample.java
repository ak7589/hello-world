package com.testprgs;

public class EnumExample {

	public enum Season {
		WINTER, SPRING, SUMMER, FALL
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		enumExample1();
		
		enumExample2();
		
		enumExample3();

	}

	private static void enumExample3() {
		// TODO Auto-generated method stub
		
		
		for (Movies mov : Movies.values()) {
			
			System.out.println("Movie Name : " + mov.getMovieName());
			System.out.println("Ticket Value : " + mov.getTicketCost());
		}
		
	}

	private static void enumExample2() {
		// TODO Auto-generated method stub
		
		// For loop to print various enum values
				for (Furniture fur : Furniture.values()) {
					
					System.out.println("Fur Type : " + fur.label());
					System.out.println("Fur Cost : " + fur.cost());
				}
		
	}

	private static void enumExample1() {
		// TODO Auto-generated method stub

		// For loop to print various enum values
		for (Season s : Season.values()) {
			System.out.println(s);
		}

		// Switch example of enums
		Season season = Season.SUMMER;

		System.out.println("-----switch rnd starts-----------");

		switch (season) {

		case SUMMER:
			System.out.println("Summer Season");
			break;

		default:
			System.out.println("No Season");
			break;

		}

	}

}
