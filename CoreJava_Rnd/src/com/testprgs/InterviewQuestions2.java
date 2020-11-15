package com.testprgs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * This class contains latest interview questions
 */

public class InterviewQuestions2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to coding practice...");
		
		//Question no 1
		/*
		 * Below method is ti check if a number passed is odd or even
		 */
		int number1 = 24;
		boolean flag = checkOddOrEven(number1);
		
		System.out.println(flag);
		
		//Question no 2
		/*
		 * I have string of numbers in list, process this list and
		 * return list of just even numbers
		 */
		processStringListAndReturnIntList();
		
		//Question no 3
		/*
		 * Show the example of functional interface and its implementation
		 * using Lambda expression
		 */
		demoLambda();
		
		//Question no 4
		/*
		 * This question is based on the concept of streams api
		 * to calculate total cost of all items or get total cose
		 * given the produd
		 */
		processProductListAndReturnTotalPrice();
		
		//Question no 5
		/*
		 * Print odd and even numbers by two threads examole
		 * Look at the different class file PrintOddEvenThreadExample 
		 * in the same folder.
		
		 */
		

	}

	private static void processProductListAndReturnTotalPrice() {
		// TODO Auto-generated method stub
		
		ProdItem prod1 = new ProdItem(100,"Mobile 1",2, 10000);
		ProdItem prod2 = new ProdItem(110,"Mobile 2",3, 7000);
		
		ProdItem prod3 = new ProdItem(200,"Laptop 1",3, 40000);
		ProdItem prod4 = new ProdItem(210,"Laptop 2",4, 35000);
		
		//Add all items to the list
		
		List<ProdItem> prodItemList = new ArrayList<>();
		
		prodItemList.add(prod1);
		prodItemList.add(prod2);
		prodItemList.add(prod3);
		prodItemList.add(prod4);
		
		
		//Try calculating price of all mobiles in the list
		double totalMobilePrice = prodItemList.stream()
									.filter(prd -> prd.getProdName().contains("Mobile"))
									.mapToDouble(prd -> prd.getItemQuantiy() * prd.getPrice())
									.sum();
		
		System.out.println("Total Mobile Price ::: " + totalMobilePrice);		
		
		//Try calculating price of all laptops
		double totalLaptopPrice = prodItemList.stream()
				.filter(prd -> prd.getProdName().contains("Laptop"))
				.mapToDouble(prd -> prd.getItemQuantiy() * prd.getPrice())
				.sum();
		
		System.out.println("Total Laptop Price ::: " + totalLaptopPrice);
		
		//Try calculating total price
		double totalPrice = prodItemList.stream()
				.mapToDouble(prd -> prd.getItemQuantiy() * prd.getPrice())
				.sum();
		
		System.out.println("Total Laptop Price ::: " + totalPrice);
		
	}

	private static void demoLambda() {
		// TODO Auto-generated method stub
		
		FunInterfaceExample funIntfaceImpl = (I) -> System.out.println("Value Passed " + I);
		
		funIntfaceImpl.show(999);
		
	}

	private static void processStringListAndReturnIntList() {
		// TODO Auto-generated method stub
		
		List<String> strList = new ArrayList<>();
		
		strList.add("1");
		strList.add("2");
		strList.add("3");
		strList.add("4");
		strList.add("5");
		strList.add("6");
		strList.add("7");
		strList.add("8");
		
		List<Integer> intList = strList.stream()
				.map(num -> Integer.parseInt(num))
				.filter(num -> num % 2 == 0)
				.collect(Collectors.toList());
		
		//Print the list of Integers
		System.out.println("Printing list of integers using lambda exp...");
		intList.forEach(num -> System.out.println(num));
		
		
	}

	private static boolean checkOddOrEven(int nbr) {
		// TODO Auto-generated method stub
		
		boolean retval = false;
		
		if ( (nbr % 2) == 0 )
		{
			retval = true;
		}
				
		return retval;
		
	}

}
