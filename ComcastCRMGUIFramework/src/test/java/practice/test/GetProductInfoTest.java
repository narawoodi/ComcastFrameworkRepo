package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		//Search for a product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		//Capture the product details
		String x = "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]";
		String details = driver.findElement(By.xpath(x)).getText();
		System.out.println(details);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowCount("product");
		System.out.println(rowCount);
		
		Object[][] objArr = new Object[rowCount][2];
		
		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = eLib.getDataFromExcel("product", i+1, 0);
			objArr[i][1] = eLib.getDataFromExcel("product", i+1, 1);
		}	
		return objArr;
	}
}