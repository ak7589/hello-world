package com.testprgs.designpattern.absfactory;

public class AbsFactoryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbsFactory obj1 = FactoryCreator.getFactory(FactoryType.OS);
		
		OS os = obj1.getOS(OSType.Linux);
		
		System.out.println("OS REceived : " + os.osName());
		
		AbsFactory obj2 = FactoryCreator.getFactory(FactoryType.HDD);
		
		HardDisk hd = obj2.getHardDisk(HDDType.SDD);
		
		System.out.println("HDD Type received : " + hd.name());

	}

}
