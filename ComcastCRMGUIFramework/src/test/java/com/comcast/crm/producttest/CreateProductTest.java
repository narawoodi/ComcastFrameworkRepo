package com.comcast.crm.producttest;

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
import com.comcast.crm.objectrepositoryutility.HomePage;

/**
 * 
 * @author Narahari
 * 
 * 
 * 
 */


public class CreateProductTest {
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
		String productName = eLib.getDataFromExcel("products", 1, 2);
		String vendorName = eLib.getDataFromExcel("products", 1, 3)+jLib.getRandomNumber();
		
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
		
		/*Step 2: Navigate to Vendors Module*/
		HomePage hp = new HomePage(driver);
		hp.navigateToVendorPage();
		
		/*Step 3: Navigate to Vendors Module*/
		driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		
		/*Step 4: Enter all the details and create new Lead*/
		driver.findElement(By.name("vendorname")).sendKeys(vendorName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 5: Verify whether the entered details is correct or not*/
		String actVendorName = driver.findElement(By.id("dtlview_Vendor Name")).getText();
		if (actVendorName.equals(vendorName)) {
			System.out.println(vendorName+" entered is valid--PASS");
		} else {
			System.out.println(vendorName+" entered is invalid--FAIL");
		}


		/*Step 6: Navigate to Products Module  */
		driver.findElement(By.linkText("Products")).click();
		 
		/*Step 7: Click on "Create Product" Button*/
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		
		/*Step 8: Enter all the details and create new Lead*/
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img")).click();
		
		
		/*Step 9: Switch to child window*/
		wLib.switchToTabOnURL(driver, "module=Vendors");
		
		driver.findElement(By.name("search_text")).sendKeys(vendorName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+vendorName+"']")).click();
		
		/*Step 10: Switch to parent window*/
		wLib.switchToTabOnURL(driver, "Products&action");
		
		/*Step 11: Click on Save Button*/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 12: Verify Header Message Expected Result*/
		String actProductName = driver.findElement(By.id("dtlview_Product Name")).getText();
		if (actProductName.equals(productName)) {
			System.out.println(productName+" entered is correct--PASS");
		} else {
			System.out.println(productName+" entered is incorrect--FAIL");
		}
		
		/*Step 13: Logout of the application*/
		WebElement sign_out=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mousemoveOnElement(driver, sign_out);
		driver.findElement(By.linkText("Sign Out")).click();

		/*Step 14: Close the browser */
		driver.quit();
	}
}