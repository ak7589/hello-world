package com.testprgs.designpattern.command;

public class OnCommand implements Command {
	
	private  Light light;
	
	public OnCommand(Light light) {
		
		this.light = light;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		light.on();

	}

}
