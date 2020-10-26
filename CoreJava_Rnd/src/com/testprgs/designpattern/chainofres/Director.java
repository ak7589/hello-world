package com.testprgs.designpattern.chainofres;

public class Director extends Handler {

	@Override
	public void handleRequest(Request req) {
		// TODO Auto-generated method stub
		
		if(req.getReqType() == RequestType.REPAIR && req.amount < 2000) {
			System.out.println("Director Handling request...");
		}
		
		else {
			System.out.println("Delegating request to VP....");
			successor.handleRequest(req);
		}

	}

}
