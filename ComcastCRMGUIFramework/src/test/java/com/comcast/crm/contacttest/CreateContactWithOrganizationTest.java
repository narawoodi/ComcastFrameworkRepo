package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrganizationTest {
	public static void main(String[] args) throws Throwable {
		/*Create Object*/
		/*
		 * FileUtility fLib = new FileUtility(); ExcelUtility eLib = new ExcelUtility();
		 * JavaUtility jLib = new JavaUtility(); WebDriverUtility wLib = new
		 * WebDriverUtility();
		 */		
		//Read common data from JSON file

		/*
		 * String BROWSER = fLib.getDataFromPropertiesFile("browser"); String URL =
		 * fLib.getDataFromPropertiesFile("url"); String USERNAME =
		 * fLib.getDataFromPropertiesFile("username"); String PASSWORD =
		 * fLib.getDataFromPropertiesFile("password");
		 */		
		//Read test script data from Excel file
		/*
		 * String orgName=eLib.getDataFromExcel("contact",7,2)+jLib.getRandomNumber();
		 * String contactLastName = eLib.getDataFromExcel("contact",7,3);
		 */			
		/*
		 * WebDriver driver=null; //Declaration if (BROWSER.equals("chrome")) {
		 * driver=new ChromeDriver(); //Initialization }else
		 * if(BROWSER.equals("firefox")) { driver=new FirefoxDriver(); }else
		 * if(BROWSER.equals("edge")) { driver=new EdgeDriver(); }else { driver=new
		 * ChromeDriver(); }
		 */		
		
		//Using Generic Utility Implementation Technique
		
		//Step 1: Login to application
		/*
		 * wLib.waitForPageToLoad(driver); driver.get(URL);
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
		 * System.out.println(orgName+" is not created--FAIL"); }
		 * 
		 * 
		 * //Step 5: Navigate to Organizations Module
		 * driver.findElement(By.linkText("Contacts")).click();
		 * 
		 * //Step 6: Click on "Create Contact" Button
		 * driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		 * 
		 * //Step 7: Enter the last name and create a new contact
		 * driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		 * driver.findElement(By.xpath(
		 * "//input[@name='account_name']/following-sibling::img")).click();
		 * 
		 * //Switch to child window wLib.switchToTabOnURL(driver, "module=Accounts");
		 * 
		 * driver.findElement(By.name("search_text")).sendKeys(orgName);
		 * driver.findElement(By.name("search")).click();
		 * driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		 * 
		 * //Switch to parent window wLib.switchToTabOnURL(driver, "Contacts&action");
		 * 
		 * //Step 8: Click on Save Button
		 * driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 * 
		 * //Verify Header Message Expected Result String headerinfo1 =
		 * driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText(); if
		 * (headerinfo1.contains(orgName)) {
		 * System.out.println(orgName+" is created--PASS"); }else {
		 * System.out.println(orgName+" is not created--FAIL"); } //Verify Header
		 * orgName info Expected Result String actualOrgName =
		 * driver.findElement(By.id("mouseArea_Organization Name")).getText(); if
		 * (actualOrgName.trim().equals(orgName)) { //trim() is used to remove spaces
		 * within the String System.out.println(orgName+" is created--PASS"); }else {
		 * System.out.println(orgName+" is not created--FAIL"); }
		 * 
		 * //Step 10: Logout of the application WebElement
		 * sign_out=driver.findElement(By.xpath(
		 * "//img[@src='themes/softed/images/user.PNG']"));
		 * wLib.mousemoveOnElement(driver, sign_out);
		 * driver.findElement(By.linkText("Sign Out")).click();
		 * 
		 * driver.quit();
		 */	}
}