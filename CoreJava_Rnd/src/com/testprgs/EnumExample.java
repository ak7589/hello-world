package com.testprgs;

public class EnumExample {
	
	public enum Season { WINTER, SPRING, SUMMER, FALL }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//For loop to print various enum values
		for (Season s : Season.values()){  
			System.out.println(s); 
		}
		
		//Switch example of enums
		Season season = Season.SUMMER;
		
		System.out.println("-----switch rnd starts-----------");
		
		switch(season){
			
			case SUMMER :
				System.out.println("Summer Season");
				break;
				
				
			default :
				System.out.println("No Season");
				break;
				
			
		}

	}

}
