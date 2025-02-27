package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Narahari
 */

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {               //Rule 3: Object Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Leads")
	private WebElement createLeadBtn;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(name = "Vendors")
	private WebElement vendorLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	public WebElement getCampaignLink() {
		return campaignLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public WebElement getVendorLink() {
		return vendorLink;
	}
	
	public void navigateToMoreDropdown() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		moreLink.click();
	}

	public void navigateToCampaignPage() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	
	public void navigateToVendorPage() {
		Actions act = new Actions(driver);
		act.moveToElement(vendorLink).perform();
		vendorLink.click();
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLink.click();
	}
}