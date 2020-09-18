package com.pluralsight.corejava8;

public class LambdaRunnableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Implement Runnable interface in Old way 
		//i.e Java legacy way
		
		Runnable oldRunnableImplementation = new Runnable () {

			@Override
			public void run() {
				System.out.println("Inside run() method oldway 1");
			}
			
		};
		
		//Start a thread using above old implementation of runnable
		Thread th1 = new Thread(oldRunnableImplementation);
		th1.start();
		
		//New Implementation Start
		Runnable newWay2 = () -> {
			
			System.out.println("Inside run() method Lambda way" );
			
		};
		
		Thread th2 = new Thread(newWay2);
		th2.start();
		//New Implementation End

	}

}
