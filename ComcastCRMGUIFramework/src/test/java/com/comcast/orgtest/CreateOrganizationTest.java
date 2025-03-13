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
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.listenerutility.ListenerImplementationClass;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * 
 * @author Narahari
 * 
 * 
 * 
 */
@Listeners(com.comcast.crm.generic.listenerutility.ListenerImplementationClass.class)
public class CreateOrganizationTest extends BaseClass {
	
	@Test(groups = {"smokeTest","regressionTest"})

	public void createOrganizationTest() throws Throwable {
		/*Create Object*/
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
		//WebDriverUtility wLib = new WebDriverUtility();
		
		//Read common data from JSON file
//		String BROWSER = fLib.getDataFromPropertiesFile("browser");
//		String URL = fLib.getDataFromPropertiesFile("url");
//		String USERNAME = fLib.getDataFromPropertiesFile("username");
//		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		
		ListenerImplementationClass.test.log(Status.INFO, "Read data from Excel");
		//UtilityClassObject.getTest().log(Status.INFO, "Read data from Excel");
		/*Read test script data from Excel file*/
		String orgName=eLib.getDataFromExcel("org",1,2)+jLib.getRandomNumber();
			
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
		
		/*
		 * //Step 1: Login to application wLib.waitForPageToLoad(driver);
		 * driver.get(URL);
		 * 
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 * 
		 * //Step 2: Navigate to Organizations Module
		 * driver.findElement(By.linkText("Organizations")).click();
		 * 
		 * //Step 3: Click on "Create Organization" Button
		 * driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(
		 * );
		 * 
		 * //Step 4: Enter all the details and create new Organization
		 * driver.findElement(By.name("accountname")).sendKeys(orgName);
		 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 * 
		 * //Verify Header Message Expected Result String headerinfo =
		 * driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText(); if
		 * (headerinfo.contains(orgName)) {
		 * System.out.println(orgName+" is created--PASS"); }else {
		 * System.out.println(orgName+" is not created--FAIL"); } //Verify Header
		 * orgName info Expected Result String actualOrgName =
		 * driver.findElement(By.id("dtlview_Organization Name")).getText(); if
		 * (actualOrgName.equals(orgName)) {
		 * System.out.println(orgName+" is created--PASS"); }else {
		 * System.out.println(orgName+" is not created--FAIL"); } //Step 5: Logout of
		 * the application WebElement sign_out=driver.findElement(By.xpath(
		 * "//img[@src='themes/softed/images/user.PNG']"));
		 * wLib.mousemoveOnElement(driver, sign_out);
		 * driver.findElement(By.linkText("Sign Out")).click();
		 */	

		
		
		
		
		
		//Using POM Design Technique
		
		//Step 1: Login to application		
//		LoginPage lp = new LoginPage(driver);		
//		lp.loginToApp(URL, USERNAME, PASSWORD);
		
		//Step 2: Navigate to Organizations Module
//		HomePage hp = new HomePage(driver);
//		hp.getOrgLink().click();

		//Step 3: Click on "Create Organization" Button
//		OrganizationsPage cnp = new OrganizationsPage(driver);
//		cnp.getCreateNewOrgBtn().click();
		
		//Step 4: Enter all the details and create new OrganizationInfoPage
//		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
//		cnop.createOrg(orgName);
		
		//Step 5: Verify Header Message Expected Result
//		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
//		String actOrgName = oip.getHeaderMsg().getText();
//		if(actOrgName.contains(orgName)) {
//			System.out.println(orgName+" name is verified--PASS");
//		}else {
//			System.out.println(orgName+" name is not verified--FAIL");
//		}
		
		//Step 6: Logout of the application
//		hp.logout();
//		driver.quit();
		
		
		//Using Configuration Annotation Technique		
		/*Step 2: Navigate to Organizations Module*/
		ListenerImplementationClass.test.log(Status.INFO, "Navigate to Organization Page");
		//UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organization Page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		/*Step 3: Click on "Create Organization" Button*/
		ListenerImplementationClass.test.log(Status.INFO, "Click on Create Organization Page");
		//UtilityClassObject.getTest().log(Status.INFO, "Click on Create Organization Page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		
		/*Step 4: Enter all the details and create new OrganizationInfoPage*/
		ListenerImplementationClass.test.log(Status.INFO, "Create a new Organization");
		//UtilityClassObject.getTest().log(Status.INFO, "Create a new Organization");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		ListenerImplementationClass.test.log(Status.INFO, orgName+"---->Create a new Organization"); //Display the organization name which is getiing created during the run-time
		
		/*Step 5: Verify Header Message Expected Result*/
		ListenerImplementationClass.test.log(Status.INFO, "Verify Header Message Expected Result");
		//UtilityClassObject.getTest().log(Status.INFO, orgName+" Header Message Expected is PASS");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
	}
	
	@Test(groups = {"smokeTest","regressionTest"})
	public void createOrganizationWithIndustriesTest() throws Throwable {
		ListenerImplementationClass.test.log(Status.INFO, "Read data from Excel");
		/*Read test script data from Excel file*/
		String orgName=eLib.getDataFromExcel("org", 4, 2)+jLib.getRandomNumber();
		String industry=eLib.getDataFromExcel("org", 4, 3);
		String type=eLib.getDataFromExcel("org", 4, 4);
		
		/*Step 2: Navigate to Organizations Module*/
		ListenerImplementationClass.test.log(Status.INFO, "Navigate to Organizations Module");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		 
		/*Step 3: Click on "Create Organization" Button*/
		ListenerImplementationClass.test.log(Status.INFO, "Click on Create Organization Button");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
 
		/*Step 4: Enter all the details and create new Organization*/
		ListenerImplementationClass.test.log(Status.INFO, "Enter all the details and create new Organization");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgWithIndustryAndType(orgName, industry, type);
			
		/*Step 5: Verify the Organization Name, industries and type info*/
		ListenerImplementationClass.test.log(Status.INFO, "Verify the Organization Name, industries and type info");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
		String actIndustry = oip.getIndustryMsg().getText();
		Assert.assertEquals(true, actIndustry.equals(industry));
		String actIndustryType = oip.getIndustryType().getText();
		Assert.assertEquals(true, actIndustryType.equals(type));
	}
	
	@Test(groups = {"smokeTest","regressionTest"})
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		ListenerImplementationClass.test.log(Status.INFO, "Read data from Excel");
		/*Read test script data from Excel file*/
		String orgName=eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
		
		/*Step 2: Navigate to Organizations Module*/
		ListenerImplementationClass.test.log(Status.INFO, "Navigate to Organizations Module");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		 
		/*Step 3: Click on "Create Organization" Button*/
		ListenerImplementationClass.test.log(Status.INFO, "Click on Create Organization Button");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		/*Step 4: Enter all the details and create new Organization with Phone Number*/
		ListenerImplementationClass.test.log(Status.INFO, "Enter all the details and create new Organization with Phone Number");
		CreatingNewOrganizationPage corgp = new CreatingNewOrganizationPage(driver);
		corgp.createOrgWithPhoneNumber(orgName, phoneNumber);
		
		/*Step 5: Verify whether the entered Organization and phone number details are valid or not*/
		ListenerImplementationClass.test.log(Status.INFO, "Verify whether the entered Organization and phone number details are valid or not");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
		String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		Assert.assertEquals(true, actPhoneNumber.equals(phoneNumber));
	}
}