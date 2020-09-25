package com.testprgs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to CollectionTest class...");
		
		simpleMapExamples();

	}

	private static void simpleMapExamples() {
		// TODO Auto-generated method stub
		System.out.println("simpleMapExamples Start ----");
		
		Map<String,Integer> mapEx1 = new HashMap<>();
		
		mapEx1.put("Amit", 35);
		mapEx1.put("Gunjan", 45);
		mapEx1.put("Vidut", 55);
		
		//Loop over Map
		for(Entry<String, Integer> entry : mapEx1.entrySet()) {
			
			String key = entry.getKey();
			Integer val = entry.getValue();
			
			System.out.println("KEY : " + key + " : VAL : " + val);
			
		}
		
		//API to get collection of values from the map
		Collection<Integer> values = mapEx1.values();
		
		//Now browse over collection values using java8 lambda
		System.out.println("Printing values ...");
		values.forEach((val) -> System.out.println(val));
		
		//Replace values in the map using 
		//Here we are replacing each key's value to 46
		mapEx1.replaceAll(( s,  i) -> {
			return 46;
		});
		
		System.out.println("Printing after firing replaceAll...");
		//Now print the key/value pair of map using lambda
		mapEx1.forEach((k,v) -> {
			System.out.println("Key : " + k + " Val " + v);
		});
		
		
		
		System.out.println("simpleMapExamples End ----");
	}

}
