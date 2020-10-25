package com.testprgs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JavaCodingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Java coding test start ...");
		
		//Problem - 1. 
		//Description - Find duplicate string present in the string array
		findDupInStrArray();
		
		//Problem -2 
		//Description - Sort integer array in increasing in order
		sortIntArrayInIncresingOrder();
		
		System.out.println("Java coding test end ...");
		
		//Problem -3
		//Description - Sort string array. Suppose array contains city names.
		sortStringArrayInAscendingOrder();
		
		//Problem -4
		//Description - Find the missing number
		int[] intArray = {2,3,1,5};
		int missedElem = findMissingNumber(intArray);
		System.out.println("Missed-Element is : " + missedElem);
		
		
		//Problem -5
		int[] arrayOfInts = {3,1,2,4,5};
		int k = 2;
		arrayCyclicRotation(arrayOfInts,k);
		
		//Problem-6
		findSecondHigestInArray();
		
		//Problem-7
		char array[] = {'A','M','I','T'};
		reverseAnArray(array);
		
		//Problem-8
		/*
		 * Reverse a string
		 */
		String str = "Hello";
		char[] newArr = reverseAnArray(str.toCharArray());
		String str2 = new String(newArr);
		System.out.println("Reversed String : " + str2);

	}

	private static char[] reverseAnArray(char[] array) {
		// TODO Auto-generated method stub
		
		char[] newArray = new char[array.length];
		
		for(int i = array.length - 1, j=0 ; i >=0 ; i--,j++) {
			newArray[j] = array[i];
		}
		
		System.out.println("Passed Array : " + Arrays.toString(array));
		System.out.println("Reversed Array : " + Arrays.toString(newArray));
		
		return newArray;
		
	}

	private static void findSecondHigestInArray() {
		// TODO Auto-generated method stub
		
		System.out.println("findSecondHigestInArray Start -----");
		
		int arrayOfInt[] = {23,45,1,10,56,99, 108,234,232};
		
		int firstHighest = arrayOfInt[0];
		int secondHighest = arrayOfInt[1];
		
		for(int i =2; i < arrayOfInt.length ; i++) {
			
			if (firstHighest < arrayOfInt[i]) {
				secondHighest = firstHighest;
				firstHighest = arrayOfInt[i];
			}
			else {
				if (secondHighest < arrayOfInt[i]) {
					secondHighest = arrayOfInt[i];
				}
			}
			
		}
		
		System.out.println("Array Given : " + Arrays.toString(arrayOfInt));
		System.out.println("First Highest : " + firstHighest);
		System.out.println("Second Highest : " + secondHighest);
		
		System.out.println("findSecondHigestInArray End -----");
		
	}

	private static void arrayCyclicRotation(int[] intArray,int k) {
		// TODO Auto-generated method stub
		
		System.out.println("Cyclic rotation start ....");
		System.out.println("Original Array : " + Arrays.toString(intArray));
		System.out.println("Rotation Times : " + k);
		System.out.println("Array Length : " + intArray.length);
		
		//Create a new integer array
		int newArray[] = new int[intArray.length];
		
		//Loop over the original array and calculate the new index
		//of each array
		
		int newIndex = -1;
		for(int i=0; i < intArray.length; i++) {
			newIndex = (i+k) % 5;
			System.out.println("New index for " + i + " " + newIndex);
			newArray[newIndex] = intArray[i];
		}
		
	
		System.out.println("New  Array after cyclic rotation : " + Arrays.toString(newArray));
		
		System.out.println("Cyclic rotation end ....");
	}

	/*
	 * Below function algorithm is based on two simple facts.
	 * First calculate total sum of numbers present in the array
	 * Second calcualate sum of 1 ...to n+1...After that substract
	 * first sum from the second sum and then we will get the result
	 */
	private static int findMissingNumber(int[] array) {
		// TODO Auto-generated method stub
		
		int sum =0;
		for(int i=0; i < array.length; i++) {
			
			sum += array[i];
		}
		
		//Find the ideal sum as per the problem statement
		int idealSum =0;
		
		//I want to calculate total sum of 1 to n+1
		int n = array.length + 1;
		
		for(int j = 1 ; j <= n; j++) {
			idealSum += j;
		}
		
		int missingElement = idealSum - sum;
		
		//System.out.println("Array sum is : " + sum);
		//System.out.println("Ideal sum is : " + idealSum);
		
		return missingElement;
		
	}

	/*
	 * Logic is that you write a nested loop. In the nested loop you start 
	 * with 1st element, i.e 0th index of array with others and compare with
	 *  next and other elements and swap if necessary. With this approach
	 *  in the first pass, 0th element will become perfect.
	 */
	private static void sortStringArrayInAscendingOrder() {
		// TODO Auto-generated method stub
		
		String[] cityNames = {"Buxar","Ara","Patna","Bano","Begusarai","Darbhanga"};
		
		System.out.println("String Array Before Sorting : " + Arrays.toString(cityNames));
		
		String temp=null;
		
		for(int i=0 ; i < cityNames.length ; i++) {
			
			for(int j = i + 1 ; j < cityNames.length; j++) {
				if( cityNames[i].compareTo(cityNames[j]) > 0) {
					temp = cityNames[i];
					cityNames[i] = cityNames[j];
					cityNames[j] = temp;
				}
			}
		}
		
		System.out.println("String Array After Sorting : " + Arrays.toString(cityNames));
		
	}

	/*
	 * Logic is that you write a nested loop. In the nested loop you start 
	 * with 1st element, i.e 0th index of array with others and compare with
	 *  next and other elements and swap if necessary. With this approach
	 *  in the first pass, 0th element will become perfect.
	 */
	private static void sortIntArrayInIncresingOrder() {
		// TODO Auto-generated method stub

		int[] intArray = { 43, 34, 1, 56, 7, 768, 999, 56, 45 };

		int temp = 0;

		for (int i = 0; i < intArray.length; i++) {

			for (int j = i + 1; j < intArray.length; j++) {

				if (intArray[i] > intArray[j]) {
					temp = intArray[i];
					intArray[i] = intArray[j];
					intArray[j] = temp;
				}
			}
		}

		System.out.println("Sorted Integer :::  ");
		System.out.println(Arrays.toString(intArray));

	}

	/*
	 * Logic of this method is that add() method of HashSet returns false
	 * If we try to add an element which is already present
	 * prototype of add() method of HashSet is 
	 */
	private static void findDupInStrArray() {
		// TODO Auto-generated method stub
		
		String[] citiArray = {"Patna", "Surat", "Pune", "Delhi", "Gumla", "Surat"};
		
		//Define a HashSet
		Set<String> citiSet = new HashSet<>();
		
		
		//Loop over the string array
		for(int i =0; i < citiArray.length; i++) {
			
			if( !citiSet.add(citiArray[i])) {
				System.out.println("Duplicate City Name : " + citiArray[i]);
			}
			
		}
		
		
	}

}
