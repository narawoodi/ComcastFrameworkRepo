package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Narahari
 */

public class OrganizationInfoPage {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement industryMsg;
	
	@FindBy(id = "dtlview_Type")
	private WebElement industryType;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement PhoneNumber;
	
	public WebElement getPhoneNumber() {
		return PhoneNumber;
	}

	public WebElement getIndustryMsg() {
		return industryMsg;
	}

	public WebElement getIndustryType() {
		return industryType;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}	
}