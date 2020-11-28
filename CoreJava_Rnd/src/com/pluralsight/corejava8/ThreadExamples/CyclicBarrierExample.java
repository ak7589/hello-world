package com.pluralsight.corejava8.ThreadExamples;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CyclicBarrier barrier = new CyclicBarrier(2);
		
		Runnable impl1 = () -> {

			System.out.println("Thread Name : " + Thread.currentThread().getName() + " At Barrier ");
			try {
				barrier.await();
				System.out.println("After Barrier, Thread Name : " + Thread.currentThread().getName());
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("EXITING ::::" + Thread.currentThread().getName());
		};
		
		Runnable impl2 = () -> {
			
			System.out.println("Thread Name : " + Thread.currentThread().getName() + " Going for sleep - 10 sec");
			try {
				TimeUnit.SECONDS.sleep(10);
				barrier.await();
				System.out.println("After barrier Thread Name : " + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("EXITING ::::" + Thread.currentThread().getName());
			
		};
		
		Thread thd1 = new Thread(impl1,"THD1");
		Thread thd2 = new Thread(impl2,"THD2");
		
		thd1.start();
		thd2.start();
		
		try {
			thd1.join();
			thd2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("EXITING ::::" + Thread.currentThread().getName());

	}

}
