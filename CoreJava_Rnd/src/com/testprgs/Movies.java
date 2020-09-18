package com.testprgs;

/**
 * FURNITURE_TYPE("Furniture Name", floating-point cost)
*/


public enum Movies {
	

	SUPERHIT("NEO", 1000),
	SEMIHIT("FOX", 700),
	HIT("DEER", 400);
	

	Movies(String name, int ticketVal) {
		// TODO Auto-generated constructor stub
		
		this.movieName = name;
		this.ticketCost = ticketVal;
	}
	
	private final String movieName;
	private final float ticketCost;
	
	public String getMovieName() {
		return movieName;
	}
	public float getTicketCost() {
		return ticketCost;
	}

	
	
}
