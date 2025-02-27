package com.comcast.crm.vendortest;

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
import com.comcast.crm.objectrepositoryutility.CreatingNewVendorPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.VendorInfoPage;

/**
 * 
 * @author Narahari
 * 
 * 
 * 
 */

public class CreateVendorTest extends BaseClass {
	@Test
	public void createVendorTest() throws Throwable {
		/* Read test script data from Excel file */
		String vendorName = eLib.getDataFromExcel("vendor", 1, 2) + jLib.getRandomNumber();

		/* Step 2: Navigate to More Dropdown Module */
		HomePage hp = new HomePage(driver);
		hp.navigateToMoreDropdown();
		hp.navigateToVendorPage();

		/* Step 3: Click on "Create Vendor" Button */
		CreatingNewVendorPage cvp = new CreatingNewVendorPage(driver);
		cvp.getCreateVendorBtn().click();

		/* Step 4: Enter all the details and create new Lead */
		cvp.createVendor(vendorName);

		/* Step 5: Verify whether the entered details is correct or not */
		VendorInfoPage vip = new VendorInfoPage(driver);
		String actVendorName = vip.getVendorNameMsg().getText();
		if (actVendorName.equals(vendorName)) {
			System.out.println(vendorName + " entered is valid--PASS");
		} else {
			System.out.println(vendorName + " entered is invalid--FAIL");
		}
	}
	
	@Test
	public void createVendorWithPhoneNumberTest() throws Throwable {
		/*Read test script data from Excel file*/
		String vendorName = eLib.getDataFromExcel("vendor", 4, 2)+jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("vendor", 4, 3);

		/* Step 2: Navigate to More Dropdown Module */
		HomePage hp = new HomePage(driver);
		hp.navigateToMoreDropdown();
		hp.navigateToVendorPage();

		/* Step 3: Click on "Create Vendor" Button */
		CreatingNewVendorPage cvp = new CreatingNewVendorPage(driver);
		cvp.getCreateVendorBtn().click();
		
		/*Step 4: Enter all the details and create new Lead*/
		cvp.createVendorWithPhoneNumber(vendorName, phoneNumber);
		
		/*Step 5: Verify whether the entered details is correct or not*/
		VendorInfoPage vip = new VendorInfoPage(driver);
		String actVendorName = vip.getVendorNameMsg().getText();
		if (actVendorName.equals(vendorName)) {
			System.out.println(vendorName+" entered is valid--PASS");
		} else {
			System.out.println(vendorName+" entered is invalid--FAIL");
		}
		
		String actPhoneNumber  = vip.getVendorPhoneNumberMsg().getText();
		if (actPhoneNumber.equals(phoneNumber)) {
			System.out.println(phoneNumber+" entered is valid--PASS");
		} else {
			System.out.println(phoneNumber+" entered is invalid--FAIL");
		}
	}
}