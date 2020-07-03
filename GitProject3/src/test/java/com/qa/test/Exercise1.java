package com.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Exercise1 {
public static WebDriver driver;
public static String appURL = "https://www.google.com";
Actions actions;

@BeforeClass
public void setUp() {
	System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(appURL);
	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);		
}

@Test(priority=1)
public void searchValidataion() throws InterruptedException {
	actions = new Actions(driver);
	WebElement searchBox = driver.findElement(By.name("q"));
	
	searchBox.click();
	searchBox.sendKeys("testing");
	searchBox.click();
	Thread.sleep(3000);
	List<WebElement> searchlist = driver.findElements(By.xpath("//ul[@role='listbox']"));

	for(WebElement text : searchlist) {
		String value = text.getText();		
		if(value.contains("tools")) {			
			driver.findElement(By.xpath("//*[contains(text(),'tools')]")).click();
			Thread.sleep(2000);			
		}
	}	
}

@Test(priority=2)
public void pageValidation() throws InterruptedException {	
	
	String pageTitle = driver.getTitle();
	System.out.println("Page Title is : "+ pageTitle);
	AssertJUnit.assertEquals("testing tools - Google Search",pageTitle);
}

@AfterClass
public void tearDown() {
	driver.quit();
}

}
