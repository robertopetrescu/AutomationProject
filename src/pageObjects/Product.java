package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product {
	
	@FindBy(how=How.ID, using ="product-addtocart-button")
	WebElement addToCartBtn;
	
	@FindBy(how=How.CLASS_NAME, using ="minicart-offscreen-title")
	WebElement miniCart;
	
	@FindBy(how=How.CLASS_NAME, using ="minicart-messages")
	WebElement miniCartMessage;
	
	@FindBy(how=How.ID, using ="btn-minicart-close")
	WebElement closeMiniCart;
	
	@FindBy(how=How.CSS, using ="span[data-bind=\"i18n: 'Remove'\"]")
	List<WebElement> removeProducts;
	
	@FindBy(how=How.XPATH, using ="//footer[@class='modal-footer']/button[2]")
	WebElement acceptRemovalBtn;
	
	@FindBy(how=How.CSS, using="span[data-bind=\"i18n: 'View and Edit Cart'\"]")
	WebElement editCartBtn;
	
	@FindBy(how=How.ID, using ="attribute92")
	WebElement colorOption;
	
	
	WebDriver _driver;
	
	public Product(WebDriver driver) 
	{
		_driver = driver;
	}
	
	public void addToCart(boolean closeCart) throws InterruptedException 
	{
		
		//Check if element has color selection dropdown
		Boolean isPresent = _driver.findElements(By.id("attribute92")).size() > 0;
		if(isPresent) {
			Select color = new Select(_driver.findElement(By.id("attribute92")));
			color.selectByIndex(1);
		}
		
		Thread.sleep(3000);
		addToCartBtn.click();
		
		Thread.sleep(7000);
		
		if(closeCart)
			closeMiniCart();
		Thread.sleep(1500);
		
	}
	
	
	public void removeFromCart(int product) throws InterruptedException 
	{
		
		removeProducts.get(product).click();
		
		Thread.sleep(3000);
		
		acceptRemovalBtn.click();;
		
		Thread.sleep(4000);

		closeMiniCart();
		
		Thread.sleep(3000);
		
	}
	
	public void editCart() 
	{
		editCartBtn.click();	
	}
	
	public void itemIsAddedToCartSidebar() 
	{
		miniCartMessage.isDisplayed();
	}
	
	public void closeMiniCart() {
		closeMiniCart.click();
	}
	
	
}
