package com.pluralsight.corejava8.general2;

public class TestnewInstance
{ 
	
	public void displayMsg() {
		System.out.println("displayMsg of TestnewInstance class...");
	}
	
    public static void main(String[] args) 
                         throws ClassNotFoundException, InstantiationException, 
                         IllegalAccessException 
    { 
        // returns the Class object for this class 
        Class myClass = Class.forName("com.pluralsight.corejava8.general2.TestnewInstance"); 
          
        // creating new instance of this class 
        // newInstance method 
        Object obj = myClass.newInstance(); 
        
        TestnewInstance var1 = (TestnewInstance)obj;
        
        //Call method of TestnewInstance type object to confirm that new
        //object has really been created
        var1.displayMsg();
          
        // returns the runtime class of obj 
        System.out.println("Class of var1 : " + var1.getClass()); 
    } 
} 
