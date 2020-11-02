package com.pluralsight.corejava8.ThreadExamples;

public class ThreadLambdaExample {

	private static int cnt;

	public static Runnable runnableImpl = () -> {

		try {
			while (cnt <= 5) {

				cnt++;

				System.out.println("Thread-Name : " + Thread.currentThread().getName() + " Value " + cnt);

				Thread.sleep(250);

			}
			System.out.println("Exiting : " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread thd1 = new Thread(runnableImpl);
		thd1.setName("COUNTER_RUNNABLE_LAMBDA");
		thd1.start();

		System.out.println("Exiting : " + Thread.currentThread().getName());
	}

}
