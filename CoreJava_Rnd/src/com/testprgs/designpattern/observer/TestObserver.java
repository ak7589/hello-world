package com.testprgs.designpattern.observer;

public class TestObserver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Subscriber sub1 = new Subscriber("Amit");
		Subscriber sub2 = new Subscriber("Gunjan");
		
		Channel chnl = new Channel("Java_Learning");
		
		chnl.addSub(sub1);
		chnl.addSub(sub2);
		
		chnl.newVideo("Java 8 - Streams API ");

	}

}
