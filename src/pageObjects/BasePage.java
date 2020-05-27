package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public void clickElement(WebElement element) {
		waitForElement(element,10);
		element.click();
	}
}
