package com.pluralsight.corejava8.ThreadExamples;

public class ProducerConsumer {
	
	private static Object lock = new Object();
	
	private static int[] buffer;
	private static int count;
	
	public static boolean isEmpty(int[] buffer) {
		return count == 0;
	}
	
	public static boolean isFull(int[] buffer) {
		return count == buffer.length ;
	}
	
	static class Consumer {

		public void Consume() {

			synchronized (lock) {
				if (isEmpty(buffer)) {
					
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				buffer[--count] = 0;
				lock.notify();
			}
		}
	}
	
	static class Producer {
		
		public void Produce() {
			
			synchronized (lock) {
				if (isFull(buffer)) {
					
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				buffer[count++] = 0;
				lock.notify();
			}
			
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		buffer = new int[10];
		count = 0;
		
		ProducerConsumer.Producer produce = new ProducerConsumer.Producer();
		ProducerConsumer.Consumer consume = new ProducerConsumer.Consumer();
		
		Runnable producerTask = () -> {
			
			for(int i=0; i < 50; i++) {
				produce.Produce();
			}
			System.out.println("Done Producing...");
			
		};
		
		Runnable consumerTask = () -> {
			
			for(int i=0; i < 45; i++) {
				consume.Consume();
			}
			System.out.println("Done Consuming...");
			
		};

		//Threads
		Thread producerThread = new Thread(producerTask);
		Thread consumerThread = new Thread(consumerTask);
		
		//Start threads
		producerThread.start();
		consumerThread.start();
		
		//Wait for threads to finish
		producerThread.join();
		consumerThread.join();
		
		System.out.println("Data In Buffer : " + count);
		
	}
	
	

}
