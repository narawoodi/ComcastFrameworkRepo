package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Narahari
 */

public class CreatingNewVendorPage {
	WebDriver driver;
	public CreatingNewVendorPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Create Vendor...']")
	private WebElement createVendorBtn;
	
	@FindBy(name = "vendorname")
	private WebElement vendorNameEdit;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getCreateVendorBtn() {
		return createVendorBtn;
	}

	public WebElement getVendorNameEdit() {
		return vendorNameEdit;
	}
	
	public WebElement getPhoneNumberEdit() {
		return phoneNumberEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/**
	 * 
	 * @param vendorName
	 * 
	 */
	
	public void createVendor(String vendorName) {
		vendorNameEdit.sendKeys(vendorName);
		saveBtn.click();
	}
	
	public void createVendorWithPhoneNumber(String vendorName, String phoneNumber) {
		vendorNameEdit.sendKeys(vendorName);
		phoneNumberEdit.sendKeys(phoneNumber);
		saveBtn.click();
	}
	
}