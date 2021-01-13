package com.pluralsight.corejava8;

public class DeadlockExample {

	private static int number_counter = 0;
	
	private static Object lock1 = new Object();
	
	private static Object lock2 = new Object();
	
	private static void showMessage() {
		System.out.println("Hello...from " + Thread.currentThread().getName() );
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable impl1 = () -> {

			synchronized (lock1) {

				while (number_counter < 100) {
					if (number_counter % 2 == 0) {

						System.out.println(Thread.currentThread().getName() + " " + number_counter);
						number_counter++;
						
						synchronized(lock2) {
							DeadlockExample.showMessage();
						}

					}
				}
			}

		};

		Runnable impl2 = () -> {

			synchronized (lock2) {

				while (number_counter < 100) {
					if (number_counter % 2 != 0) {

						System.out.println(Thread.currentThread().getName() + " " + number_counter);
						number_counter++;
						
						synchronized(lock1) {
							DeadlockExample.showMessage();
						}


					}
				}
			}
		};

		Thread thd1 = new Thread(impl1, "THREAD-1");

		Thread thd2 = new Thread(impl2, "THREAD-2");

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
