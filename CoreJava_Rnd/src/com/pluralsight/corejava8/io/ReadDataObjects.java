package com.pluralsight.corejava8.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ReadDataObjects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//testMethod1();
		
		testMethod2();

	}

	private static void testMethod2() {
		// TODO Auto-generated method stub
		
		String fileName = "ExtFiles/person.bin";

		File file = new File(fileName);

		try (InputStream is = new FileInputStream(file); ObjectInputStream dis = new ObjectInputStream(is);) {

			List<Person> personList = (List<Person>) dis.readObject();
			
			//Loop over person list
			personList.forEach(person -> System.out.println(person));
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private static void testMethod1() {
		// TODO Auto-generated method stub

		String fileName = "ExtFiles/person.bin";

		File file = new File(fileName);

		try (InputStream is = new FileInputStream(file); ObjectInputStream dis = new ObjectInputStream(is);) {

			Person p1 = (Person) dis.readObject();
			Person p2 = (Person) dis.readObject();

			System.out.println("First Person : " + p1);
			System.out.println("Second Person : " + p2);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
