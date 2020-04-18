package com.qa.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestVideoder {


public static AndroidDriver<WebElement> driver;

AppiumDriverLocalService service;
		
		@BeforeClass
		public void setUp() throws InterruptedException, MalformedURLException{		
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();		
	
			DesiredCapabilities serverCapabilities=new DesiredCapabilities();
            serverCapabilities.setCapability("deviceName", "c1cbd64c");            
            serverCapabilities.setCapability("platformName", "Android");
            serverCapabilities.setCapability("VERSION", "8.0");
            serverCapabilities.setCapability("noReset", "True");
            serverCapabilities.setCapability("appPackage", "com.rahul.videoderbeta");
            serverCapabilities.setCapability("appActivity", "com.rahul.videoderbeta.appinit.ActivityInitLoader");
            driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), serverCapabilities);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);          

		}
		
			

	@Test
	public void main_page() throws InterruptedException {
		WebElement urlview = driver.findElement(By.xpath("//android.widget.TextView[@text='Search or Enter URL']"));
		waitforElementVisibility(urlview);
		waitforElementClickable(urlview);
		urlview.click();
		
		WebElement urledit= driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.rahul.videoderbeta:id/uq']"));
		waitforElementVisibility(urledit);
		waitforElementClickable(urledit);
		urledit.sendKeys("https://www.hotstar.com/in/tv/kailasanathan/s-103/list/seasons/t-2_2_103");
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));			
		}
		
		
		
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		service.stop();
		System.out.println("Appium stopped Code");
		
	}
		
		
		public void waitforElementVisibility(WebElement element) {
			WebDriverWait elementVisisblewait = new  WebDriverWait(driver,5000);
			elementVisisblewait.until(ExpectedConditions.visibilityOf(element));
			
		}
		
		public void waitforElementClickable(WebElement element) {
			WebDriverWait elementClicablewait = new  WebDriverWait(driver,5000);
			elementClicablewait.until(ExpectedConditions.elementToBeClickable(element));
			
		}
			

			
	
}
