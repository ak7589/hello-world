package com.testprgs.designpattern.absfactory;

public class HardDiskFactory implements AbsFactory {

	public HardDisk getHardDisk(HDDType hdType) {

		HardDisk Obj;

		switch (hdType) {

		case HDD:
			Obj = new HDD();
			break;
		case SDD:
			Obj = new SDD();
			break;
		
		default:
			Obj = null;
			break;

		}
		return Obj;
	}

	@Override
	public OS getOS(OSType os) {
		// TODO Auto-generated method stub
		return null;
	}

}
