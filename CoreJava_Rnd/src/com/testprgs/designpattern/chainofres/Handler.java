package com.testprgs.designpattern.chainofres;

public abstract class Handler {
	
	public Handler successor;
	
	public abstract void handleRequest(Request req);

}
