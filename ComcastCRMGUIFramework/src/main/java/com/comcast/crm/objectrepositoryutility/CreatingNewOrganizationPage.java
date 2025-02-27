package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Narahari
 */

public class CreatingNewOrganizationPage {
	
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDB;
	
	@FindBy(name = "accounttype")
	private WebElement accountType;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberEdit;

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getPhoneNumberEdit() {
		return phoneNumberEdit;
	}

	public void createOrg(String orgName) {
		orgNameEdit.sendKeys(orgName);
		saveBtn.click();
	}
	
	/**
	 * 
	 * @param orgName
	 * @param industry
	 */
	
	public void createOrgWithIndustry(String orgName, String industry) {
		orgNameEdit.sendKeys(orgName);
		Select sel = new Select(industryDB);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}
	
	/**
	 * 
	 * @param orgName
	 * @param industry
	 * @param type
	 */
	
	public void createOrgWithIndustryAndType(String orgName, String industry, String type) {
		orgNameEdit.sendKeys(orgName);
		Select sel = new Select(industryDB);
		sel.selectByVisibleText(industry);
		Select sel1 = new Select(accountType);
		sel1.selectByVisibleText(type);
		saveBtn.click();
	}
	
	/**
	 * 
	 * @param orgName
	 * @param phonenumber
	 */
	
	public void createOrgWithPhoneNumber(String orgName, String phonenumber) {
		orgNameEdit.sendKeys(orgName);
		phoneNumberEdit.sendKeys(phonenumber);
		saveBtn.click();
	}
	
}
