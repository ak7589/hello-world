package com.testprgs.designpattern.absfactory;

public class FactoryCreator {

	public static AbsFactory getFactory(FactoryType facType) {
		
		AbsFactory absFactory = null ;
		
		switch(facType){
			
			case OS :
				absFactory = new OSFactory();
				break;
			case HDD :
				absFactory = new HardDiskFactory();
				break;
				
			default :
				break;
					
			
		}
		
		return absFactory;
		
	}

}
