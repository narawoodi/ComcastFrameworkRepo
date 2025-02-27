package com.comcast.crm.leadtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateLeadWithPhoneNumberTest {
	public static void main(String[] args) throws Throwable {
		/*Create Object*/
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		/*Read common data from JSON file*/
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		/*Read test script data from Excel file*/
		String leadName = eLib.getDataFromExcel("lead", 4, 2)+jLib.getRandomNumber();
		String companyName = eLib.getDataFromExcel("lead", 4, 3);	
		String phoneNumber = eLib.getDataFromExcel("lead", 4, 4);
		
		WebDriver driver=null; //Declaration
		if (BROWSER.equals("chrome")) {
			driver=new ChromeDriver(); //Initialization
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		
		/*Step 1: Login to application*/
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		  
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*Step 2: Navigate to Leads Module*/
		driver.findElement(By.linkText("Leads")).click();
		 
		/*Step 3: Click on "Create Lead" Button*/
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		
		/*Step 4: Enter all the details and create new Lead*/
		driver.findElement(By.name("lastname")).sendKeys(leadName);
		driver.findElement(By.name("company")).sendKeys(companyName);
		driver.findElement(By.id("phone")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 5: Verify whether the entered details is correct or not*/
		String actLeadName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLeadName.equals(leadName)) {
			System.out.println(leadName+" entered is valid--PASS");
		} else {
			System.out.println(leadName+" entered is invalid--FAIL");
		}
		
		String actCompanyName = driver.findElement(By.id("dtlview_Company")).getText();
		if (actCompanyName.equals(companyName)) {
			System.out.println(companyName+" entered is valid--PASS");
		} else {
			System.out.println(companyName+" entered is invalid--FAIL");
		}
		
		String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if (actPhoneNumber.equals(phoneNumber)) {
			System.out.println(phoneNumber+" entered is valid--PASS");
		} else {
			System.out.println(phoneNumber+" entered is invalid-FAIL");
		}
		
		/*Step 6: Logout of the application*/
		WebElement sign_out=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mousemoveOnElement(driver, sign_out);
		driver.findElement(By.linkText("Sign Out")).click();

		/*Step 7: Close the browser */
		driver.quit();
	}
}