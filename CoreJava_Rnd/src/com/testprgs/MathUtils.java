package com.testprgs;

public class MathUtils {

	private static int processDigitArray(DigitArray digits1, DigitArray digits2, DigitArray result) {

		int sum;
		int carry = 0;
		int len = Math.min(digits1.length, digits2.length);

		// for loop 1 --start
		for (int i = 0; i < len; i++) {
			sum = digits1.pop() + digits2.pop() + carry; // pop() retrieves last element from array. Array is shortened.
															// Returns undefined if array is empty.
			carry = 0;
			if (sum > 9) {
				sum -= 10;
				carry = 1;
			}
			result.unshift(sum); // unshift() inserts an element at the front of the array
		}

		return carry;

	}

	private static int processDigitArray(DigitArray remainingDigits, int carry, DigitArray result) {

		int len = remainingDigits.length;
		int sum;

		for (int i = 0; i < len; i++) {
			sum = remainingDigits.pop() + carry;
			carry = 0;
			if (sum > 9) {
				sum -= 10;
				carry = 1;
			}
			result.unshift(sum);
		}

		return carry;
	}

	public static DigitArray doSomething(DigitArray digits1, DigitArray digits2) {
		
		DigitArray result = new DigitArray();
		
		int carry = 0;
		
		//Processing 1st time
		carry = MathUtils.processDigitArray(digits1, digits2, result);
		
		DigitArray remainingDigits = new DigitArray();
		if (digits1.length > 0) {
			remainingDigits = digits1;
		} else if (digits2.length > 0) {
			remainingDigits = digits2;
		}

		int len = remainingDigits.length;

		//Processing 2nd time
		carry = MathUtils.processDigitArray(remainingDigits, carry, result);

		if (carry == 1) {
			result.unshift(1);
		}

		return result;
	}

}
