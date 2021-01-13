package com.testprgs.enums;

public enum Currency {

	RUPEE(5),
	DOLLAR(10),
	RUBEL(15),
	YEN(20);

	private int value;
	
	private Currency(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	
}
