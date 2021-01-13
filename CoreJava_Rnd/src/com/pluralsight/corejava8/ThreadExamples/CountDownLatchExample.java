package com.pluralsight.corejava8.ThreadExamples;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to countdown latch example...");
		
		CountDownLatch latch = new CountDownLatch(3);
		
		Runnable waiter1 = () -> {
			
			System.out.println("Before await " + Thread.currentThread().getName());
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("After await " + Thread.currentThread().getName());
		};
		
		Runnable waiter2 = () -> {
			System.out.println("Before await " + Thread.currentThread().getName());
			try {
				latch.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("After await " + Thread.currentThread().getName());
		};
		
		Runnable decrementer = () -> {
			latch.countDown();
			try {
				TimeUnit.SECONDS.sleep(5);
				latch.countDown();
				latch.countDown();
				System.out.println("CountDown Over ::: " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};

		Thread thd1 = new Thread(waiter1,"WAITER1");
		Thread thd2 = new Thread(waiter2,"WAITER2");
		Thread thd3 = new Thread(decrementer,"DECREMENTER");
		
		thd1.start();
		thd2.start();
		thd3.start();
		
		try {
			thd1.join();
			thd2.join();
			thd3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("EXITING FROM ::: " + Thread.currentThread().getName());
	
		
	}

}
