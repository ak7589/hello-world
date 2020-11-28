package com.testprgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class OrderProcessor {
	
	
	private Map<String, Integer> orderMap = new HashMap<>();
	
	//customer places order...it receives item code
    public void ordaerPlaced (String itemCode) {

    	//Put itemcode on the Map
    	int itemCnt = 0;
    	if( (itemCnt = orderMap.getOrDefault(itemCode, 0)) == 0) {
    		
    		orderMap.put(itemCode, 1);
    	}
    	else {
    		
    		orderMap.replace(itemCode, (itemCnt+1));
    		
    	}
    	
    }
    
	public List<String> getItemsWithHigherOrders(int count) {
		
		//Get the collection of values from the orderMap
		Collection<Integer> valueCollection = orderMap.values();
		
		List<Integer> intList = new ArrayList<>();
		for(Integer tmp : valueCollection) {
			intList.add(tmp);
		}
		
		//Sort integerList
		Collections.sort(intList);
		Collections.reverse(intList);
		
		//Make an array of size count
		int[] countArray = new int[count];
		
		int index=0;
		for(Integer tmp : intList) {
			
			if (index == count) {
				break;
			}
			countArray[index++] = tmp;
			
		}
		
		//for loop to fetch item codes
		List<String> itemCodeList = new ArrayList<>();
		
		for(Entry<String,Integer> mapEntry : orderMap.entrySet()) {
	  		  
	  		  String itemCode = mapEntry.getKey();
	  		  Integer itemCount = mapEntry.getValue();
	  		  
	  		  for(int m=0; m < countArray.length; m++) {
	  			  
	  			  if (itemCount == countArray[m]) {
	  				itemCodeList.add(itemCode);
	  			  }
	  			  
	  		  }
	  		  
	  		   
	  	  }

		return itemCodeList;
	}
	
	////////////////////////////////////
	/*
	 * function doSomething(digits1, digits2) { var result = []; var sum; var carry
	 * = 0; var len = Math.min(digits1.length, digits2.length);
	 * 
	 * for (var i = 0; i < len; i++) { sum = digits1.pop() + digits2.pop() + carry;
	 * // pop() retrieves last element from array. Array is shortened. Returns
	 * undefined if array is empty. carry = 0; if (sum > 9) { sum -= 10; carry = 1;
	 * } result.unshift(sum); // unshift() inserts an element at the front of the
	 * array }
	 * 
	 * var remainingDigits = []; if (digits1.length > 0) { remainingDigits =
	 * digits1; } else if (digits2.length > 0) { remainingDigits = digits2; }
	 * 
	 * len = remainingDigits.length;
	 * 
	 * for (var i = 0; i < len; i++) { sum = remainingDigits.pop() + carry; carry =
	 * 0; if (sum > 9) { sum -= 10; carry = 1; } result.unshift(sum); }
	 * 
	 * if (carry === 1) { result.unshift(1); }
	 * 
	 * return result; }
	 */
	////////////////////////////////////

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Testing Program....");
		
		OrderProcessor order = new OrderProcessor();
		
		order.ordaerPlaced("COMPUTER");
		order.ordaerPlaced("COMPUTER");
		order.ordaerPlaced("COMPUTER");
		order.ordaerPlaced("COMPUTER");
		
		order.ordaerPlaced("MOBILE");
		order.ordaerPlaced("MOBILE");
		order.ordaerPlaced("MOBILE");
		
		order.ordaerPlaced("PEN");
		order.ordaerPlaced("PEN");
		
		System.out.println("Caliing test...");
		
		List<String> itemList = order.getItemsWithHigherOrders(3);
		
		System.out.println("ItemList size : " + itemList.size());
		
		itemList.forEach(s -> System.out.println(s));
		
		

	}

}
