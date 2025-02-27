package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		 Set<String> set = driver.getWindowHandles();
		 Iterator<String> it = set.iterator();
		 
		 while(it.hasNext()) {
			 String windowID = it.next();
			 driver.switchTo().window(windowID);
			 
			 String actURL = driver.getCurrentUrl();
			 if (actURL.contains(partialURL)) {
				break;
			}
		 }
	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		 Set<String> set = driver.getWindowHandles();
		 Iterator<String> it = set.iterator();
		 
		 while(it.hasNext()) {
			 String windowID = it.next();
			 driver.switchTo().window(windowID);
			 
			 String actURL = driver.getTitle();
			 if (actURL.contains(partialTitle)) {
				break;
			}
		 }
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void selectByText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void mousemoveOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void doubleclick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void contextClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void scrollByAmount(WebDriver driver, int deltaX, int deltaY) {
		Actions act = new Actions(driver);
		act.scrollByAmount(deltaX, deltaY).perform();
	}
	
	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}
	
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	
	public void takesScreenShotOfFile(String path, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File file_src = ts.getScreenshotAs(OutputType.FILE);
		File file_dest = new File(path);
		FileHandler.copy(file_src, file_dest);
	}
	
	public void takesScreenShotOfElement(String path, WebDriver driver, WebElement element) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File element_src = element.getScreenshotAs(OutputType.FILE);
		File element_dest = new File(path);
		FileHandler.copy(element_src, element_dest);
	}

}