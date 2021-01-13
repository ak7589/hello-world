package com.testprgs.designpattern.absfactory;

public class OSFactory implements AbsFactory {

	public OS getOS(OSType os) {

		OS osObj;

		switch (os) {

		case Linux:
			osObj = new Linux();
			break;
		case Windows:
			osObj = new Windows();
			break;
		case Android:
			osObj = new Android();
			break;
		default:
			osObj = null;
			break;

		}
		return osObj;
	}

	@Override
	public HardDisk getHardDisk(HDDType hdType) {
		// TODO Auto-generated method stub
		return null;
	}

}
