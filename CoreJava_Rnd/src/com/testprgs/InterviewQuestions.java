package com.testprgs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class InterviewQuestions {
	
	public int sum (int a, int b) {
		
		int sum =0;
		sum = a + b;
		
		return sum;
	}
	
	public int sum (int a, int b, int c) {
		
		int sum =0;
		sum = a + b +c;
		
		return sum;
	}
	
	public double sum (int a, int b, int c, int d) {
		
		int sum =0;
		sum = a + b +c + d;
		
		return 16.99;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome for Core Java Test Preparation...");
		
		//We are commenting only those methods which uses Scanner as 
		//those methods hangs for input to be given
		
		testReverseString();
		testReadFileAndMakeMap();
		//scannerExample();
		sortCityNames();
		sortCityNames2();
		//checkOddEvenNbr();
		//linearSearchExample();
		sortIntegerArray();
		binarySearchExample();
		extendArrayExampleWithoutChangingName();
		
		int[] array = {12,23,8,15,17};
		//int[] array = {12,12};
		
		try {
			int num = findSecondLargestInArray(array);
			System.out.println("2nd Largest number is : " + num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println(("Exception raised : " + e));
			//e.printStackTrace();
		}
		

	}

	private static int findSecondLargestInArray(int[] array) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("findSecondLargestInArray Start ---");
		int first = 0;
		int second = 0;
		int result =0;
		
				
		
		int len = array.length;
		
		if(len < 2) {
			throw new Exception("Cannot determine, Only one element in array... ");
		}
		else if (len == 2) {
			
			first = array[0];
			second = array[1];
			
			if(first < second) {
				result = first;
			}
			else if (first > second) {
				result = second;
			}
			else {
				throw new Exception("Both numbers same... ");
			}
		}
		
		else {
			
			//Normal if-else
			if(array[0] < array[1]) {
				first = array[1];
				second = array[0];
			}
			else if(array[0] > array[1]) {
				first = array[0];
				second = array[1];
			}
			else {
				first = array[0];
				second = array[1];
			}
			
			for(int i = 2; i < array.length; i++) {
				
				if(first < array[i]) {
					second = first;
					first = array[i];
				}
				else {
					if (second < array[i]) {
						second = array[i];
					}
				}
				
			}
			
			if(first > second) {
				result = second;
			}
			else {
				throw new Exception("Error : Could not determine second largest number...");
			}
			
		}
		
		
		System.out.println("findSecondLargestInArray End ---");
		
		return result;
	}

	private static void extendArrayExampleWithoutChangingName() {
		// TODO Auto-generated method stub
		
		System.out.println("extendArrayExampleWithoutChangingName Start ---");
		
		int[] intArray = new int[5];
		
		intArray[0] = 12;
		intArray[1] = 23;
		intArray[2] = 22;
		intArray[3] = 34;
		intArray[4] = 45;		
		
		System.out.println(Arrays.toString(intArray));
		
		//working intArray = InterviewQuestions.copyOfArray(intArray, 3);
		intArray = InterviewQuestions.copyOfArray2(intArray, 3);
		
		System.out.println("After returning from copyOfArray method ---");
		System.out.println("New length of array : " + intArray.length);
		System.out.println("Content of Array : ");
		System.out.println(Arrays.toString(intArray));
		
		System.out.println("extendArrayExampleWithoutChangingName End ---");
		
	}
	
	public static int[] copyOfArray(int[] array, int increaseAmt) {
		
		int[] newArray = new int[array.length + increaseAmt];
		
		System.arraycopy(array, 0, newArray, 0, array.length);
		
		return newArray;
		
	}
	
	public static int[] copyOfArray2(int[] array, int increaseAmt) {
		
		int[] newArray = new int[array.length + increaseAmt];
		
		for (int i=0; i < array.length; i++) {
			newArray[i] = array[i];
		}
		
		//System.arraycopy(array, 0, newArray, 0, array.length);
		
		return newArray;
		
	}

	private static void binarySearchExample() {
		// TODO Auto-generated method stub
		System.out.println("binarySearchExample Start ---");
		int[] intArray = {10,34,2,3,57,1};
		
		//First sort the array
		Arrays.sort(intArray);
		
		System.out.println("After sorting array is : " + Arrays.toString(intArray));
		
		System.out.println(Arrays.binarySearch(intArray, 34));
		System.out.println("binarySearchExample End ---");
				
	}

	private static void sortIntegerArray() {
		// TODO Auto-generated method stub
		
		int[] intArray = {10,34,2,3,57,1};
		
		int temp =0;
		
		for(int i =0; i < intArray.length; i++) {
			
			for(int j = i+1; j < intArray.length; j++ ) {
				
				if( intArray[i] > intArray[j]) {
					temp = intArray[i];
					intArray[i] = intArray[j];
					intArray[j] = temp;
				}
			}
		}
		
		System.out.println("Sorted Integer :::  ");
		System.out.println(Arrays.toString(intArray));
		
		
	}

	private static void linearSearchExample() {
		// TODO Auto-generated method stub
		
		System.out.println("linearSearchExample Start---");
		
		Scanner readInts = new Scanner(System.in);
		
		System.out.println("Enter number of elements to be stored in array ---");
		
		int numOfElements = readInts.nextInt();
		
		System.out.println("No of Elements entered : " + numOfElements);
		
		int[] numArray = new int[numOfElements];
		
		//Populate array by reading inputs
		for(int i=0; i < numOfElements ; i++) {
			numArray[i] =  readInts.nextInt();
		}
		
		System.out.println("Enter number to be searched ---");
		int searchInt = readInts.nextInt();
		
		//Check in the for loop if numbers exists
		boolean found = false;
		for(int i=0; i < numOfElements ; i++) {
			
			if(searchInt == numArray[i]) {
				System.out.println("Number : " + searchInt + " Found");
				found = true;
				break;
			}
		}
		
		if(!found) {
			System.out.println("Number could not be  found...");
		}
		
		System.out.println("linearSearchExample End---");
		
	}

	private static void checkOddEvenNbr() {
		// TODO Auto-generated method stub
		
		System.out.println("checkOddEvenNbr Start ---");
		
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNextInt()) {
			int number = scanner.nextInt();
			
			if ( (number % 2) == 0 )
			{
				System.out.println("Even Number ---");
			}
			else
			{
				System.out.println("ODD Number ---");
			}
			
		}
		
		System.out.println("checkOddEvenNbr End ---");
		
	}

	private static void sortCityNames2() {
		// TODO Auto-generated method stub
		
		System.out.println("sortCityNames2 using Manual Start ---");
		
		String[] cityNames = {"Patna","Ahmedabad","Delhi","Mumbai","Goa"};
		
		//Sorting the strings
		String temp;
		int count = cityNames.length;
        for (int i = 0; i < count; i++) 
        {
            for (int j = i + 1; j < count; j++) { 
            	
            	System.out.println("Comparing : " + cityNames[i] + " With : " +  cityNames[j]);
            	
                if (cityNames[i].compareTo(cityNames[j])>0) 
                {
                    temp = cityNames[i];
                    cityNames[i] = cityNames[j];
                    cityNames[j] = temp;
                }
            }
        }
		
        System.out.println(Arrays.toString(cityNames));
		System.out.println("sortCityNames2 using Manual End ---");
	}

	private static void sortCityNames() {
		// TODO Auto-generated method stub
		
		System.out.println("sortCityNames using utility Start ---");
		
		String[] cityNames = {"Patna","Ahmedabad","Delhi","Mumbai","Goa"};
		
		Arrays.sort(cityNames);
		
		System.out.println(Arrays.toString(cityNames));
		
		System.out.println("sortCityNames using utility End ---");
		
	}

	private static void scannerExample() {
		// TODO Auto-generated method stub
		
		String input = "The world will end today -- not!";
		//String input = "The|world|will|end|today|not!";
		
		Scanner lexer = new Scanner(input);
		while(lexer.hasNext()) {
			System.out.println("Next Imput : " + lexer.next());
		}
		
		//Example of reading integers from the Keyboard
		System.out.println("----------- Going to read integers from KeyBoard ---------");
		Scanner lexer2 = new Scanner(System.in);
		while(lexer2.hasNextInt()) {
			System.out.println("Next Integer : " + lexer2.nextInt());
		}
		
	}

	private static void testReadFileAndMakeMap() {
		// TODO Auto-generated method stub
		
		String fieldDelimiter = " ";
		Map<String,Integer> wordMap = new HashMap<>();
		
		File file = new File("ExtFiles/testfile1.txt");
		
		
		try(Reader reader = new FileReader(file);
				BufferedReader bufReader = new BufferedReader(reader);){
			
			String line = null;
			int cnt = 0;
			while((line = bufReader.readLine()) != null ) {
				
				//System.out.println("LINE CONTENT : " + line);
				
				String[] strArray = line.split(fieldDelimiter);
				
				for(String tmp : strArray) {
					System.out.println("WORDS IN LINE : " + tmp);
					
					//Check if this word exists in Map
					if((cnt = wordMap.getOrDefault(tmp,0)) == 0) {
						//Then Put with no-of-count = 1
						wordMap.put(tmp, 1);
						
					}
					else {
						//Get entry found, so get previous count and increment it
						wordMap.replace(tmp, (cnt + 1)); 
					}
					
				}
				
				
			}
			
			//Print content of Map here
			wordMap.forEach((k,v) -> {
				System.out.println("Key : " +k + " : Value : " +v);
			});
			
			//Demo of creating a collection from the different values present in the map
			//Start
			Collection<Integer> intCollection = wordMap.values();
			
			//Define a HashSet to know unique values present in the HashSet
			Set<Integer> intSet = new HashSet<>();
			
			System.out.println("Printing intCollection Start ---");
			intCollection.forEach((s) -> {
				System.out.println(s);
				intSet.add(s);
			});
			System.out.println("Printing intCollection End ---");
			
			System.out.println("Printing unique values from Set -- Start");
			//Below Java8 for loop is working. Commenting is done, Just to test
			//advanced java for loop
			/*
			 * intSet.forEach((s) -> { System.out.println(s); });
			 */
			//Printing using normal for loop
			for(Integer tmp : intSet) {
				System.out.println(tmp);
			}
			System.out.println("Printing unique values from Set -- End");
			//End
			
		}catch(Exception e) {
			
		}
		
	}

	private static void testReverseString() {
		// TODO Auto-generated method stub
		
		System.out.println("testReverseString Start---");
		
		String str = "Hello Amit";
		System.out.println(str);
		
		char[] tempArray = str.toCharArray();
		char[] finalArray = new char[tempArray.length];
		
		for(int i=0,j=0; i < tempArray.length ; i++,j++) {
			System.out.println(tempArray[i]);
			
			finalArray[j] = tempArray[tempArray.length-i-1]; 
		}
		
		String reversedString = new String(finalArray);
		System.out.println("Reversed String : " + reversedString);
		System.out.println("testReverseString End---");
		
		newReverseString();
		
	}
	
	private static void newReverseString() {
		
		System.out.println("newReverseString Start---");
		
		String str = "Hello Amit";
		System.out.println(str);
		
		char[] tempArray = str.toCharArray();
		char[] finalArray = new char[tempArray.length];
		
		for (int i = tempArray.length - 1, j = 0; i >=0; i--,j++) {
			
			finalArray[j] = tempArray[i];
			
		}
		String str2 = new String(finalArray);
		
		System.out.println("ORIGINAL STRING : " + str);
		System.out.println("REVERSED STRING : " + str2);
		
		System.out.println("newReverseString End---");
		
	}

}
