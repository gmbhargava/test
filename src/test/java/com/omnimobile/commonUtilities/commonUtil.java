package com.omnimobile.commonUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class commonUtil {

	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String AUTOMATION_TYPE;
	public static String APP;
	public static String APP2;
	public static Properties property=new Properties();
	public static DesiredCapabilities capabilities =new DesiredCapabilities();
	public static IOSDriver driver;
	public static URL  url;
	public static String SERVER;
	public static String propertyFile="config.properties";
	
	
	
	public static void loadConfig(String fileName) throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/Properties/"+fileName);
		property.load(fis);
		PLATFORM_NAME=property.getProperty("platformName");
		System.out.println(PLATFORM_NAME);
		PLATFORM_VERSION=property.getProperty("platform.version");
		System.out.println(PLATFORM_VERSION);
		DEVICE_NAME=property.getProperty("device.name");
		AUTOMATION_TYPE=property.getProperty("automation.type");
		APP=property.getProperty("app");
		APP2=property.getProperty("app2");
		SERVER=property.getProperty("server.url");
		
		
	}
	
	public static void setCapabilities()
	{
		System.out.println(commonUtil.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, commonUtil.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, commonUtil.PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, commonUtil.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, commonUtil.AUTOMATION_TYPE);
		capabilities.setCapability(MobileCapabilityType.APP, commonUtil.APP);
		
	}
	
	public static void setCapabilitiesApp2()
	{
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, commonUtil.PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, commonUtil.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, commonUtil.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, commonUtil.AUTOMATION_TYPE);
		capabilities.setCapability(MobileCapabilityType.APP, commonUtil.APP2);
		
	}
	
	public static IOSDriver getDriver() throws MalformedURLException
	{
		url=new URL(commonUtil.SERVER);
		driver= new IOSDriver(new URL(commonUtil.SERVER), capabilities);
		return driver;
		
	}
	
	
	 
}
