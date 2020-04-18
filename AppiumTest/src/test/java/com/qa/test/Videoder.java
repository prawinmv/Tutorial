package com.qa.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class Videoder {
	//<MobileElement>
	public static AndroidDriver<WebElement> driver;
	public static int n;
	public static String epi;
	public static String status;
	public static String percent;
	
	
	@BeforeClass	
	public void setUp() throws MalformedURLException, InterruptedException{

	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("deviceName", "c1cbd64c");
	capabilities.setCapability("VERSION", "8.0"); 
	capabilities.setCapability("platformName","Android");
	capabilities.setCapability("noReset", "True");
	capabilities.setCapability("appPackage", "com.rahul.videoderbeta");
	capabilities.setCapability("appActivity", "com.rahul.videoderbeta.appinit.ActivityInitLoader");
	URL serveraddress = new URL("http://127.0.0.1:4723/wd/hub");  
	driver = new AndroidDriver<WebElement>(serveraddress, capabilities);
	driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

	}
	
	
	public void main_page() {
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


	public void seasonsMainPage() throws InterruptedException {
		Thread.sleep(30000);		
		scrollDown();
		WebElement seasons = driver.findElement(By.xpath("//android.view.View[contains(@text,'Season 20')]"));
		waitforElementVisibility(seasons);
		waitforElementClickable(seasons);
		seasons.click();
		Thread.sleep(5000);		
	}
	

		
	public void seasonsPage() throws InterruptedException {		
			try {	
				WebElement element = driver.findElement(By.xpath("//android.view.View[@index='0' and contains(@text,'S20 E"+n+"')]"));
				waitforElementVisibility(element);
				waitforElementClickable(element);
				element.click();		        
				System.out.println("Success - Element 'E"+n+"' clicked");

			}catch(Exception e) {
				System.out.println("Failed - Element 'E"+n+"' not displayed");	
				
			}				
			
		
		}	
		
	
				
	

	public void episodePage() throws InterruptedException {
		Thread.sleep(5000);		
		WebElement downloadImg = driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.rahul.videoderbeta:id/a2d']"));
		waitforElementVisibility(downloadImg);
		waitforElementClickable(downloadImg);
		downloadImg.click();
		Thread.sleep(5000);	
		
		try {
		WebElement videolinks = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.rahul.videoderbeta:id/yp' and @text='VIDEO DOWNLOAD LINKS']"));
		waitforElementVisibility(videolinks);
		waitforElementClickable(videolinks);
		
		if(videolinks.isDisplayed()) {
			WebElement pixel = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.rahul.videoderbeta:id/tb' and @text='480P']"));
			waitforElementVisibility(pixel);
			waitforElementClickable(pixel);
			pixel.click();
			Thread.sleep(2000);
			WebElement start = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.rahul.videoderbeta:id/ng' and @text='START DOWNLOAD']"));
			System.out.println("===============***************STARTED********************===============================================================");
			start.click();
			Thread.sleep(2000);
			WebElement downloadImg2 =driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.rahul.videoderbeta:id/gu']"));
			downloadImg2.click();		
		}
		}catch(Exception e) {
			System.out.println("Video links not displayed");
		}
			
		
	}
	

	public void downloadsPage() throws InterruptedException {

		System.out.println("Download started... for Episode ==> 'E"+n+"'");
		List<WebElement> downloadstatus = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.rahul.videoderbeta:id/s9']"));
		List<WebElement> statusids = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.rahul.videoderbeta:id/wt']"));		
		

			do {
						status=statusids.get(0).getText();
						System.out.println(status);
							percent = downloadstatus.get(0).getText();
							System.out.println(percent);
							Thread.sleep(30000);
				}while(status.equals("DOWNLOADING...")||status.equals("CONVERTING..."));

			System.out.println("Download Completed for Episode ==> 'E"+n+"'");
			System.out.println("===============****************COMPLETED*********************=======================================================");
			driver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.rahul.videoderbeta:id/bz']")).click();
			Thread.sleep(5000);	
			
			driver.navigate().back();
			Thread.sleep(20000);
	}
	
	
	
	@Test
	public void videoderProcess()  throws InterruptedException{
		
		main_page();
		
		System.out.println("Main page Completed");
		
		seasonsMainPage();
		System.out.println("seasonsMainPage Completed");
		
		for (n=5;n<28;n++) {
			
			if(n>=7 && n<=12) {
				scrollDown();
				Thread.sleep(2000);
				}else if(n>=13 && n<=18) {
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				}else if(n>=19 && n<=25) {
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				}else if(n>=26 && n<=32) {
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				}else if(n>=33 && n<=39) {
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				}else if(n>=40 && n<=46) {
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				scrollDown();
				Thread.sleep(2000);
				}else if(n>=47) {
					scrollDown();
					Thread.sleep(2000);
					scrollDown();
					Thread.sleep(2000);
					scrollDown();
					Thread.sleep(2000);
					scrollDown();
					Thread.sleep(2000);
					scrollDown();
					Thread.sleep(2000);
					scrollDown();
					Thread.sleep(2000);
					scrollDown();
					Thread.sleep(2000);
					}
			else {
				System.out.println("Scroll not required");
				}		
			
			seasonsPage();
		System.out.println("seasonsPage method Completed");
		episodePage();
		System.out.println("episodePage method Completed");
		downloadsPage();
		System.out.println("downloadsPage method Completed");
		
		}
		
	}
	
	
	public void scrollDown(){
        
    	new TouchAction(driver).press(PointOption.point(540,820)).waitAction().moveTo(PointOption.point(540, 190)).perform();
	}
	
	public void waitforElementVisibility(WebElement element) {
		WebDriverWait elementVisisblewait = new  WebDriverWait(driver,5000);
		elementVisisblewait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitforElementClickable(WebElement element) {
		WebDriverWait elementClicablewait = new  WebDriverWait(driver,5000);
		elementClicablewait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
		
		
		
		
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
