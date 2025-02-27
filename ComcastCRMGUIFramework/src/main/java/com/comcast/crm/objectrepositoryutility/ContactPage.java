package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Narahari
 */

public class ContactPage {

		WebDriver driver;
		public ContactPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addNewContact;
	public WebElement getAddNewContact() {
		return addNewContact;
	}
		

	public void clickOnCreateContactButton() {
		getAddNewContact().click();
	}
}

