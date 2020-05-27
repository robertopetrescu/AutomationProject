package pageObjects;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout extends BasePage{
	
	public Checkout(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.CSS, using=".action.primary.checkout.amasty")
	public WebElement PlaceOrder;
	
	@FindBy(how=How.CSS, using="div[class='control _with-tooltip'] #customer-email")
	WebElement EmailAddress;
	
	@FindBy(how=How.CSS, using="form[class='form form-shipping-address'] input[name=firstname]")
	WebElement FirstName;
	
	@FindBy(how=How.CSS, using="form[class='form form-shipping-address'] input[name=lastname]")
	WebElement LastName;
	
	@FindBy(how=How.CSS, using="form[class='form form-shipping-address'] input[name='street[0]']")
	WebElement StreetAddress;
	
	@FindBy(how=How.CSS, using="form[class='form form-shipping-address'] input[name=city]")
	WebElement City;
	
	@FindBy(how=How.CSS, using="form[class='form form-shipping-address'] input[name=telephone]")
	WebElement PhoneNumber;
	
	@FindBy(how=How.CSS, using="form[class='form form-shipping-address'] input[name=postcode]")
	WebElement PostalCode;
	
	@FindBy(how=How.CSS, using="#checkout-loader")
	WebElement CheckoutLoader;
	
	//@FindBy(how=How.ID, using="s_method_amstrates_amstrates22")
	@FindBy(how=How.CSS, using="tr[class='row amcheckout-method'] td")
	List<WebElement> ExpressShipping;
	
	@FindBy(how=How.CSS, using="span[data-th=\"Cart Subtotal\"]")
	WebElement TotalAmountWithoutShipping;
	
	@FindBy(how=How.CSS, using="strong span[class=price]")
	WebElement TotalAmountWithShipping;
	
	@FindBy(how=How.CSS, using="div[data-ui-id=checkout-cart-validationmessages-message-error]")
	public WebElement ErrorMessage;
	
	public void checkErrorMessage() throws InterruptedException {
			assertTrue(EmailAddress.getAttribute("aria-describedby").contains("error"));
			assertTrue(FirstName.getAttribute("aria-describedby").contains("error"));
			assertTrue(LastName.getAttribute("aria-describedby").contains("error"));
			assertTrue(StreetAddress.getAttribute("aria-describedby").contains("error"));
			assertTrue(City.getAttribute("aria-describedby").contains("error"));
			_driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void placeOrder() {
		
	}
	
	public boolean CheckExpressShipping() throws InterruptedException {
		
		waitForElementToDissapear(_driver.findElement(By.cssSelector("#checkout-loader")),15);
		waitForElementToBeClickable(TotalAmountWithShipping,15);
		//waitForElement(TotalAmount,10);
		//Save Total cost with economy shipping and radio button value with Shipping
		double totalPriceWithoutShipping = Double.parseDouble(TotalAmountWithoutShipping.getText().substring(1).replace(",", ""));
		double expressShipping = Double.parseDouble(ExpressShipping.get(1).findElement(By.cssSelector("span span[class=price]")).getText().substring(1).replace(",", ""));
		
		//Click on Express Shipping radio button
		clickElement(ExpressShipping.get(0));
		
		//Get new Total order value after Express Shipping was selected
		waitForElement(TotalAmountWithShipping,10);
		double totalWithExpressShipping = Double.parseDouble(TotalAmountWithShipping.getText().substring(1).replace(",", ""));
		
		//Return true if the Order value + express shipping radio button value
		//equals the new Total amout else return false
		if(totalPriceWithoutShipping + expressShipping == totalWithExpressShipping) {
			return true;
		}else {
			return false;
		}
	}
	
	public void populateFields(String email, String firstName, String lastName, String address, long phone, String creditCard) throws InterruptedException {
		
		//Split values into separate strings
		String address_split[] = address.split(",");
		String credit_card[] = creditCard.split(",");
		
		//Populate fields
		waitForElement(EmailAddress,10);
		EmailAddress.sendKeys(email);
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastName);
		StreetAddress.sendKeys(address_split[0]);
		City.sendKeys(address_split[1]);
		PostalCode.clear();
		PostalCode.sendKeys(address_split[2]);
		PhoneNumber.sendKeys(String.valueOf(phone));
		
		//Switch to Credit Card iFrame
		_driver.switchTo().frame(_driver.findElement(By.name("__privateStripeFrame5")));
		
		//Populate credit card values
		_driver.findElement(By.name("cardnumber")).sendKeys(credit_card[0]);
		_driver.findElement(By.name("exp-date")).sendKeys(credit_card[1]);
		_driver.findElement(By.name("cvc")).sendKeys(credit_card[2]);
		
		//Switch back to default content
		_driver.switchTo().defaultContent();
		
		//Click on Place Order
		clickElement(PlaceOrder);
		waitForElement(ErrorMessage,10);
	}
	
}
