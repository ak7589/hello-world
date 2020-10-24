package com.testprgs.designpattern.factory;

public class FactoryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("FactoryDemo Start ---");
		
		OS os = OSFactory.getOS(OSType.Linux);
		
		System.out.println("OS Name : " + os.osName());
		
		OS os2 = OSFactory.getOS(OSType.Windows);
		
		System.out.println("OS Name : " + os2.osName());
		
		System.out.println("FactoryDemo End ---");

	}

}
