package com.testprgs.enums;

public enum WaterLevel {
	
	LOW(100),
	MEDIUM(200),
	HIGH(300);
	
	int level;

	private WaterLevel(int level) {
		this.level = level;
	}

	public int getLevel() {
		return level;
	}
	

}
