package com.testprgs;

public class PrintOddEvenThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable impl1 = () -> {
			
			for(int i = 0; i < 100; i ++) {
				
				if(i % 2 == 0) {
					System.out.println(Thread.currentThread().getName() + " " +i);
				}
				
			}
			
		};
		
		Runnable impl2 = () -> {
			for(int i = 0; i < 100; i ++) {
				
				if(i % 2 != 0) {
					System.out.println(Thread.currentThread().getName() + " " +i);
				}
				
			}
		};
		
		Thread thd1 = new Thread(impl1);
		thd1.setName("EVEN_THREAD");
		
		
		Thread thd2 = new Thread(impl2);
		thd2.setName("ODD_THREAD");
		
		thd1.start();
		thd2.start();
		
		try {
			thd1.join();
			thd2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
