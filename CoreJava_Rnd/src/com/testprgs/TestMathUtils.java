package com.testprgs;

public class TestMathUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to TestMathUtils class...");

		// console.log(doSomething([8,1], [1,1,5,3]));

		int[] array1 = { 8, 1 };
		int[] array2 = { 1, 1, 5, 3 };

		DigitArray digits1 = new DigitArray(array1);
		DigitArray digits2 = new DigitArray(array2);

		DigitArray result = MathUtils.doSomething(digits1, digits2);

		System.out.println(result);

	}

}
