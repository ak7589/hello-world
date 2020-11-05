package com.testprgs;

public class JavaCodilityTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to codility test...");
		
		//boolean retval = fun1(s);
		//System.out.println("RET VAL IS : " + retval);
	
		int nbr = 268;
		int xyz = solution(nbr);
		System.out.println("RETURNED NBR IS : " + xyz);
		
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
