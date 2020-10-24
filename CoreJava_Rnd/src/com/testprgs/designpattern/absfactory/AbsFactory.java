package com.testprgs.designpattern.absfactory;

public interface AbsFactory {
	
	public HardDisk getHardDisk(HDDType hdType);
	public OS getOS(OSType os);

}
