package com.testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.baseClass.BaseClass;

public class FlipKartSearch extends BaseClass{

	@BeforeClass
	private void BeforeClass() {
		chromeBrowser(10);
		getURL("https://www.flipkart.com/");
	}
	
	@AfterClass
	private void AfterClass() {
		// TODO Auto-generated method stub

	}
	
	@BeforeMethod
	private void BeforeMethod() {
		Date d=new Date();
		System.out.println("Start Ttime is: "+d);
	}
	
	@AfterMethod
	private void AfterMethod() throws IOException {

		screenShot();
		Date d=new Date();
		System.out.println("End Ttime is: "+d);
	}
	
	@Test
	private void Search() {
		System.out.println("4567");
		driver.findElement(By.xpath("(//input[@title='Search for Products, Brands and More'])[1]")).sendKeys("Samsung Phone");
		
		Actions ac=new Actions(driver);
		ac.sendKeys(Keys.ENTER).perform();
		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='RG5Slk']"));
		
		for(WebElement loop:searchResults) {
			System.out.println(loop.getText());
		}
		
	}
	
	
}
