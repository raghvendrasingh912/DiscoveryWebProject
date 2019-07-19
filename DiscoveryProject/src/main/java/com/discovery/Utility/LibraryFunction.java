package com.discovery.Utility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterSuite;

public class LibraryFunction {
	public WebDriver driver;
	JavascriptExecutor javaScriptExecutor;
	String URL=PropertyReader.getLocatorValue("BROWSER_URL", "config");
	public void setUPBrowserAndURL() {
		driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public FluentWait<WebDriver> fluentWait(){
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.withTimeout(60, TimeUnit.SECONDS)
		.pollingEvery(3, TimeUnit.SECONDS)
		.ignoring(Exception.class);
		return wait;
	}
	
	public void waitByTime(int time) {
		try {
			Thread.sleep(time);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void scrollToElementView(By locator) {
		WebElement element=driver.findElement(locator);
		javaScriptExecutor=(JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void moveToElement(By locator) {
		 Actions actions=new Actions(driver);
		 WebElement ele=fluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		 Action action=actions.moveToElement(ele).build();
		 action.perform();
	}
	
	 public void buttonClick(By locator) {
		 try {
			 WebElement element=fluentWait().until(ExpectedConditions.elementToBeClickable(locator));
			 element.click();	 
		 }catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
	public String getWebElementText(By locator) {	      
	     WebElement webElement=fluentWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	     Constant.listShows.add(webElement.getText());
	     return webElement.getText();
	    }
	
	public void scrollDownPage() {
		javaScriptExecutor=(JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("window.scrollBy(0,250)","");
	}
	
	@AfterSuite
	public void closeResourses() {
		driver.close();
	}
}
