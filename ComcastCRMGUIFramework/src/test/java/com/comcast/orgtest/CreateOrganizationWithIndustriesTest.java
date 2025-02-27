package com.comcast.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithIndustriesTest {

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
//		String orgName=eLib.getDataFromExcel("org", 4, 2)+jLib.getRandomNumber();
//		String industry=eLib.getDataFromExcel("org", 4, 3);
//		String type=eLib.getDataFromExcel("org", 4, 4);		
		
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
//		LoginPage lp = new LoginPage(driver);
//		lp.loginToApp(URL, USERNAME, PASSWORD);
		  
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
		 
		//Step 2: Navigate to Organizations Module
		//driver.findElement(By.linkText("Organizations")).click();
//		HomePage hp = new HomePage(driver);
//		hp.getOrgLink().click();

		 
		//Step 3: Click on "Create Organization" Button
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		OrganizationsPage cnp = new OrganizationsPage(driver);
//		cnp.getCreateNewOrgBtn().click();

		 
		//Step 4: Enter all the details and create new Organization
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
		//WebElement wbsel1 = driver.findElement(By.name("industry"));
		//wLib.selectByText(wbsel1, "Energy");
//		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
//		cnop.createOrgWithIndustryAndType(orgName, industry, type);
		 
		 
		//WebElement wbsel2 = driver.findElement(By.name("accounttype"));
		//wLib.selectByText(wbsel2, "Press");
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		//Verify the industries and type info
		//String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		//if (actIndustries.equals(industry)) {
		//	System.out.println(industry+" information is verified--PASS");
		//}else {
		//	System.out.println(industry+" information is not verified--FAIL");
		//}

		//String actType = driver.findElement(By.id("dtlview_Type")).getText();
		//if(actType.equals(actType)) {
		//	System.out.println(actType+" information is verified--PASS"); 
		//	}else {
		//		System.out.println(actType+" information is not verified--FAIL"); 
		//	}
		
//		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
//		String actIndustry = oip.getIndustryMsg().getText();
//		if(actIndustry.equals(industry)) {
//			System.out.println(industry+" name is verified--PASS");
//		}else {
//			System.out.println(industry+" name is not verified--FAIL");
//		}
//		
//		String actIndustryType = oip.getIndustryType().getText();
//		if (actIndustryType.equals(type)) {
//			System.out.println(type+" is verified--PASS");
//		} else {
//			System.out.println(type+ " is not verified--FAIL");
//		}
				 
		 //Step 5: Logout of the application
		//WebElement sign_out=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//wLib.mousemoveOnElement(driver, sign_out);
		//driver.findElement(By.linkText("Sign Out")).click();
		
//		hp.logout();
//		driver.quit();
	}
}