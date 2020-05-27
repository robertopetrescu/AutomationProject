package pageObjects;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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

public class Product extends BasePage{
	
	public Product(WebDriver driver) 
	{
		super(driver);
	}
	
	
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
	
	public void addToCart() throws InterruptedException 
	{
		
		//Check if element has color selection dropdown and select it if so
		Boolean isPresent = _driver.findElements(By.id("attribute92")).size() > 0;
		if(isPresent) {
			Select color = new Select(_driver.findElement(By.id("attribute92")));
			color.selectByIndex(1);
		}
		
		//Add to cart
		clickElement(addToCartBtn);
	}
	
	public boolean checkIfElementIsPresent() {
		try {
			colorOption.isDisplayed();
			System.out.println("present");
			return true;
		}catch(NoSuchElementException e) {
			System.out.println("not present");
			return false;
		}
	}
	
	public void removeFromCart(int product) throws InterruptedException 
	{
		
		clickElement(removeProducts.get(product));
		
		clickElement(acceptRemovalBtn);
		
		closeMiniCart();
		
	}
	
	public void editCart() 
	{
		clickElement(editCartBtn);
	}
	
	public void itemIsAddedToCartSidebar() 
	{
		waitForElement(miniCartMessage, 10);
		miniCartMessage.isDisplayed();
	}
	
	public void closeMiniCart() {
		clickElement(closeMiniCart);
	}
	
	
}
