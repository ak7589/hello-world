package com.testprgs.designpattern.singleton;

public class Singleton {

	private static Singleton instance = null;

	// Private constructor
	private Singleton() {

	}

	// static method for creating instance of Singleton class
	public static Singleton getInstance() {

		synchronized (Singleton.class) {
			if (instance == null) {

				instance = new Singleton();

			}
		}
		return instance;

	}
	
	protected Object readResolve() {
	    return getInstance();
	}
	
	protected Object clone() {
		try {
			throw new Exception("testing...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
