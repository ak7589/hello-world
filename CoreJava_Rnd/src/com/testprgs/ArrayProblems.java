package com.testprgs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayProblems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to core java...");
		
		//Colliison problem
		int a = 20;
		int b = 2;
		int c = 9;
		int d = 19;
		int n = 20;
		
		findCollisionProblem(a,b,c,d,n);
		
		//Sorting problem
		int[] array1 = {8,80,34,2,9};
		int kthMinElement = sortArrayFindKthSmallestElement(array1,1);
		System.out.println("Kth Minimum element is : " + kthMinElement);
		
		//Find duplicate in array mehod1
		findDuplicateInArray();
		
		//Find Second Largest Number in Array
		int[] arrayOfInts = {12,11,24,34,6,78,58,96,114,113};
		findSecondLargest(arrayOfInts);
		
		//Check for Array equality
		checkArrayEquality();
		
		//Find number of pairs of an array equal to a number
		findNumberOfPairsAgainstNumber();
		
		//Print fibonaci series
		printFibonaciSeries();
		
		//Sort integer array in ascending order
		sortIntegerArrayAscending();
		
		//Sort String array in the ascending order
		sortStingArrayAscending();
		
		//Find sub array which sums are equal to a particular number
		findSubArray1();
		
		//Find minimum element in the array
		findMinElementInArray();
		
		//Split array in two sub-arrays whose sum of contained numbers is same
		splitArraysIntoTwo();
		
		

	}

	private static List<List<Integer>> splitArraysIntoTwo() {
		// TODO Auto-generated method stub
		
		int[] array = {22,20,15,44,13};
		
		int count1 = -1;
		int count2 = -1;
		int sum1 =0;
		int sum2 =0;
		
		List<Integer> intList1 = new ArrayList<>();
		List<Integer> intList2 = new ArrayList<>();
		
		//List containing list of Integers
		List<List<Integer>> intListContainer = new ArrayList<>();
		
		System.out.println("Split arrays in two");
		
		for (int count=0; count < array.length-1; count++) {
			
			//1st Array
			count1 = count + 1;
			sum1 =0;
			sum2 =0;
			
			//1st loop
			for(int j =0; j < count1 ; j++) {
				sum1 = sum1 + array[j];
				intList1.add(array[j]);
			}
			
			//2nd loop
			count2 = array.length - count1;
			for(int k =count1; k < array.length; k++ ) {
				sum2 = sum2 + array[k];
				intList2.add(array[k]);
			}
			
			if (sum1 == sum2) {
				System.out.println("Sum mathes :  count " + count);
				System.out.println("List1 : " + intList1);
				System.out.println("List2 : " + intList2);
				
				//Add above lists to the integerListContainer
				
				intListContainer.add(intList1);
				intListContainer.add(intList2);
				
				break;
			}
			//Clear list
			intList1.clear();
			intList2.clear();
			
		}
		
		return intListContainer;
		
	}

	private static void findMinElementInArray() {
		// TODO Auto-generated method stub
		
		System.out.println("findMinElementInArray Start ---------");
		
		int[] arrayInt = {10,11,2,3,1,99,5,7};
		
		int minimum ;
		minimum = arrayInt[0];
		for(int i=0; i < arrayInt.length; i++) {
			
			if (minimum > arrayInt[i]) {
				minimum = arrayInt[i];
			}
		
		}
		
		System.out.println("Minimum Element : " + minimum);
		System.out.println("findMinElementInArray End ---------");
		
	}

	private static void findSubArray1() {
		// TODO Auto-generated method stub
		System.out.println("findSubArray1 Start ----------");
		int[] arrayInt = {42, 15, 12, 8, 6, 32};
		
		int numberToMatach = 26;
		
		System.out.println("Array of Int : " + Arrays.toString(arrayInt));
		
		int startNbr = -1;
		boolean flag = true;
		for (int i = 0; i < arrayInt.length; i++) {

			flag = true;

			startNbr = arrayInt[i];

			if (startNbr > numberToMatach) {
				flag = false;
			}

			if (flag) {
				for (int j = i + 1; j < arrayInt.length; j++) {
					
					startNbr += arrayInt[j];
					
					if (startNbr > numberToMatach) {
						break;
					}
					else if(startNbr == numberToMatach) {
						System.out.println("1st Index : " + i + " : Last Index : " + j);
					}

				}
			}

		}
		
		System.out.println("findSubArray1 End ----------");
	}

	private static void sortStingArrayAscending() {
		// TODO Auto-generated method stub
		System.out.println("sortStingArrayAscending Start ----------");
		
		String[] arrayString = {"Patna", "Ahmendabd", "Pune", "Culcutta", "Begusarai"};
		System.out.println("Array to be sorted : " + Arrays.toString(arrayString));
		
		String temp = null;

		for (int i = 0; i < arrayString.length; i++) {

			for (int j = i + 1; j < arrayString.length; j++) {
				
				if(arrayString[i].compareTo(arrayString[j]) > 0) {
					temp = arrayString[i];
					arrayString[i] = arrayString[j];
					arrayString[j] = temp;
				}

			}

		}
		
		System.out.println("After Sorting, Sorted Array Is  : " + Arrays.toString(arrayString));
		
		System.out.println("sortStingArrayAscending End ----------");
	}

	private static void sortIntegerArrayAscending() {
		// TODO Auto-generated method stub
		
		System.out.println("sortIntegerArrayAscending Start ----------");
		int[] arrayInt = {2,1,13,9,51,3,7,23,2,3,4,99,5,6,78,345,78};
		
		System.out.println("Array to be sorted : " + Arrays.toString(arrayInt));
		
		//Loop to sort the array
		int temp =-1;
		
		for(int i=0; i< arrayInt.length; i++) {
			
			for(int j = i+1; j< arrayInt.length; j++) {
				
				System.out.println("Comparing : " + arrayInt[i] + " : With : " + arrayInt[j]);
				
				if(arrayInt[i] > arrayInt[j]) {
					temp = arrayInt[i];
					arrayInt[i] = arrayInt[j];
					arrayInt[j] = temp;
							
				}
				
			}
			
		}
		
		System.out.println("After Sorting, Sorted Array Is  : " + Arrays.toString(arrayInt));
		
		System.out.println("sortIntegerArrayAscending End ----------");
		
		
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

	private static void findNumberOfPairsAgainstNumber() {
		// TODO Auto-generated method stub
		
		int[] arrayOfInt = {10,20,30,40,50};
		int number = 50;
		
		for(int i=0; i < arrayOfInt.length; i++) {
			
			for(int j = i + 1; j < arrayOfInt.length;j++) {
				if(number == (arrayOfInt[i] + arrayOfInt[j])) {
					System.out.println("Pair Is : " + arrayOfInt[i] + " : AND : " + arrayOfInt[j]);
				}
			}
		}
		
	}

	private static void checkArrayEquality() {
		// TODO Auto-generated method stub
		
		System.out.println("checkArrayEquality Start---------");
		
		int[] array1 = {10,20,30,40,50};
		int[] array2 = {10,20,30,40,34};
		
		boolean result = Arrays.equals(array1, array2);
		
		System.out.println("Array equality RESULT : " + result);
		
		
		System.out.println("checkArrayEquality End---------");
		
	}

	private static void findSecondLargest(int[] arrayOfInts ) {
		// TODO Auto-generated method stub
		
		System.out.println("findSecondLargest method start -------------");
		
		int firstLargest =0, secondLargest =0;
		
		//Check for first 2 indexes of the array
		if(arrayOfInts[0] > arrayOfInts[1]) {
			firstLargest = arrayOfInts[0];
			secondLargest = arrayOfInts[1];
		}
		else if(arrayOfInts[0] < arrayOfInts[1]) {
			firstLargest = arrayOfInts[1];
			secondLargest = arrayOfInts[0];
		}
		
		//Loop over other elements and keep replacing firstLargest and secondLargest
		
		for(int i = 2; i < arrayOfInts.length; i++) {
			if (firstLargest < arrayOfInts[i]) {
				
				secondLargest = firstLargest;
				firstLargest = arrayOfInts[i];
			}
			else {
				if(secondLargest < arrayOfInts[i]) {
					secondLargest = arrayOfInts[i];
				}
			}
		}
		
		System.out.println("Array Passed : " + Arrays.toString(arrayOfInts));
		System.out.println("First Largest : " + firstLargest);
		System.out.println("Second Largest : " + secondLargest);
		
		
		System.out.println("findSecondLargest method end -------------");
		
	}

	private static void findDuplicateInArray() {
		// TODO Auto-generated method stub
		
		System.out.println("----------------findDuplicateInArray Start ---------------");
		
		String langArray[] = {"Java","Python", "Oracle","Java","JSP"};
		
		System.out.println("Language Array Content : " + Arrays.toString(langArray));
		//Method1 Start
		String tmp;
		for(int i=0; i< langArray.length; i++) {
			tmp = langArray[i];
			
			for(int j=i+1; j< langArray.length;j++) {
				if(tmp.equalsIgnoreCase(langArray[j])) {
					System.out.println("Duplicat Elem : " + tmp);
				}
			}
			
		}
		//Method1 End
		
		//Method2 Start
		System.out.println("Use HashSet to find duplicates...");
		Set<String> langSet = new HashSet<>();
		
		for(int k=0; k < langArray.length ; k++) {
			
			if(!langSet.add(langArray[k])) {
				System.out.println("Duplicate Elem   ::::" + langArray[k]);
			}
		}
		
		//Method2 End
		
		
		System.out.println("----------------findDuplicateInArray End ---------------");
		
		
	}

	private static int sortArrayFindKthSmallestElement(int[] array, int k) {
		// TODO Auto-generated method stub
		
		//Just sort the array using java.utils.Arrays class
		Arrays.sort(array);
		
		//return Kth minimum array
		return array[k-1];
	}

	private static void findCollisionProblem(int a, int b, int c, int d, int n) {
		// TODO Auto-generated method stub
		
		System.out.println("findCollisionProblem Start ----");
		
		//Series 1 - b, b+a, b + 2a, b + (n-1)a
		
		//Write a for loop to print this number
		int temp =0;
		//Define an array to hold all these numbers below
		int[] arr1 = new int[n];
		
		for(int i =0; i < n; i++) {
			temp = b + i*a;
			
			arr1[i] = temp;
			
			System.out.println("1st Series : " + temp);
		}
		
		//Print array1 after the first for loop
		System.out.println(Arrays.toString(arr1));
		
		//Write 2nd Loop to get second series
		//Write a for loop to print this number
		//series 2 - d, d+c, d+2c, ….. d+(n-1)c
		
				int temp2 =0;
				//Define an array to hold all these numbers below
				int[] arr2 = new int[n];
				
				for(int j =0; j < n; j++) {
					temp2 = d + j*c;
					
					arr2[j] = temp2;
					
					System.out.println("2nd Series : " + temp2);
				}
				
				//Print array1 after the first for loop
				System.out.println(Arrays.toString(arr2));
				
				
				//Write a nested loop to find the collision point
				int findElemn =0;
				boolean found = false;
				int collisionNbr = -1;
				for(int k =0; k < arr1.length; k++) {
					
					 findElemn = arr1[k];
					 found = false;
					 
					 //Loop over all elements in the next array
					 for(int m =0; m < arr2.length; m++) {
						 
						 if(findElemn == arr2[m]) {
							 found = true;
							 collisionNbr = findElemn;
							 break;
						 }
						 
					 }
					 
					 if(found) {
						 break;
					 }
					
				}
		
				if(collisionNbr != -1) {
					System.out.println("Collision Number Found Is : " + collisionNbr);
				}
		
		System.out.println("findCollisionProblem End ----");
		
		
	}

}
