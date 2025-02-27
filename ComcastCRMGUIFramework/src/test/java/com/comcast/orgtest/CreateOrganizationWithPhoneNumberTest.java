package com.comcast.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithPhoneNumberTest {
	public static void main(String[] args) throws Throwable {
		/*Create Object*/
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();
		
		//Read common data from JSON file
//		String BROWSER = fLib.getDataFromPropertiesFile("browser");
//		String URL = fLib.getDataFromPropertiesFile("url");
//		String USERNAME = fLib.getDataFromPropertiesFile("username");
//		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		//Read test script data from Excel file
//		String orgName=eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
//		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);		
		
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
		
		//Step 1: Login to application
//		wLib.waitForPageToLoad(driver);
//		driver.get(URL);
		  
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		 
		//Step 2: Navigate to Organizations Module
//		driver.findElement(By.linkText("Organizations")).click();
		 
		//Step 3: Click on "Create Organization" Button
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 
		//Step 4: Enter all the details and create new Organization
//		driver.findElement(By.name("accountname")).sendKeys(orgName); 
//		driver.findElement(By.id("phone")).sendKeys(phoneNumber);
//		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
						
		//Step 5: Verify whether the entered phone number is valid or not
//		String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
//		if (actPhoneNumber.equals(phoneNumber)) {
//			System.out.println(phoneNumber+" is valid--PASS");
//		} else {
//			System.out.println(phoneNumber+" is invalid--FAIL");
//		}
		 
		//Step 6: Logout of the application
//		WebElement sign_out=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wLib.mousemoveOnElement(driver, sign_out);
//		driver.findElement(By.linkText("Sign Out")).click();

		
		//driver.quit();
	}
}