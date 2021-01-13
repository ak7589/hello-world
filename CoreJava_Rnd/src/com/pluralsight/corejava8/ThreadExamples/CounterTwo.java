package com.pluralsight.corejava8.ThreadExamples;

public class CounterTwo extends Thread {

	private int currentValue;

	public CounterTwo(String name) {
		super(name);

		currentValue = 0;

		System.out.println(this);

		start();
		// TODO Auto-generated constructor stub
	}

	public int getCurrentValue() {
		return currentValue;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			while (currentValue <= 5) {

				currentValue++;

				System.out.println("Thread-Name : " + 
				Thread.currentThread().getName() + " Value " + currentValue);

				Thread.sleep(250);
				
				System.out.println("Exit from : " + Thread.currentThread().getName());

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
