package com.comcast.crm.campaigntest;

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


public class CreateCampaignTest {
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
		String campaignName = eLib.getDataFromExcel("campaign", 1, 2)+jLib.getRandomNumber();		
		
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
		hp.navigateToCampaignPage();
		 
		/*Step 3: Click on "Create Vendor" Button*/
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		/*Step 4: Enter all the details and create new Lead*/
		driver.findElement(By.name("campaignname")).sendKeys(campaignName);
		String closeDate = jLib.getRequiredDateYYYYDDMM(30);
		driver.findElement(By.name("closingdate")).clear();
		driver.findElement(By.name("closingdate")).sendKeys(closeDate);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		/*Step 5: Verify whether the entered details is correct or not*/
		String actCampaignName = driver.findElement(By.id("dtlview_Campaign Name")).getText();
		if (actCampaignName.equals(campaignName)) {
			System.out.println(campaignName+" entered is valid--PASS");
		} else {
			System.out.println(campaignName+" entered is invalid--FAIL");
		}
		
		String actCloseDate = driver.findElement(By.xpath("(//td[@class='dvtCellInfo'])[8]")).getText();
		if (actCloseDate.equals(closeDate)) {
			System.out.println(closeDate+" is correct--PASS");
		} else {
			System.out.println(closeDate+" is incorrect--FAIL");
		}
		
		/*Step 6: Logout of the application*/
		WebElement sign_out=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mousemoveOnElement(driver, sign_out);
		driver.findElement(By.linkText("Sign Out")).click();

		/*Step 7: Close the browser */
		driver.quit();
	}
}