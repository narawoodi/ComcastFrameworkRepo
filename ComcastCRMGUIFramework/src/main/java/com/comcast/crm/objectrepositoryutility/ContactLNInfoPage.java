package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Narahari
 */

public class ContactLNInfoPage {
	WebDriver driver;
	public ContactLNInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Last Name")
	private WebElement viewlnMsg;
	
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getViewlnMsg() {
		return viewlnMsg;
	}
}