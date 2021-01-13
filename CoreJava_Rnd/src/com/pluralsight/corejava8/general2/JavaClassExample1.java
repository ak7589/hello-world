package com.pluralsight.corejava8.general2;

public class JavaClassExample1 {
	public static void main(String[] args)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		// returns the Class object for the class with the given name
		Class class1 = Class.forName("java.lang.String");
		Class class2 = int.class;
		System.out.print("Class represented by class1: ");
		// applying toString method on class1
		System.out.println(class1.toString());
		System.out.print("Class represented by class2: ");
		// applying toString() method on class2
		System.out.println(class2.toString());
		String s = "JavaTpoint";
		int i = 10;

		// checking for Class instance
		boolean b1 = class1.isInstance(s);
		//boolean b2 = class1.isInstance(i);
		boolean b2 = class2.isInstance(i);
		System.out.println("is s instance of String : " + b1);
		System.out.println("is i instance of String : " + b2);
	}
}
