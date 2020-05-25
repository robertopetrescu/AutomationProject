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
import org.openqa.selenium.support.ui.Select;

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
	
	@FindBy(how=How.CLASS_NAME, using ="action-primary action-accept")
	WebElement acceptRemovalBtn;
	
	@FindBy(how=How.CSS, using="span[data-bind=\"i18n: 'View and Edit Cart'\"]")
	WebElement editCartBtn;
	
	@FindBy(how=How.CLASS_NAME, using="input-text qty")
	WebElement quantityItem;
	
	@FindBy(how=How.ID, using=".cart-price .price")
	List<WebElement> prices;
	
	@FindBy(how=How.ID, using ="attribute92")
	WebElement colorOption;
	Select color;
	
	public void addToCart(boolean closeCart) throws InterruptedException {
		
		//Check if element has color selection dropdown
		/*
		if(_driver.findElements(By.id("attribute92") ).size() != 0) {
			color = new Select(colorOption);
			color.selectByIndex(0);
		}*/
		
		addToCartBtn.click();

		if(closeCart)
			closeMiniCart();
		
	}
	
	public void removeFromCart(WebDriver driver, int product) throws InterruptedException {
		
		removeProducts.get(product).click();
		
		Thread.sleep(2000);
		
		//Accept alert..somehow
		//driver.switchTo().alert().accept();
		
		closeMiniCart();
		
		Thread.sleep(3000);
		
	}

	public void updateQuantity(String items) {
		quantityItem.sendKeys(items);
		
	}

	public void editCart() {
		editCartBtn.click();
		
	}

	
	public void itemIsAddedToCartSidebar() {
		miniCartMessage.isDisplayed();
	}
	
	public void closeMiniCart() {
		closeMiniCart.click();;
	}
}
