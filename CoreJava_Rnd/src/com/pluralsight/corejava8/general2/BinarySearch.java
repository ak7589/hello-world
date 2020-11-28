package com.pluralsight.corejava8.general2;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	public static int binarySearch(int arr[], int first, int last, int key) {
		if (last >= first) {
			int mid = first + (last - first) / 2;
			if (arr[mid] == key) {
				return mid;
			}
			if (arr[mid] > key) {
				return binarySearch(arr, first, mid - 1, key);// search in left subarray
			} else {
				return binarySearch(arr, mid + 1, last, key);// search in right subarray
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 10, 20, 30, 40, 50 };
		int key = 30;
		int last = arr.length - 1;
		int result = binarySearch2(arr, 0, last, key);
		if (result == -1)
			System.out.println("Element is not found!");
		else
			System.out.println("Element is found at index: " + result);
		
		printFibonacci();
		printFibonaciSeries();
	}
	
	
	private static void printFibonacci() {
		// TODO Auto-generated method stub
		
		System.out.println("Print fib start ---");
		//int n = 5;
		List<Integer> intList = new ArrayList<>();
		for(int n =0; n < 8; n++) {
			intList.add(findFib(n));
				
		}
		
		System.out.println(intList);
		System.out.println("Print fib end ---");
		
	}

	private static int findFib(int n) {
		// TODO Auto-generated method stub
		int retval =0 ;
		
		if (n == 0) {
			retval = 0;
			System.out.println("Input : " + n + "  Retval for findFib : " + retval);
			return retval;
		}
		
		if (n == 1) {
			retval = 1;
			System.out.println("Input : " + n + "  Retval for findFib : " + retval);
			return retval;
		}
		
		retval = findFib(n-1) + findFib(n-2);
		
		System.out.println("Input : " + n + "  Retval for findFib : " + retval);
		return retval;
		
		
	}

	public static int binarySearch2(int array[], int startIndex, int lastIndex, int valueToSeearch) {
		
		
		if (lastIndex >= startIndex) {
			
			int mid = startIndex + (lastIndex - startIndex) / 2;
			
			if(array[mid] == valueToSeearch) {
				return mid;
			}
			
			if (array[mid] > valueToSeearch) {
				binarySearch2(array, startIndex, mid-1, valueToSeearch);
			}
			
			if (array[mid] < valueToSeearch) {
				binarySearch2(array, mid+1,lastIndex, valueToSeearch);
			}
			
		}
		
		return -1;
	}
	
	private static void printFibonaciSeries() {
		// TODO Auto-generated method stub
		
		int n1 = 0;
		int n2 = 1;
		int n3=0;
		
		System.out.println(n1);
		System.out.println(n2);
		
		
		int count = 10;
		
		for (int i = 2; i < count; i ++) {
			
			n3 = n1 + n2;
			System.out.println(n3);
			
			
			n1 = n2;
			n2 = n3;
			
		}
		
	}

}
