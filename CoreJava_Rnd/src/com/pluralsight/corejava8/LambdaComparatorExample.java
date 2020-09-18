package com.pluralsight.corejava8;

import java.util.Comparator;

public class LambdaComparatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Amit, Welcome to core Java...");
		
		//Old legacy way to implemet Comparator class
		Comparator <Integer> oldCmp1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		};
		
		//Call above comparator to compare integers
		System.out.println(oldCmp1.compare(5, 8));
		System.out.println(oldCmp1.compare(5, 5));
		System.out.println(oldCmp1.compare(8, 5));
		
		//New way i.e Lambda way to implement above Comparator
		
		Comparator <Integer> newCmp1 = (o1,o2) -> {
			return o1.compareTo(o2);
		};
		
		//Call new comparator to compare integers
		System.out.println("-----New Way To Compare using Lambda expression-------");
		
		System.out.println(newCmp1.compare(5, 8));
		System.out.println(newCmp1.compare(5, 5));
		System.out.println(newCmp1.compare(8, 5));
		
		System.out.println("----Lambda expression 2 -----------");
		
		Comparator <Integer> newCmp2 = (o1,o2) ->  o1.compareTo(o2);
		
		System.out.println(newCmp2.compare(5, 8));
		System.out.println(newCmp2.compare(5, 5));
		System.out.println(newCmp2.compare(8, 5));

	}

}
