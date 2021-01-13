package com.pluralsight.corejava8new.streamslambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.*;

public class StreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hi Amit, welcome to stream java example....");

		// Below is the 1st example of stream of processing total empty name count
		// and also non-empty name count

		// Below method also contains example of -- Collecting data from Streams and
		// creating list or set
		streamProcessEx1();

		// Stream example of empty and non-empty name count in little different way
		streamProcessEx2();

		// This is an stream example of calculating average age
		streamProcess3();
		// Flat map example

		// Below is the first example of flatMap. Use case is, there is list
		// of citits. Each city contain list of person. Requirement is to find
		// total no of persons in all cities. Also executed a scenario where you
		// want to exclude a particular city
		flatMapExample1();

		// Below example is for creating stream from an array
		createStreamFromArray();

		// Create stream at time of reading file
		createStreamFromFiles();

	}

	private static void createStreamFromFiles() {
		// TODO Auto-generated method stub

		System.out.println("createStreamFromFiles Start ---");

		Path path = Paths.get("ExtFiles/first-names.txt");

		try (Stream<String> lines = Files.lines(path);) {

			// Print all lines
			// lines.forEach(line -> System.out.println(line));

			// Print no of lines in the file
			Long noOfLines = lines.count();
			System.out.println("No of lines in the file : " + noOfLines);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("createStreamFromFiles End ---");

	}

	private static void createStreamFromArray() {
		// TODO Auto-generated method stub

		System.out.println("createStreamFromArray Start...");

		Person p1 = new Person("Amit", 21);
		Person p2 = new Person("Gunjan", 22);
		Person p3 = new Person("Vidut", 24);

		Person[] perArray = { p1, p2, p3 };

		// Create stream to count no of elements in Person[]
		Stream<Person> peopleStream = Arrays.stream(perArray);

		long personCount = peopleStream.count();

		System.out.println("Person Count : " + personCount);

		// Create another stream to demo map-filter-reduce pattern
		Stream<Person> peopleStream2 = Arrays.stream(perArray);

		long personCount2 = peopleStream2.map(person -> person.getName()).filter(name -> !name.equalsIgnoreCase("Amit"))
				.count();
		System.out.println("Person Count exluding Amit..." + personCount2);

		// Create one more stream for the demo of terminal operation for-each
		Arrays.stream(perArray).forEach(p -> System.out.println(p));

		System.out.println("createStreamFromArray End...");

	}

	private static void flatMapExample1() {
		// TODO Auto-generated method stub

		System.out.println("flatMapExample1 Start ---");

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

		long totalPerson = citiList.stream().flatMap(citi -> citi.getPersonList().stream()).count();

		System.out.println("Total Person Count In all Cities are : " + totalPerson);

		System.out.println("Getting person count , by excluding Patna city...");

		long totalPerson2 = citiList.stream().filter(city -> !city.getName().equalsIgnoreCase("Patna"))
				.flatMap(city -> city.getPersonList().stream()).count();
		System.out.println("Person count except Patna city ..." + totalPerson2);

		System.out.println("flatMapExample1 End ---");

	}

	private static void streamProcess3() {
		// TODO Auto-generated method stub

		List<Person> personList = new ArrayList<>();

		personList.add(new Person("Amit1", 10));
		personList.add(new Person("Amit2", 18));
		personList.add(new Person("Amit3", 44));
		personList.add(new Person("Amit4", 45));
		personList.add(new Person("Amit5", 46));

		long count1 = personList.stream().map(p -> p.getAge()).filter(n -> n > 20).count();

		System.out.println("Count of person, having age >20 :" + count1);

		long count2 = personList.stream().map(p -> p.getAge()).filter(n -> n < 20).count();

		System.out.println("Count of person, having age < 20 :" + count2);

	}

	private static void streamProcessEx2() {
		// TODO Auto-generated method stub

		User user1 = new User("Amit1", 43);
		User user2 = new User("Amit2", 44);
		User user3 = new User("Amit3", 45);
		User user4 = new User("Amit4", 46);
		User user5 = new User("Amit5", 47);
		User user6 = new User("", 47);
		User user7 = new User("", 47);

		List<User> userList = new ArrayList<>();

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);

		long emptyNameCount = userList.stream().map(u -> u.getFirstName()).filter(name -> name.isEmpty()).count();

		System.out.println("emptyNameCount : " + emptyNameCount);

		long nonEmptyNameCount = userList.stream().map(u -> u.getFirstName()).filter(name -> !name.isEmpty()).count();

		System.out.println("nonEmptyNameCount : " + nonEmptyNameCount);

	}

	private static void streamProcessEx1()

	{
		// TODO Auto-generated method stub

		System.out.println("streamProcessEx1 Start...");

		User user1 = new User("Amit1", 43);
		User user2 = new User("Amit2", 44);
		User user3 = new User("Amit3", 45);
		User user4 = new User("Amit4", 46);
		User user5 = new User("Amit5", 47);
		User user6 = new User("", 47);
		User user7 = new User("", 47);

		List<User> userList = new ArrayList<>();

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);

		// Get Stream
		Stream<User> usrStream = userList.stream();
		Stream<String> userNamestream = usrStream.map(u -> u.getFirstName());
		Stream<String> userNamestream2 = userNamestream.filter(name -> name.isEmpty());
		// Stream<String> userNamestream3 = userNamestream.filter(name ->
		// !name.isEmpty());
		long emptyNamecount = userNamestream2.count();

		System.out.println("Empty name count is : " + emptyNamecount);

		System.out.println("Calculate non empty name count also...");

		long nonEmptyNameCount = userList.stream().map(usr -> usr.getFirstName()).filter(name -> !name.isEmpty())
				.count();

		System.out.println("NonEmpty_Name_Count is : " + nonEmptyNameCount);

		// Example of converting to the list from the stream --start
		List<String> nameList = userList.stream().map(usr -> usr.getFirstName()).filter(name -> !name.isEmpty())
				.collect(Collectors.toList());
		// Example of converting to the list from the stream --end

		System.out.println("streamProcessEx1 End...");

	}

}
