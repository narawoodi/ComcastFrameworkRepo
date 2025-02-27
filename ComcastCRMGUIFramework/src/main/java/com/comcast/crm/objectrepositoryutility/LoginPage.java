package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Narahari
 * 
 * Contains Login page elements & business library like login()
 * 
 */

public class LoginPage extends WebDriverUtility{                               //Rule 1: Create a separate Java class
	WebDriver driver;
	public LoginPage(WebDriver driver) {               //Rule 3: Object Initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "user_name")                          //Rule 2: Object Creation
	private WebElement usernameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

		

	public WebElement getUsernameEdt() {               //Rule 4: Object Encapsulation
		return usernameEdt;                            //Rule 5: We can provide Action
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
/**
 * Login to application based on username, password arguments
 * @param username
 * @param password
 */
	
	public void loginToApp(String username, String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}