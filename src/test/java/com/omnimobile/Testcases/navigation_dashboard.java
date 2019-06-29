package com.omnimobile.Testcases;

 
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Clock;
import org.testng.annotations.Test;

import com.omnimobile.commonUtilities.Apploader;
import com.omnimobile.commonUtilities.commonUtil;

import PageFactory.Login;
import junit.framework.Assert;

public class navigation_dashboard extends Apploader{
	
	private static String username = "userapp01";
	private static String password = "spring18";
	
	
	@Test(groups= {"RegressionTest"})
	public void dashboard_Header() throws InterruptedException{
		
		//commonUtil.loginForAll();
		/*loginPage.userNameTextBox().clear();
		loginPage.passwordTextbox().clear();
		loginPage.userNameTextBox().sendKeys(username);
		loginPage.passwordTextbox().sendKeys(password);
		driver.findElement(By.name("Dismiss")).click();
		loginPage.loginButton().click();*/
		Thread.sleep(3000);
	
		//driver.findElement(By.name("Don't Allow")).click();

		
		String nav_header = nav_DashboardPage.nav_header_main().getText(); 
		System.out.println(nav_header);
		String actualUser = "Welcome back, Bruce.";
		
		if(nav_header.equals(actualUser) == true)
		{
			System.out.println("Header is present and correct");
		}
		else
			System.out.println("Header is not present and incorrect");
		
		String nav_dates = nav_DashboardPage.nav_date_main().getText();
		
		
		
		String[] result = nav_dates.split(",",2);
		System.out.println(result);
		
		if(nav_dates.equals("WEDNESDAY, JUNE 13") == true)
		{
			System.out.println("Date is present and correct");
		}
		else
			System.out.println("Date is not present and incorrect");
		
	}

	
	@Test(groups= {"RegressionTest"})
	public void total_balance() throws InterruptedException
	{
		String account1_name = nav_DashboardPage.nav_account01_label_main().getText();
		
		String account1_amount = nav_DashboardPage.nav_amount01_label_main().getText();
		System.out.println(account1_name + "  " +account1_amount);
		
		//To remove '$' 
		String acc1 = account1_amount.substring(1);
		
		//To remove special character ' , ' which is used to divide the amount
		acc1 = acc1.replaceAll(",", "");
		
		//to convert the amount to double
		double acc1_amt = Double.parseDouble(acc1);			
		//System.out.println(acc1_amt);
		
		String account2_name = nav_DashboardPage.nav_account02_label_main().getText();
		
		String account2_amount=nav_DashboardPage.nav_amount02_label_main().getText();
		
		System.out.println(account2_name + "  " +account2_amount);
		String acc2 = account2_amount.substring(1);
		acc2 = acc2.replaceAll(",", "");
		
		
		double acc2_amt = Double.parseDouble(acc2);			
		//System.out.println(acc2_amt);
		
		String account3_name = nav_DashboardPage.nav_account03_label_main().getText();
		
		String account3_amount=nav_DashboardPage.nav_amount03_label_main().getText();
		
		System.out.println(account3_name + "  " +account3_amount);
		String acc3 = account3_amount.substring(1);
		acc3 = acc3.replaceAll(",", "");
		
		
		double acc3_amt = Double.parseDouble(acc3);			
		//System.out.println(acc3_amt);
		System.out.println("----------------------------------------------");
		String total_name = nav_DashboardPage.nav_totalBalance_label_main().getText();
		
		String total_amount=nav_DashboardPage.nav_totalAmount_label_main().getText();
		System.out.println(total_name + "  " + total_amount);
		String ttl = total_amount.substring(1);
		ttl = ttl.replaceAll(",", "");
		
		
		double ttl_amt = Double.parseDouble(ttl);			
		System.out.println("---------------------------------------------------");
		//To round off total to 2 decimal places
		DecimalFormat df = new DecimalFormat("###.##");
		String totalAmounts = df.format(acc1_amt + acc2_amt + acc3_amt);
		double total_Amounts = Double.parseDouble(totalAmounts);			
		String totalAmount = df.format(ttl_amt);
		double total_Amount = Double.parseDouble(totalAmount);			
		System.out.println(total_Amount);
		System.out.println("---------------------------------------------------");
		
		System.out.println("\n" + "Account 1 = " + acc1_amt + "\n" +"Account 2 = " + acc2_amt + "\n" + "Account 3 = " + acc3_amt + "\n" + "Total Balance = " + ttl_amt);
		
		if(total_Amounts == total_Amount)
		{
			System.out.println("\n" + "Account 1 = " + acc1_amt +"\n" + "Account 2 = " + acc2_amt + "\n" + "Account 3 = " + acc3_amt +"\n" + "Total Balance = " + ttl_amt);
		}
		else
		{
			System.out.println("Total Balance doesn't match");
		}
		
	}
	
	
	
	@Test(groups= {"RegressionTest"})
	public void accountsTotal()
	{
		int numberofaccounts = nav_DashboardPage.numberOfAccounts().size();
		
		
	}
	
	
	
	}


	/*public void presentDate() throws ParseException {
		 
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd");
			
		 Date date = new Date();
	
		 String date1= dateFormat.format(date).toString();
		
		 System.out.println(date1);
		
		 
		
		
			 
		 
		 Calendar calendar = Calendar.getInstance();
		
		 int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		 
		
		 
			Date now = new Date();
	 
	        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
	        System.out.println(simpleDateformat.format(now));
	 
	        Calendar calendar1 = Calendar.getInstance();
	        calendar1.setTime(now);
	        System.out.println(calendar1.get(Calendar.DAY_OF_WEEK)); // the day of the week in numerical format
	 
	        String day_of_the_week = simpleDateformat.format(now);
	        System.out.println(day_of_the_week);
	        
	        
	        String day =  nav_DashboardPage.nav_date_main().getText();
	        String sDate2=day;  
	        Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);  
	        System.out.println(sDate2+"\t"+date2);  
		 
	        String myString = nav_DashboardPage.nav_amount01_label_main().toString();
	        int amount = Integer.parseInt(myString);
	        
	        
		 }*/
	
	
	/*String face = driver.findElement(By.id("Use Face ID for a faster login")).getText();
	String facenote = driver.findElement(By.id("It's quicker than logging in with a password. Test text for more fill.")).getText();
	Assert.assertEquals(face, "Use Face ID for a faster login");
	Assert.assertEquals(facenote, "It's quicker than logging in with a password. Test text for more fill.");
	System.out.println(face);
	System.out.println(facenote);
	try
	{
		driver.findElement(By.name("OK")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("Cancel authentication")).click();
	} 
	
	catch (Exception e) {
		
	}
	driver.findElement(By.xpath("//XCUIElementTypeCell[@name=\"GeneralCardCell_0\"]/XCUIElementTypeButton")).click();
	Thread.sleep(8000);
	driver.findElement(By.name("Cancel")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("Cancel authentication")).click();*/
	
	

