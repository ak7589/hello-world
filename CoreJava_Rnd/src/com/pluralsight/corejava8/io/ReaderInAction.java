package com.pluralsight.corejava8.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ReaderInAction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, Welcome to core java 8 practice...");
		
		File file = new File("ExtFiles/first-names.txt");
		
		//
		System.out.println(file.getName());
		System.out.println(file.exists());
		
		File nope = new File("ExtFiles/nope.txt");
		
		System.out.println(nope.getName());
		System.out.println(nope.exists());
		
		//read file example of try-with-resources pattern
		readFileEx1();
		
		//Same functionality like above but using factory method and streams
		readFileEx2();
		
		//Just use Java7 factory method and read via conventional method
		readFileEx3();
		

	}

	private static void readFileEx3() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("readFileEx3 start ---");

		Path path = Paths.get("ExtFiles/first-names.txt");

		try (BufferedReader bufReader = Files.newBufferedReader(path);) {

			String line = null;
			while( (line = bufReader.readLine()) != null) {
				System.out.println(line);
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("readFileEx3 end ---");

	}

	private static void readFileEx2() {
		// TODO Auto-generated method stub
		System.out.println("readFileEx2 start ---");
		
		Path path = Paths.get("ExtFiles/first-names.txt");
		
		try (BufferedReader bufReader = Files.newBufferedReader(path);) {
			
			//Below code will print each line of the file
			//bufReader.lines().forEach(line -> System.out.println(line));
			
			//Below code will convert stream into a list
			List<String> nameList = bufReader.lines()
					.collect(Collectors.toList());
			
			System.out.println("Printing nameList, after Collectors.toList ---Start ");
			nameList.forEach(name -> System.out.println(name));
			System.out.println("Printing nameList, after Collectors.toList ---End ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("readFileEx2 end ---");
		
		
		
	}

	private static void readFileEx1() {
		// TODO Auto-generated method stub
		
		System.out.println("readFileEx1 Start ---");
		
		File file = new File("ExtFiles/first-names.txt");
		
		try(Reader reader = new FileReader(file);) {
			
			BufferedReader bufReader = new BufferedReader(reader);
			
			String str = null;
			while( (str = bufReader.readLine()) != null) {
				
				System.out.println(str);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("readFileEx1 End ---");
		
		
	}

}
