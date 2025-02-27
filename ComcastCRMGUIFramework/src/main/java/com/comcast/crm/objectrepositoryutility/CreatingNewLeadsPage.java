package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Narahari
 */

public class CreatingNewLeadsPage {
	WebDriver driver;
	public CreatingNewLeadsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createLeadBtn;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdit;
	
	@FindBy(name = "company")
	private WebElement companyNameEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getCompanyNameEdit() {
		return companyNameEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	/**
	 * 
	 * @param lastname
	 * @param companyname
	 * 
	 */

	public void createLead(String lastname, String companyname) {
		lastNameEdit.sendKeys(lastname);
		companyNameEdit.sendKeys(companyname);
		saveBtn.click();
	}

}
