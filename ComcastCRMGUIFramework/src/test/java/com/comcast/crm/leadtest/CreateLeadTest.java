package com.comcast.crm.leadtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
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


public class CreateLeadTest extends BaseClass{
	
	@Test
	public void createLeadTest() throws Throwable {
		
		/*Read test script data from Excel file*/
		String leadName = eLib.getDataFromExcel("lead", 1, 2)+jLib.getRandomNumber();
		String companyName = eLib.getDataFromExcel("lead", 1, 3);		
		
		/*Step 2: Navigate to Leads Module*/
		HomePage hp = new HomePage(driver);
		hp.getCreateLeadBtn();
		 
		/*Step 3: Click on "Create Lead" Button*/
		
		
		/*Step 4: Enter all the details and create new Lead*/
		
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
	}
}