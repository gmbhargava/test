package PageFactory;

import java.util.List;

import org.openqa.selenium.By;

import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class TransactionHistoryList extends Basedriver{

	public TransactionHistoryList(IOSDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By mainAccountBal =By.xpath("//XCUIElementTypeStaticText[@name='+ $5686.56']");
	By backbtn =By.xpath("//XCUIElementTypeNavigationBar/XCUIElementTypeButton[1]");
	By dte=By.xpath("//XCUIElementTypeStaticText[@name='MAY 29, 2018 AT 4:05 PM']");
	By mrchntName=By.xpath("//XCUIElementTypeStaticText[@name='merchantNameLabel']");
	
	public MobileElement mainAccountBalance()
	{
		MobileElement mainBal=driver.findElement(mainAccountBal);
		return mainBal;
		
	}
	public MobileElement merchantInfo()
	{
		MobileElement mrchntInfo=driver.findElement(mrchntName);
		return mrchntInfo;
		
	}
	public List<MobileElement> merchantInfos()
	{
		List<MobileElement> mrchntInfos=driver.findElements(mrchntName);
		return mrchntInfos;
		
	}
	public MobileElement backNavigationButton()
	{
		MobileElement bckbtn=driver.findElement(backbtn);
		return bckbtn;
	}
	
	public MobileElement dateDescription()
	{
		MobileElement date=driver.findElement(dte);
		return date;
	}

}
