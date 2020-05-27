package pageObjects;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cart extends BasePage {
	
	public Cart(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.CSS, using=".input-text.qty")
	WebElement quantityItem;
	
	@FindBy(how=How.CSS, using=".col.price .cart-price")
	WebElement prices;
	
	@FindBy(how=How.CSS, using=".col.subtotal .cart-price")
	WebElement pricesTotal;
	
	@FindBy(how=How.CSS, using="button[name='update_cart_action']")
	WebElement updateCart;
	
	@FindBy(how=How.CSS, using=".action.primary.checkout")
	public WebElement ProceedToCheckout;
	
	public void updateQuantity(int updateQty) throws InterruptedException {
		
		//Clear qunatity field and update it with the new value
		quantityItem.clear();
		quantityItem.sendKeys(String.valueOf(updateQty));
		
		//Click 'Update Cart' to reflect prices
		clickElement(updateCart);
	}
	
	public void checkSubTotal() {
		
		//Get quantity
		waitForElement(quantityItem,10);
		int qty = Integer.parseInt(quantityItem.getAttribute("value"));
		
		//get price per product and subtotal values
		double pricePerProduct = Double.parseDouble(prices.getText().substring(1).replace(",", ""));
		double subTotal = Double.parseDouble(pricesTotal.getText().substring(1).replace(",", ""));
		
		//Check if quantity * price per product equals subtotal
		assertTrue(pricePerProduct * qty == subTotal,"Prices don't match");
	}
	
	
	

}
