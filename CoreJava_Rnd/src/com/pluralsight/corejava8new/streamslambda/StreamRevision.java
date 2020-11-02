package com.pluralsight.corejava8new.streamslambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamRevision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Test method for showing concept of stream
		testFun1();
		
		//Test method for showing concept of stream, and concept of flatmap
		testFun2();
		
		
	}

	/*
	 * Below test method is for the showing example of 
	 * flatMap intermediate operation
	 */
	
	private static void testFun2() {
		// TODO Auto-generated method stub
		
		Person person1 = new Person("Amit1", 10);
		Person person2 = new Person("Amit2", 18);
		Person person3 = new Person("Amit3", 44);
		Person person4 = new Person("Amit4", 45);
		Person person5 = new Person("Amit5", 46);

		City citi1 = new City("Patna");
		City citi2 = new City("Kanpur");
		City citi3 = new City("Nagpur");

		List<Person> perList1 = new ArrayList<>();
		List<Person> perList2 = new ArrayList<>();
		List<Person> perList3 = new ArrayList<>();

		// List1
		perList1.add(person1);
		perList1.add(person2);

		// List2
		perList2.add(person3);
		perList2.add(person4);

		// List3
		perList3.add(person5);

		citi1.setPersonList(perList1);
		citi2.setPersonList(perList2);
		citi3.setPersonList(perList3);

		// Add cities to the list of citi
		List<City> citiList = new ArrayList<>();
		citiList.add(citi1);
		citiList.add(citi2);
		citiList.add(citi3);
		
		//Find count of all the persons, living in all different cities.
		long totalPersonCount = citiList.stream()
										.flatMap(citi -> citi.getPersonList().stream())
										.count();
		
		System.out.println("Total Person Count : " + totalPersonCount);
		
	}

	/*
	 * Below test method is added to practice concept of
	 * stream, and how it can be used to process collection data.
	 */
	private static void testFun1() {
		// TODO Auto-generated method stub
		
		User usr1 = new User("Amit");
		User usr2 = new User("Gunjan");
		User usr3 = new User("Vidut");
		User usr4 = new User("");
		
		//Define a list of users and add all above users in the userList
		List<User> userList = new ArrayList<>();
		
		userList.add(usr1);
		userList.add(usr2);
		userList.add(usr3);
		userList.add(usr4);
		
		//Using stream to count how many users have empty names
		long emptyNameCnt = userList.stream()
									.map(usr -> usr.getFirstName())
									.filter(name -> name.isEmpty())
									.count();
		System.out.println("Empty Name Count : " + emptyNameCnt);
		
		//Using stream to count how many users have non-empty names
		long nonEmptyNameCnt = userList.stream()
				.map(usr -> usr.getFirstName())
				.filter(name -> ! name.isEmpty())
				.count();
		
		System.out.println("Non-Empty Name Count : " + nonEmptyNameCnt);
		
		//Create a list of names of user from the above list of User type
		List<String> userNamesList = userList.stream()
											.map(usr -> usr.getFirstName())
											.collect(Collectors.toList());
		//After creating list of names of the user, print user names
		userNamesList.forEach(name -> System.out.println(name));
		
		
	}

}
