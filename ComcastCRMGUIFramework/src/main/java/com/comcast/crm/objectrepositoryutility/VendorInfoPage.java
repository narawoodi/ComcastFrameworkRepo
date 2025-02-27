package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Narahari
 */


public class VendorInfoPage {
	WebDriver driver;
	public VendorInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "dtlview_Vendor Name")
	private WebElement vendorNameMsg;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement vendorPhoneNumberMsg;
	
	public WebElement getVendorNameMsg() {
		return vendorNameMsg;
	}
	
	public WebElement getVendorPhoneNumberMsg() {
		return vendorPhoneNumberMsg;
	}
}