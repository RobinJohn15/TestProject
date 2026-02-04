package com.baseClass;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver	driver;
	
	public static WebDriver chromeBrowser(int seconds) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		return driver;
	}
	
	public static void implicitlyWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public static void getURL(String url) {
		driver.get(url);
	}
	
	public static void sendKeys(WebElement e, String value) {
		e.clear();
		e.sendKeys(value);
	}
	
	public static void click(WebElement e) {
		e.click();
	}
	
	public static String getCurentURL() {
		//String currentURL = driver.getCurrentUrl();
		//return currentURL;
		return driver.getCurrentUrl();
	}
	
	public static String getTitle() {
		//driver.getTitle();
		return driver.getTitle();	
	}
	
	public static String getText(WebElement e) {
		//e.getText();
		return e.getText();
	}
	
	public static String getAttribute(WebElement e,String value) {
		//e.getAttribute(value);
		return e.getAttribute(value);
	}
	
	public String getAttribute(WebElement ele) {
		String attributeValue = ele.getAttribute("value");
		return attributeValue;
	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static void selectByVisibleText(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByVisibleText(value);
	}
	
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);;
	}
	
	public static void selectByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.selectByValue(value);
	}
	
	public static void refresh() {
		driver.navigate().refresh();
	}
	
	public static void back() {
		driver.navigate().back();
	}
	
	public static void close() {
		driver.close();
	}
	
	public static void sleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}
	
	public static void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public static  void clickEnter() throws AWTException {
		Actions ac=new Actions(driver);
		ac.sendKeys(Keys.ENTER).perform();
	}
	
	public static void scrollToElement(WebElement e) {
		Actions ac=new Actions(driver);
		ac.moveToElement(e).perform();;
	}
	
	public static void scrollToElement1(By locator) {
		WebElement e= driver.findElement(locator);
		new Actions(driver).moveToElement(e).perform();;
	}
	
	
	public static void windowHandel(int index) {
		Set<String> allID = driver.getWindowHandles();
		List<String> l=new ArrayList<>();
		l.addAll(allID);
		driver.switchTo().window(l.get(index));
	}
	
	public static List<String> loopText(List<WebElement> e) {
		List<String> value=new ArrayList<>();
				for(WebElement loop:e) {
			String text = loop.getText();	
			value.add(text);
		}
		return value;
	}
	
	public static List<String> loopAttribute(List<WebElement> e,String val) {
		List<String> value=new ArrayList<>();
				for(WebElement loop:e) {
			String text = loop.getAttribute(val);	
			value.add(text);
		}
		return value;
	}
	
	public static void screenShotWithUtils(String title) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File source= tk.getScreenshotAs(OutputType.FILE);
		File target=new File("D:\\Selenium\\JUnit\\target\\"+title);
		FileUtils.copyFileToDirectory(source,target);
	}
	
	public static void screenShot(String title) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File source= tk.getScreenshotAs(OutputType.FILE);
		File target=new File("D:\\Selenium\\JUnit\\target\\"+title+".png");
		Files.copy(source.toPath(),target.toPath(),StandardCopyOption.REPLACE_EXISTING);
	}


	
}
