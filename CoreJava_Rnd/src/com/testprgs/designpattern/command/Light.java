package com.testprgs.designpattern.command;

/*
 * In command pattern, this class represents receiver
 */
public class Light {
	
	public void on() {
		
		System.out.println("Light switched on...");
	}
	
	public void off() {
		
		System.out.println("Light switched off...");
		
	}

}
