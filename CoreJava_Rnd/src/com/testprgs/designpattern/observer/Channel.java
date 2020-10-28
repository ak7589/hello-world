package com.testprgs.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

	private String channelName;
	private List<Subscriber> subsList = new ArrayList<>();
	
	
	
	public Channel(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public void notification(String msg) {
		// TODO Auto-generated method stub
		
		for(Subscriber sub : subsList) {
			sub.update(msg);
		}
		
	}
	
	//Add Subscriber
	public void addSub(Subscriber sub) {
		subsList.add(sub);
		sub.setChnl(this);
	}
	
	//Remove subscriber
	public void removeSub(Subscriber sub) {
		subsList.remove(sub);
	}

	public String getChannelName() {
		return channelName;
	}
	
	public void newVideo(String name) {
		
		notification(name);
	}

}
