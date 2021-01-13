package com.testprgs.designpattern.decorator;

public class HoneyDecorator extends IcecreamDecorator {

	public HoneyDecorator(Icecream baseObj) {
		super(baseObj);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void makeIcecream() {
		// TODO Auto-generated method stub
		System.out.println("Making icecream of IcecreamDecorator...");
		
		baseObj.makeIcecream();
		addHoney();
	}
	
	
	public void addHoney() {
		System.out.println("Adding Honey...");
	}
}
