package com.pluralsight.corejava8.ThreadExamples;

/*
 * This class implements Runnable interface and in the 
 * run() method it counts till 5
 */
public class Counter implements java.lang.Runnable {
	
	private int cnt;
	
	

	public int getCnt() {
		return cnt;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while (cnt <= 5) {

				cnt++;
				
				System.out.println("Thread-Name : " 
				+ Thread.currentThread().getName() + " Value " + cnt);
				
				Thread.sleep(250);

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
