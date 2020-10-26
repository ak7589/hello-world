package com.testprgs.designpattern.chainofres;

public class TestChainOfRes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Director obj1 = new Director();
		
		VP obj2 = new VP();
		
		obj1.successor = obj2;
		
		//Create a new Request to be handled
		
		Request req = new Request();
		
		req.amount = 1900;
		req.reqType = RequestType.REPAIR;
		
		obj1.handleRequest(req);

	}

}
