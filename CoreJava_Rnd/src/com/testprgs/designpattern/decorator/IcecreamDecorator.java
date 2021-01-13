package com.testprgs.designpattern.decorator;

public abstract class IcecreamDecorator implements Icecream {
	
	Icecream baseObj;
	
	public IcecreamDecorator(Icecream baseObj) {
		this.baseObj = baseObj;
	}

	@Override
	public void makeIcecream() {
		// TODO Auto-generated method stub
		System.out.println("Making icecream of IcecreamDecorator...");
	}
	
}
