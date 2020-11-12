package com.testprgs;

public class JavaCodilityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to codility test...");
		
		//boolean retval = fun1(s);
		//System.out.println("RET VAL IS : " + retval);
	
		//int nbr = 268;
		//int xyz = solution(nbr);
		//System.out.println("RETURNED NBR IS : " + xyz);
		
		//test function
		//int nbr = 268;
		int nbr = 0;
		int nbr2 = solution2(nbr);
		
		System.out.println("New Number is : " + nbr2);
		
		int nbr3 = 1234;
		treatNumbersAsStrings(nbr3);
		
	}

	private static void treatNumbersAsStrings(int number) {
		// TODO Auto-generated method stub
		
		System.out.println("treatNumbersAsStrings Start...");
		
		String nbrAsString = String.valueOf(number);
		
		char[] array = nbrAsString.toCharArray();
		
		for(int i=0; i < array.length; i++) {
			System.out.println(array[i]);
			
			if(Integer.parseInt(String.valueOf(array[i])) < 50) {
				System.out.println("Value is less than 50...");
			}
			
		}
		
		
		System.out.println("treatNumbersAsStrings End...");
		
	}

	private static int solution2(int nbr) {
		// TODO Auto-generated method stub
		
		//char ch = '9';
		//int num = Integer.parseInt(String.valueOf(ch));
		
		//System.out.println(num);
		
		String s = String.valueOf(nbr);
		
		char[] array = s.toCharArray();
		
		//New array to hold the number
		char[] newArray = new char[array.length + 1];
		
		char ch ;
		int index =0;
		for (int i =0; i < array.length; i ++) {
			
			//System.out.println(array[i]);
			ch = array[i];
			
			if(Integer.parseInt(String.valueOf(ch)) < 5) {
				newArray[index++] = '5';
				newArray[index++] = ch;
			}
			else {
				newArray[index++] = ch;
			}
			
		} //End - for loop
		
		String newNbr = new String(newArray);
		Integer newNumber = Integer.parseInt(newNbr);
		
		return newNumber;
		
	}

	private static int solution(int nbr) {
		// TODO Auto-generated method stub
		
		String s = String.valueOf(nbr);
		
		char[] array = s.toCharArray();
		
		for (int i =0; i < array.length; i ++) {
			System.out.println(array[i]);
			
			//Integer.pa
			
			if (array[i] < 5) {
				System.out.println(array[i] + " is less than " + "5");
			}
		}
		
		/*
		 * int remain = nbr % 10; int remain2 = nbr % 100; int remain3 = nbr % 1000;
		 * 
		 * Integer. String.
		 * 
		 * System.out.println("Remain : " + remain); System.out.println("Remain2 : " +
		 * remain2); System.out.println("Remain3 : " + remain3);
		 */
		return 0;
	}

	private static  boolean fun1(String str) {
		// TODO Auto-generated method stub
		
		boolean retval = true;
		boolean boccur = false;
		char[] array = str.toCharArray();
		
		for (int i =0; i < array.length; i++) {
			System.out.println(array[i]);
			
			if(array[i] == 'a' && boccur == true) {
				retval = false;
				break;
			}
			else if (array[i] == 'b') {
				boccur = true;
			}
			
		}
		
		return retval;
	}

}
