package com.testprgs.designpattern.factory;

public class OSFactory {

	public static OS getOS(OSType os) {

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

}
