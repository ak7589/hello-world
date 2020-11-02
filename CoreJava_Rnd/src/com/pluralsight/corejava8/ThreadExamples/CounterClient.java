package com.pluralsight.corejava8.ThreadExamples;

/*
 * Below class uses the Counter class
 */

public class CounterClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Counter obj = new Counter();
		Thread thd = new Thread(obj, "Counter_Thread");
		
		//Start the Thread
		thd.start();
		
		int cnt;
		
		try {
			do{

				cnt = obj.getCnt();
				System.out.println("Thread :" + 
				Thread.currentThread().getName() + 
				"Value received from Counter : " + cnt);
				
				Thread.sleep(1000);

			}while (cnt < 5);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
