package com.testprgs.designpattern.chainofres;

public class VP extends Handler {

	@Override
	public void handleRequest(Request req) {
		// TODO Auto-generated method stub
		
		if(req.getReqType() == RequestType.REPAIR && req.amount < 5000) {
			System.out.println("VP Handling request...");
		}
		
		else {
			successor.handleRequest(req);
		}

	}

}
