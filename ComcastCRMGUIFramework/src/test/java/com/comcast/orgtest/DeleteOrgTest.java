package com.comcast.orgtest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {
	public static void main(String[] args) throws Throwable {
		/*Create Object*/
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		//Read common data from JSON file
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
				
		//Read test script data from Excel file
		String orgName = eLib.getDataFromExcel("org", 10, 2) + jLib.getRandomNumber();
			
		WebDriver driver=null; //Declaration
		if (BROWSER.equals("chrome")) {
			driver=new ChromeDriver(); //Initialization
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		//Step 1: Login to application		
		LoginPage lp = new LoginPage(driver);		
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 2: Navigate to Organizations Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		//Step 3: Click on "Create Organization" Button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		
		//Step 4: Enter all the details and create new OrganizationInfoPage
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		
		//Step 5: Verify Header Message Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if(actOrgName.contains(orgName)) {
			System.out.println(orgName+" name is verified--PASS");
		}else {
			System.out.println(orgName+" name is not verified--FAIL");
		}
		
		//Step 6: Go back to Organizations page
		hp.getOrgLink().click();
		
		//Step 7: Search for Organization
		cnp.getSearchEdt().sendKeys(orgName);
		wLib.selectByText(cnp.getSearchDD(), "Organization Name");
		cnp.getSearchBtn().click();
		
		//Step 8: In dynamic web table select & delete org		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		wLib.switchToAlertAndAccept(driver);
		
		//Step 9: Logout of the application
		hp.logout();
		driver.quit();
	}
}