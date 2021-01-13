package com.pluralsight.corejava8.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WritingDataObjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//testMethod1();
		
		testMethod2();

	}

	private static void testMethod2() {
		// TODO Auto-generated method stub
		String fileName = "ExtFiles/person.bin";

		File file = new File(fileName);

		Person p1 = new Person("Amit", 46);
		Person p2 = new Person("Gunjan", 45);
		
		List<Person> personList = new ArrayList();

		try (OutputStream os = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(os);) {

			// Serailize object to output stream
			//Add persons to the list
			personList.add(p1);
			personList.add(p2);
			
			//Write list of persons to output stream
			oos.writeObject(personList);
			

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Try to see size of file, where we have written objects
		try {
			System.out.println("Size of file, Where objects were written : " + Files.size(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void testMethod1() {
		// TODO Auto-generated method stub

		String fileName = "ExtFiles/person.bin";

		File file = new File(fileName);

		Person p1 = new Person("Amit", 46);
		Person p2 = new Person("Gunjan", 45);

		try (OutputStream os = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(os);) {

			// Serailize object to output stream
			oos.writeObject(p1);
			oos.writeObject(p2);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Try to see size of file, where we have written objects
		try {
			System.out.println("Size of file, Where objects were written : " + Files.size(Paths.get(fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
