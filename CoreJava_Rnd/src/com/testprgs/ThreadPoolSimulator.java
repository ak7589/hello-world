package com.testprgs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolSimulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to ThreadPoolSimulator class...");
		
		ExecutorService es = Executors.newFixedThreadPool(3);
		
		//Suppose you have 3 instances of Adder class and you want to execute 
		//addition activity of your adder class in 3 separate threads
		
		//Instead of array use ArrayList
		//Adder[] addArray = new Adder[3];
		List<Adder> adderList = new ArrayList<>(3);
		
		adderList.add(new Adder(11,12));
		adderList.add(new Adder(20,12));
		adderList.add(new Adder(20,22));
		adderList.add(new Adder(25,22));
		adderList.add(new Adder(26,22));
		adderList.add(new Adder(27,22));
		adderList.add(new Adder(28,22));
		adderList.add(new Adder(29,22));
		adderList.add(new Adder(30,22));
		adderList.add(new Adder(31,22));
		adderList.add(new Adder(32,22));
		adderList.add(new Adder(33,22));
		adderList.add(new Adder(34,22));
		
		List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		
		//Future<Integer>[] resultArray = new Future<Integer>[3];
		
		//Loop over adderList
	
		System.out.println("1111-----------adderList size ------" + adderList.size());
		for(Adder tmp : adderList) {
			futureList.add(es.submit(tmp));
		}
		System.out.println("2222-------- futureList size---------" + futureList.size());
		//Print value of result
		
		for(Future<Integer> tmp : futureList) {
			
			try {
				Integer result = tmp.get();
				
				System.out.println("Result of Execution Is : " + result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("3333-----------trying shutdown------");
		es.shutdown();

	}

}
