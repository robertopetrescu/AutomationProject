package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver _driver;
	
	public BasePage(WebDriver driver) {
		_driver = driver;
	}
	
	public void waitForElement(WebElement element,int timeout) 
	{
	    WebDriverWait wait = new WebDriverWait(_driver,timeout);
	    wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToDissapear(WebElement element,int timeout) 
	{
	    WebDriverWait wait = new WebDriverWait(_driver,timeout);
	    wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForElementToBeClickable(WebElement element,int timeout) 
	{
	    WebDriverWait wait = new WebDriverWait(_driver,timeout);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	 public void waitForPageLoaded() {
	        ExpectedCondition<Boolean> expectation = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	                    }
	                };
	        try {
	            Thread.sleep(1000);
	            WebDriverWait wait = new WebDriverWait(_driver, 30);
	            wait.until(expectation);
	        } catch (Throwable error) {
	            Assert.fail("Timeout waiting for Page Load Request to complete.");
	        }
	    }
	
	public void clickElement(WebElement element) {
		waitForElement(element,10);
		element.click();
	}
}
