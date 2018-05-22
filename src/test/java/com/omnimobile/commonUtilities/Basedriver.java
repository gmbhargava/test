package com.omnimobile.commonUtilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class Basedriver {

	
	public IOSDriver<MobileElement> driver;
	
	
	public Basedriver(IOSDriver<MobileElement> driver)
	{
		this.driver=driver;
	}
}
