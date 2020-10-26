package com.testprgs.designpattern.command;

public class TestCommand {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Receiver
		Light light = new Light();
		
		//Command object
		OnCommand onReq = new OnCommand(light);
		
		//Invoker
		//Invoker takes / stores the command object and pass
		//it to the apropriate receiver
		Switch obj = new Switch();
		
		obj.storeAndExecute(onReq);
		
		
		

	}

}
