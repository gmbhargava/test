package com.omnimobile.commonUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import PageFactory.Login;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class commonUtil {

	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static String AUTOMATION_TYPE;
	public static String APP;
	public static String APP2;
	public static Properties property = new Properties();
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static IOSDriver driver;
	public static URL url;
	public static String SERVER;
	public static String propertyFile = "config.properties";
	public static String USERNAME;
	public static ExtentReports extent;
	public static Login loginUtility;
	public static String NO_RESET;

	public static String UDID;

	public static String XCODEORGID;

	public static String XCODESIGNINGID;

	public static ExtentReports returnInstance() {
		if (extent == null) {
			extent = new ExtentReports(
					System.getProperty("user.dir") + "/src/test/resources/ExecutionReports/ExecutionReport.html", true,
					DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(
					new File(System.getProperty("user.dir") + "/src/test/resources/ExtentConfig/ReportsConfig.xml"));
		}

		return extent;
	}

	public static String getScreenshot(String fileName) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File source = screen.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/src/test/resources/Screenshots/" + fileName + ".png";
		File destin = new File(destination);
		FileUtils.copyFile(source, destin);
		return destination;

	}

	public static void verticalSwipe(double startPercentage, double finalPercentage) {

		Dimension size = driver.manage().window().getSize();
		int width = size.width / 2;
		int start = (int) (size.getHeight() * startPercentage);
		int endPoint = (int) (size.getHeight() * finalPercentage);
		new TouchAction(driver).press(width, start).waitAction(Duration.ofMillis(500)).moveTo(width, endPoint).release()
				.perform();

	}

	public static void HorizontalSwipe(double from, double to, double length) {
		Dimension size = driver.manage().window().getSize();
		int height = size.getHeight();
		int width = size.getWidth();
		int y = (int) (height * length);
		int start = (int) (width * from);
		int end = (int) (width * to);
		new TouchAction(driver).press(start, y).waitAction(Duration.ofMillis(500)).moveTo(end, y).release().perform();
	}

	public static void loadConfig(String fileName) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/Properties/" + fileName);
		property.load(fis);
		PLATFORM_NAME = property.getProperty("platformName");
		System.out.println(PLATFORM_NAME);
		PLATFORM_VERSION = property.getProperty("platform.version");
		System.out.println(PLATFORM_VERSION);
		DEVICE_NAME = property.getProperty("device.name");
		AUTOMATION_TYPE = property.getProperty("automation.type");
		APP = property.getProperty("app");
		NO_RESET = property.getProperty("noReset");

		UDID = property.getProperty("udid");

		XCODEORGID = property.getProperty("xcodeOrgId");

		XCODESIGNINGID = property.getProperty("xcodeSigningId");

		SERVER = property.getProperty("server.url");
		USERNAME = property.getProperty("userName");

	}

	public static String loadTestData(String keyName) throws IOException {
		String fileName = commonUtil.USERNAME;
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/Properties/TestData/" + fileName + ".properties");
		property.load(fis);
		String keyVal = property.getProperty(keyName);
		return keyVal;

	}

	public static void setCapabilities() {
		System.out.println(commonUtil.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, commonUtil.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, commonUtil.PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, commonUtil.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, commonUtil.AUTOMATION_TYPE);
		capabilities.setCapability(MobileCapabilityType.APP, commonUtil.APP);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, commonUtil.NO_RESET);

		capabilities.setCapability(MobileCapabilityType.UDID, commonUtil.UDID);

		capabilities.setCapability("XCODEORGID", commonUtil.XCODEORGID);

		capabilities.setCapability("XCODESIGNINGID", commonUtil.XCODESIGNINGID);

	}

	public static void setCapabilitiesApp2() {

		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, commonUtil.PLATFORM_VERSION);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, commonUtil.PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, commonUtil.DEVICE_NAME);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, commonUtil.AUTOMATION_TYPE);
		capabilities.setCapability(MobileCapabilityType.APP, commonUtil.APP2);

	}

	public static IOSDriver getDriver() throws MalformedURLException {
		url = new URL(commonUtil.SERVER);
		driver = new IOSDriver(new URL(commonUtil.SERVER), capabilities);
		return driver;

	}

	public static String suiteSwitch() throws FileNotFoundException {
		String report = System.getProperty("user.dir") + "/test-output/OmniMobileApp-SmokeTests/OmniApp-SmokeTest.html";
		String suiteKey = "";
		try {
			BufferedReader read = new BufferedReader(new FileReader(report));
			String line;
			while ((line = read.readLine()) != null) {

				if (line.toString().contains("<td>Tests passed")) {
					String refined = line.toString().replaceAll("<td>", "").replaceAll("</td>", "")
							.replaceAll("Tests passed/Failed/Skipped:", "");
					String[] failedtsts = refined.split("/");
					String failedTestCases = failedtsts[1];
					suiteKey += failedTestCases;
					break;
				} else {
					continue;
				}
			}
			System.out.println(suiteKey);
			read.close();
		} catch (Exception e) {
			suiteKey += "0";

		}

		return suiteKey;

	}
	
	public static void swipeDown(MobileElement scroll) {
	            //MobileElement scroll =(MobileElement) driver.findElementsByXPath("(//XCUIElementTypeStaticText[@name=\"SelectRecipientName\"])[16]");
		TouchAction ac3 = new TouchAction(driver);
		ac3.longPress(scroll).moveTo(50, 300).perform();
	}

	public static void login() {
		loginUtility = new Login(driver);
		loginUtility.userNameTextBox().click();
		loginUtility.clearTexticon().click();

		loginUtility.userNameTextBox().click();
		;
		driver.getKeyboard().sendKeys("jnyt1dev04");
		loginUtility.passwordTextbox().click();
		driver.getKeyboard().sendKeys("spring18");
		driver.hideKeyboard();
		loginUtility.loginButton().click();
	}

}
