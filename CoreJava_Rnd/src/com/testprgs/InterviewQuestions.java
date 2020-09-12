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

	}

	private static void sortIntegerArray() {
		// TODO Auto-generated method stub
		
		
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
		
	}

}
