package com.comcast.crm.contacttest;

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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactLNInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * @author Narahari
 * 
 * 
 */

public class CreateContactTest extends BaseClass {
	@Test(groups = {"smokeTest","regressionTest"})
	public void createContactTest() throws Throwable {
		/* Create Object */
//		FileUtility fLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebDriverUtility wLib = new WebDriverUtility();

		// Read common data from FileUtility

//		String BROWSER = fLib.getDataFromPropertiesFile("browser");
//		String URL = fLib.getDataFromPropertiesFile("url");
//		String USERNAME = fLib.getDataFromPropertiesFile("username");
//		String PASSWORD = fLib.getDataFromPropertiesFile("password");

		/* Read test script data from ExcelUtility and add random utility*/
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

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

		// Using Generic Method Implementation Technique

		// Step 1: Login to application
//		wLib.waitForPageToLoad(driver);
//		driver.get(URL);

//		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		 driver.findElement(By.id("submitButton")).click();
//		 
		// Step 2: Navigate to Organizations Module
//		 driver.findElement(By.linkText("Contacts")).click();

		// Step 3: Click on "Create Contact" Button
//		 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Step 4: Enter the last name and create a new contact
//		 driver.findElement(By.name("lastname")).sendKeys(lastName);

		// Step 5: Click on Save Button
//		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 6: Verify whether the entered last name is correct or not
//		 String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
//		 if (actLastName.equals(lastName)) {
//			System.out.println(lastName+" is verified--PASS");
//		} else {
//			System.out.println(lastName+" is not verified--FAIL");
//		}

		// Step 7: Logout of the application
//		WebElement sign_out=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//		wLib.mousemoveOnElement(driver, sign_out);
//		driver.findElement(By.linkText("Sign Out")).click();

		/*
		 * //Using POM Technique
		 * 
		 * //Step 1: Login to application LoginPage lp = new LoginPage(driver);
		 * lp.loginToApp(URL, USERNAME, PASSWORD);
		 * 
		 * //Step 2: Navigate to Contacts Module HomePage hp = new HomePage(driver);
		 * hp.getContactLink().click();
		 * 
		 * //Step 3: Click on "Create Contact" Button OrganizationsPage ccnp = new
		 * OrganizationsPage(driver); ccnp.getCreateNewContactBtn().click();
		 * 
		 * //Step 4: Enter the last name and create a new contact CreatingNewContactPage
		 * contact = new CreatingNewContactPage(driver);
		 * contact.createLastName(lastName);
		 * 
		 * //Step 5: Verify whether the entered last name is correct or not
		 * ContactLNInfoPage clnip = new ContactLNInfoPage(driver); String actLastName =
		 * clnip.getViewlnMsg().getText(); if (actLastName.equals(lastName)) {
		 * System.out.println(lastName+" is correct--PASS"); } else {
		 * System.out.println(lastName+" is incorrect--FAIL"); } //Step 6: Logout of the
		 * application hp.logout(); driver.quit();
		 */

		// Using Config Annotation Implementation Technique
		/*Step 2: Navigate to Contacts Module*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/*Step 3: Click on "Create Contact" Button*/
		OrganizationsPage ccnp = new OrganizationsPage(driver);
		ccnp.getCreateNewContactBtn().click();

		/*Step 4: Enter the last name and create a new contact CreatingNewContactPage*/
		CreatingNewContactPage contact = new CreatingNewContactPage(driver);
		contact.createLastName(lastName);

		/*Step 5: Verify whether the entered last name is correct or not*/
		ContactLNInfoPage clnip = new ContactLNInfoPage(driver);
//		String actLastName = clnip.getViewlnMsg().getText();
//		if (actLastName.equals(lastName)) {
//			System.out.println(lastName + " is correct--PASS");
//		} else {
//			System.out.println(lastName + " is incorrect--FAIL");
//		}
		String actHeader = clnip.getHeaderMsg().getText();
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		
		String actLastName = clnip.getViewlnMsg().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		Reporter.log(actLastName);
		soft.assertAll();
	}

	@Test(groups = {"smokeTest","regressionTest"})
	public void createContactWithOrganizationTest() throws Throwable {
		/* Read test script data from ExcelUtility and add random utility*/
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3);

		/* Step 2: Navigate to Organizations Module*/
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		/*Step 3: Click on "Create Organization" Button*/
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();

		/*Step 4: Enter all the details and create new Organization*/
		CreatingNewOrganizationPage corgp = new CreatingNewOrganizationPage(driver);
		corgp.createOrg(orgName);

		/*Step 5: Verify Header Message Expected Result*/
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(orgName)) {
			System.out.println(orgName + " is created--PASS");
		} else {
			System.out.println(orgName + " is not created--FAIL");
		}

		/*Step 6: Verify Header Message Expected Result*/
		headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(orgName)) {
			System.out.println(orgName + " is created--PASS");
		} else {
			System.out.println(orgName + " is not created--FAIL");
		}

		hp.getContactLink().click();

		ContactPage ccp = new ContactPage(driver);
		ccp.getAddNewContact().click();

		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.createContactWithOrgName(contactLastName, orgName);
		
		/*Step 7: Verify Header orgName info Expected Result*/
		String actualOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actualOrgName);
		if (actualOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " is created--PASS");
		} else {
			System.out.println(orgName + " is not created--FAIL");
		}
		
	}

	@Test(groups = {"smokeTest","regressionTest"})
	public void createContactWithSupportDateTest() throws Throwable {
		/* Read test script data from ExcelUtility and add random utility*/
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
		
		/*Step 2: Navigate to Contacts Module*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		/*Step 3: Click on "Create Contact" Button*/
		OrganizationsPage cp = new OrganizationsPage(driver);
		cp.getCreateNewContactBtn().click();

		ContactPage cp1 = new ContactPage(driver);
		cp1.getAddNewContact().click();
		
		/*Step 4: Enter the last name and create a new contact*/

		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);

		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.createContactWithSupportDate(lastName, startDate, endDate);
		
		/*Step 5: Verify the start and end dates*/
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		
		if (actStartDate.equals(startDate)) {
			System.out.println(startDate + " is verified--PASS");
		} else {
			System.out.println(startDate + " is not verified--FAIL");
		}

		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		//System.out.println(actEndDate);
		if (actEndDate.equals(endDate)) {
			System.out.println(endDate + " is verified--PASS");
		} else {
			System.out.println(endDate + " is not verified--FAIL");
		}
	}

}