package com.testprgs;

public class PrintOddEvenThreadExample2 {

	// private Object lockObj = new Object();

	private static int global_counter = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable impl1 = () -> {

			synchronized (PrintOddEvenThreadExample2.class) {

				while (global_counter < 100) {

					if (global_counter % 2 == 0) {
						System.out.println(Thread.currentThread().getName() + " " + global_counter);
						global_counter++;
						PrintOddEvenThreadExample2.class.notify();
					}

					else {
						try {
							PrintOddEvenThreadExample2.class.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		};

		Runnable impl2 = () -> {

			synchronized (PrintOddEvenThreadExample2.class) {

				while (global_counter < 100) {

					if (global_counter % 2 != 0) {
						System.out.println(Thread.currentThread().getName() + " " + global_counter);
						global_counter++;
						PrintOddEvenThreadExample2.class.notify();
					}

					else {
						try {
							PrintOddEvenThreadExample2.class.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
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
			
			System.out.println("Exiting from ::: " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
