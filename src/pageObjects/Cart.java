package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cart {

    WebDriver _driver;
	
	public Cart(WebDriver driver) {
		_driver = driver;
	}
	
	@FindBy(how=How.CLASS_NAME, using="input-text qty")
	WebElement quantityItem;
	
	@FindBy(how=How.ID, using=".cart-price .price")
	List<WebElement> prices;
	
	public void updateQuantity(String items) throws InterruptedException {
		
		_driver.findElement(By.className("input-text qty")).sendKeys("value", "3");
		//quantityItem.sendKeys(items);
		Thread.sleep(3000);
		
	}

}
