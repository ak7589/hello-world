package com.pluralsight.corejava8new.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi Amit, welcome to stream java example....");
		
		streamProcessEx1();
		streamProcessEx2();
		

	}

	private static void streamProcessEx2() {
		// TODO Auto-generated method stub
		
		User user1 = new User("Amit1",43);
		User user2 = new User("Amit2",44);
		User user3 = new User("Amit3",45);
		User user4 = new User("Amit4",46);
		User user5 = new User("Amit5",47);
		User user6 = new User("",47);
		User user7 = new User("",47);
		
		List<User> userList = new ArrayList<>();
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		
		long emptyNameCount = userList.stream().map(u -> u.getFirstName()).
				filter(name -> name.isEmpty())
				.count();
		
		System.out.println("emptyNameCount : " + emptyNameCount);
		
		
		long nonEmptyNameCount = userList.stream().map(u -> u.getFirstName()).
				filter(name -> !name.isEmpty())
				.count();
		
		System.out.println("nonEmptyNameCount : " + nonEmptyNameCount);
		
	}

	private static void streamProcessEx1() {
		// TODO Auto-generated method stub
		
		User user1 = new User("Amit1",43);
		User user2 = new User("Amit2",44);
		User user3 = new User("Amit3",45);
		User user4 = new User("Amit4",46);
		User user5 = new User("Amit5",47);
		User user6 = new User("",47);
		User user7 = new User("",47);
		
		List<User> userList = new ArrayList<>();
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		
		//Get Stream
		Stream<User> usrStream = userList.stream();
		Stream<String> userNamestream = usrStream.map(u -> u.getFirstName());
		Stream<String> userNamestream2 = userNamestream.filter(name -> name.isEmpty());
		//Stream<String> userNamestream3 = userNamestream.filter(name -> !name.isEmpty());
		long emptyNamecount = userNamestream2.count();
		
		System.out.println("Empty name count is : " + emptyNamecount);
		
	}

}
