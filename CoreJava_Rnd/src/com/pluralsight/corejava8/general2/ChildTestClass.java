package com.pluralsight.corejava8.general2;

public class ChildTestClass extends ParentTestClass {
	
	@Override
	protected String greetingsMsg() {
		
		String msg = "Welcome msg from ChildTestClass...";
		return msg;
		
	}

}
