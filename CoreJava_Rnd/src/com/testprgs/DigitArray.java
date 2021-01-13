package com.testprgs;

import java.util.Arrays;

public class DigitArray {

	private int[] intArray;
	public int length;
	

	public DigitArray(int[] intArray) {
		this.intArray = intArray;
		length = intArray.length;
	}
	
	//Default constructor
	public DigitArray() {
		intArray = new int[0];
		length = intArray.length;
	}
	
	//pop method
	public Integer pop() {
		
		if (intArray.length == 0) {
			return null;
		}
		else {
			int popValue = intArray[length-1];
			
			intArray = Arrays.copyOf(intArray, intArray.length-1);
			//Set length
			length = intArray.length;
			
			return popValue;	
		}
		
	}
	
	//unshift method
	public void unshift(int value) {
		
		int[] newArray = Arrays.copyOf(intArray, intArray.length + 1);
	    newArray[0] = value;
	    System.arraycopy(intArray, 0, newArray, 1, intArray.length);
	    intArray = newArray;
	    length = intArray.length;

		
	}

	@Override
	public String toString() {
		return "DigitArray [intArray=" + Arrays.toString(intArray) + "]";
	}
	
}
