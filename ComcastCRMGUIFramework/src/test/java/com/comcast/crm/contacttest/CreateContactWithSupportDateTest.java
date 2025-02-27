package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactLNInfoPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithSupportDateTest {
	public static void main(String[] args) throws Throwable {
		/*Create Object*/
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
		
		//Read common data from properties file
//		String BROWSER = fLib.getDataFromPropertiesFile("browser");
//		String URL = fLib.getDataFromPropertiesFile("url");
//		String USERNAME = fLib.getDataFromPropertiesFile("username");
//		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		//Read test script data from Excel file
//		String lastName = eLib.getDataFromExcel("contact",4,2) + jLib.getRandomNumber();
		
//		WebDriver driver=null; //Declaration
//		if (BROWSER.equals("chrome")) {
//			driver=new ChromeDriver(); //Initialization
//		}else if(BROWSER.equals("firefox")) {
//			driver=new FirefoxDriver();
//		}else if(BROWSER.equals("edge")) {
//			driver=new EdgeDriver();
//		}else {
//			driver=new ChromeDriver();
//		}
		
		
		
		
		//Using Generic Utility Implementation Technique
		
		//Step 1: Login to application
//		wLib.waitForPageToLoad(driver);
//		driver.get(URL);
		  
//		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		 driver.findElement(By.id("submitButton")).click();
		 
		 //Step 2: Navigate to Organizations Module
//		 driver.findElement(By.linkText("Contacts")).click();
		 
		 //Step 3: Click on "Create Contact" Button
//		 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 
		 //Step 4: Enter the last name and create a new contact
		 
//		 String startDate = jLib.getSystemDateYYYYDDMM();
//		 String endDate = jLib.getRequiredDateYYYYDDMM(30);
		 
//		 driver.findElement(By.name("lastname")).sendKeys(lastName);
//		 driver.findElement(By.name("support_start_date")).clear();
//		 driver.findElement(By.name("support_start_date")).sendKeys(startDate);
		 
//		 driver.findElement(By.name("support_end_date")).clear();
//		 driver.findElement(By.name("support_end_date")).sendKeys(endDate);
		 
		 //Step 5: Click on Save Button
//		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 
		 //Step 6: Verify the start and end dates
//		 String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
//		 if (actStartDate.equals(startDate)) {
//			System.out.println(startDate+" is verified--PASS");
//		} else {
//			System.out.println(startDate+" is not verified--FAIL");
//		}
//
//		 String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
//		 
//		 if (actEndDate.equals(endDate)) {
//			System.out.println(endDate+" is verified--PASS");
//		} else {
//			System.out.println(endDate+" is not verified--FAIL");
//		}


		//Step 7: Logout of the application
//		WebElement sign_out=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wLib.mousemoveOnElement(driver, sign_out);
//		driver.findElement(By.linkText("Sign Out")).click();
		
		
		//Using POM Design Technique
		//Step 1: Login to application
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(URL, USERNAME, PASSWORD);
		//Step 2: Navigate to Contacts Module
//		HomePage hp = new HomePage(driver);
//		hp.getContactLink().click();
		//Step 3: Click on "Create Contact" Button
//		OrganizationsPage cp = new OrganizationsPage(driver);
//		cp.getCreateNewContactBtn().click();
		//Step 4: Enter the last name and create a new contact
//		String endDate = jLib.getSystemDateYYYYDDMM();
//		String startDate = jLib.getRequiredDateYYYYDDMM(30);
//		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
//		ccp.createContactWithSupportDate(lastName, startDate, endDate);
		//Step 5: Verify the start and end dates
//		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
//		if (actStartDate.equals(startDate)) {
//			System.out.println(startDate+" is verified--PASS");
//		} else {
//			System.out.println(startDate+" is not verified--FAIL");
//		}
//
//		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
//		 
//		if (actEndDate.equals(endDate)) {
//			System.out.println(endDate+" is verified--PASS");
//		} else {
//			System.out.println(endDate+" is not verified--FAIL");
//		}
		//Step 7: Logout of the application
//		hp.logout();
	}
}