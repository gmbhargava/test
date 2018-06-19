package PageFactory;

import java.util.List;

import org.openqa.selenium.By;

import com.omnimobile.commonUtilities.Basedriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class navigationDashboard extends Basedriver{

	By nav_header = By.id("GreetingLabel");

	By nav_date = By.id("DateLabel");
	
	By nav_account01 = By.id("AccountCell_0");
	
	By nav_account02 = By.id("AccountCell_1");
	
	By nav_account03 = By.id("AccountCell_2");
	
	By numofAcc = By.xpath("//XCUIElementTypeCell[contains(@name, 'AccountCell_')]"); 
	
	By nav_account01_label = By.id("AccountLabel_0");
	
	By nav_account02_label = By.id("AccountLabel_1");
	
	By nav_account03_label = By.id("AccountLabel_2");
	
	By nav_amount01_label = By.id("AmountLabel_0");
	
	By nav_amount02_label = By.id("AmountLabel_1");
	
	By nav_amount03_label = By.id("AmountLabel_2");
	
	By nav_totalBalance_label = By.id("TotalBalanceLabel_3");
	
	By nav_totalAmount = By.id("TotalAmount_3");
	
	By quickActions_title_label = By.id("quickActionTitleLabel");
	
	By quickActions_transfer_icon = By.id("Transfer 1");
	
	By quickActions_transfer = By.id("Transfer");
	
	By quickActions_deposit_icon = By.id("deposit 1");
	
	By quickActions_deposit = By.id("deposit");
	
	By quickActions_payBill_icon = By.id("");
	
	By quickActions_payBill = By.id("");
	
	By quickActions_sendMoney_icon = By.id("");
	
	By quickActions_sendMoney = By.id("");
	
	By quickActions_requestMoney_icon = By.id("");
	
	By quickActions_requestMoney = By.id("");
	
	By quickActions_splitBill_icon = By.id("");
	
	By quickActions_splitBill = By.id("");
	
	
	public List<MobileElement> numberOfAccounts()
	{
		List <MobileElement> accountsNUmber = driver.findElements(numofAcc);
		return accountsNUmber;
	}
	
	
	
	public navigationDashboard(IOSDriver driver)
	{
		super(driver);
	}
	
	public MobileElement nav_header_main()
	{
		MobileElement nav_header_main=(MobileElement) driver.findElement(nav_header);
		return nav_header_main;
	}
	
	public MobileElement nav_date_main()
	{
		MobileElement nav_date_main=(MobileElement) driver.findElement(nav_date);
		return nav_date_main;
	}
	
	public MobileElement nav_account01_main()
	{
		MobileElement nav_account01_main=(MobileElement) driver.findElement(nav_account01);
		return nav_account01_main;
	}
	
	public MobileElement nav_account02_main()
	{
		MobileElement nav_account02_main=(MobileElement) driver.findElement(nav_account02);
		return nav_account02_main;
	}
	
	public MobileElement nav_account03_main()
	{
		MobileElement nav_account03_main=(MobileElement) driver.findElement(nav_account03);
		return nav_account03_main;
	}
	

	public MobileElement nav_account01_label_main()
	{
		MobileElement nav_account01_label_main=(MobileElement) driver.findElement(nav_account01_label);
		return nav_account01_label_main;
	}
	
	public MobileElement nav_account02_label_main()
	{
		MobileElement nav_account02_label_main=(MobileElement) driver.findElement(nav_account02_label);
		return nav_account02_label_main;
	}
	
	public MobileElement nav_account03_label_main()
	{
		MobileElement nav_account03_label_main=(MobileElement) driver.findElement(nav_account03_label);
		return nav_account03_label_main;
	}
	
	public MobileElement nav_amount01_label_main()
	{
		MobileElement nav_amount01_label_main=(MobileElement) driver.findElement(nav_amount01_label);
		return nav_amount01_label_main;
	}
	
	public MobileElement nav_amount02_label_main()
	{
		MobileElement nav_amount02_label_main=(MobileElement) driver.findElement(nav_amount02_label);
		return nav_amount02_label_main;
	}
	
	public MobileElement nav_amount03_label_main()
	{
		MobileElement nav_amount03_label_main=(MobileElement) driver.findElement(nav_amount03_label);
		return nav_amount03_label_main;
	}
	
	public MobileElement nav_totalBalance_label_main()
	{
		MobileElement nav_totalBalance_label_main=(MobileElement) driver.findElement(nav_totalBalance_label);
		return nav_totalBalance_label_main;
	}
	
	public MobileElement nav_totalAmount_label_main()
	{
		MobileElement nav_totalAmount_label_main=(MobileElement) driver.findElement(nav_totalAmount);
		return nav_totalAmount_label_main;
	}
	
	
	public MobileElement nav_quickActions_label_main()
	{
		MobileElement nav_quickActions_label_main=(MobileElement) driver.findElement(quickActions_title_label);
		return nav_quickActions_label_main;
	}
	
	public MobileElement nav_quickActions_transfer_icon_main()
	{
		MobileElement nav_quickActions_transfer_icon_main=(MobileElement) driver.findElement(quickActions_transfer_icon);
		return nav_quickActions_transfer_icon_main;
	}
	
	public MobileElement nav_quickActions_transfer_main()
	{
		MobileElement nav_quickActions_transfer_main=(MobileElement) driver.findElement(quickActions_transfer);
		return nav_quickActions_transfer_main;
	}
	
	public MobileElement nav_quickActions_deposit_icon_main()
	{
		MobileElement nav_quickActions_deposit_icon_main=(MobileElement) driver.findElement(quickActions_deposit_icon);
		return nav_quickActions_deposit_icon_main;
	}
	
	public MobileElement nav_quickActions_deposit_main()
	{
		MobileElement nav_quickActions_deposit_main=(MobileElement) driver.findElement(quickActions_deposit);
		return nav_quickActions_deposit_main;
	}
}
