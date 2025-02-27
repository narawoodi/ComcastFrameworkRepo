package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * @author Narahari
 */

public class CreatingNewContactPage {
	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "phone")
	private WebElement phoneNumberEdit;

	@FindBy(name = "lastname")
	private WebElement lastNameEdit;

	@FindBy(id = "jscal_field_support_start_date")
	private WebElement startDateEdit;

	@FindBy(id = "jscal_field_support_end_date")
	private WebElement endDateEdit;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement addOrgBtn;

	@FindBy(name = "search_text")
	private WebElement searchField;

	@FindBy(name = "search")
	private WebElement contactSearchBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPhoneNumberEdit() {
		return phoneNumberEdit;
	}

	public WebElement getStartDate() {
		return startDateEdit;
	}

	public WebElement getEndDate() {
		return endDateEdit;
	}

	public WebElement getAddOrgBtn() {
		return addOrgBtn;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getContactSearchBtn() {
		return contactSearchBtn;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getPhoneNumber() {
		return phoneNumberEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	/**
	 * 
	 * @param lastname
	 */
	public void createLastName(String lastname) {
		lastNameEdit.sendKeys(lastname);
		saveBtn.click();
	}

	/**
	 * 
	 * @param lastname
	 * @param startDate
	 * @param endDate
	 */
	public void createContactWithSupportDate(String lastname, String startDate, String endDate) {
		lastNameEdit.sendKeys(lastname);
		startDateEdit.sendKeys(startDate);
		endDateEdit.clear();
		endDateEdit.sendKeys(endDate);
		saveBtn.click();
	}
	
	/**
	 * 
	 * @param phoneNumber
	 */

	public void enterPhoneNumber(String phoneNumber) {
		phoneNumberEdit.sendKeys(phoneNumber);
		saveBtn.click();
	}

	/**
	 * 
	 * @param contactLastName
	 * @param orgName
	 */
	public void createContactWithOrgName(String contactLastName, String orgName) {
		lastNameEdit.sendKeys(contactLastName);
		addOrgBtn.click();
		WebDriverUtility wbutil = new WebDriverUtility();
		wbutil.switchToTabOnURL(driver, "module=Accounts");
		searchField.sendKeys(orgName);

		contactSearchBtn.click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		wbutil.switchToTabOnURL(driver, "Contacts&action");
		saveBtn.click();

	}

}
