package practice.hometest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PrintAutoSuggestions {

	@Test
	public void printAutoSuggestions() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("selenium");
		 List<WebElement> allTexts = driver.findElements(By.xpath("//span[contains(text(),'selenium')]"));
		 
		for (WebElement text : allTexts) {
			System.out.println(text.getText());
		}
		driver.quit();
	}
}