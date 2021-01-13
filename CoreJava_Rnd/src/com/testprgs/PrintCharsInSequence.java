package com.testprgs;

public class PrintCharsInSequence {

	// private Object lockObj = new Object();

	private static int global_counter = 0;
	private static char[] array = {'A','B','C'};

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runnable impl1 = () -> {

			synchronized (PrintCharsInSequence.class) {

				while (global_counter < 3) {

					if (global_counter % 2 == 0) {
						System.out.println(Thread.currentThread().getName() + " " + array[global_counter]);
						global_counter++;
						PrintCharsInSequence.class.notify();
					}

					else {
						try {
							PrintCharsInSequence.class.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		};

		Runnable impl2 = () -> {

			synchronized (PrintCharsInSequence.class) {

				while (global_counter < 3) {

					if (global_counter % 2 != 0) {
						System.out.println(Thread.currentThread().getName() + " " + array[global_counter]);
						global_counter++;
						PrintCharsInSequence.class.notify();
					}

					else {
						try {
							PrintCharsInSequence.class.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}

		};

		Thread thd1 = new Thread(impl1);
		thd1.setName("FIRST_THREAD");

		Thread thd2 = new Thread(impl2);
		thd2.setName("SECOND_THREAD");

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
