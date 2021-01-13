package com.testprgs.designpattern.chainofres;

public class Request {
	
	public RequestType reqType;
	public int amount;
	
	public RequestType getReqType() {
		return reqType;
	}
	public void setReqType(RequestType reqType) {
		this.reqType = reqType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
