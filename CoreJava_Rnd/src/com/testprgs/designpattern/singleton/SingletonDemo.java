package com.testprgs.designpattern.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi..");
		
		//Create instance of Singleton class...
		
		Singleton inst1 = Singleton.getInstance();
		
		System.out.println("1st time Instance address : " + inst1);
		
		Singleton inst2 = Singleton.getInstance();
		
		System.out.println("2nd time Instance address : " + inst2);

	}

}
