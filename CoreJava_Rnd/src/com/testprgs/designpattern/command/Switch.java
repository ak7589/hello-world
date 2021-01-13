package com.testprgs.designpattern.command;

/*
 * In command pattern, below class represents invoker
 */
public class Switch {
	
	public void storeAndExecute(Command cmd) {
		
		cmd.execute();
		
	}

}
