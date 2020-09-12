package com.testprgs;

public class InterviewQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to core Java...");
		
		testReverseString();

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
