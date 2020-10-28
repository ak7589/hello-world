package com.testprgs.designpattern.observer;

/*
 * Subscriber is basically a observer which is observing
 * a subject
 */
public class Subscriber implements Observer {
	
	private String name;
	private Channel chnl;

	public Subscriber(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}


	public void setChnl(Channel chnl) {
		this.chnl = chnl;
	}

	@Override
	public void update(String title) {
		// TODO Auto-generated method stub
		System.out.println(name + " : " + title + " released on" + chnl.getChannelName());
		
	}

}
