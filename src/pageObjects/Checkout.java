package pageObjects;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout {
	
	 WebDriver _driver;
		
	public Checkout(WebDriver driver) {
		_driver = driver;
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
	
	@FindBy(how=How.CSS, using="strong [class=price]")
	WebElement TotalAmount;
	
	@FindBy(how=How.CSS, using="div[data-ui-id=checkout-cart-validationmessages-message-error]")
	public WebElement ErrorMessage;
	
	public void checkErrorMessage() throws InterruptedException {
			assertTrue(EmailAddress.getAttribute("aria-describedby").contains("error"));
			assertTrue(FirstName.getAttribute("aria-describedby").contains("error"));
			assertTrue(LastName.getAttribute("aria-describedby").contains("error"));
			assertTrue(StreetAddress.getAttribute("aria-describedby").contains("error"));
			assertTrue(City.getAttribute("aria-describedby").contains("error"));
			Thread.sleep(3000);
	}
	public void ss() {
		//var wait = new WebDriverWait(_driver, 20);
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#checkout-loader")));
		//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action.primary.checkout.amasty")));
	}
	
	public boolean CheckExpressShipping() throws InterruptedException {
		double totalWithEconomyShipping = Double.parseDouble(TotalAmount.getText().substring(1).replace(",", ""));
		double expressShipping = Double.parseDouble(ExpressShipping.get(1).findElement(By.cssSelector("span span[class=price]")).getText().substring(1).replace(",", ""));
		
		ExpressShipping.get(0).click();
		
		Thread.sleep(3000);
		double totalWithExpressShipping = Double.parseDouble(TotalAmount.getText().substring(1).replace(",", ""));
		
		if(totalWithEconomyShipping + expressShipping == totalWithExpressShipping) {
			return true;
		}else
			return false;
	}
	
	public void populateFields(String email, String firstName, String lastName, String address, long phone, String creditCard) throws InterruptedException {
		EmailAddress.sendKeys(email);
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastName);
		String address_split[] = address.split(",");
		String credit_card[] = creditCard.split(",");
		StreetAddress.sendKeys(address_split[0]);
		City.sendKeys(address_split[1]);
		PostalCode.clear();
		PostalCode.sendKeys(address_split[2]);
		PhoneNumber.sendKeys(String.valueOf(phone));
		_driver.switchTo().frame(_driver.findElement(By.name("__privateStripeFrame5")));
		_driver.findElement(By.name("cardnumber")).sendKeys(credit_card[0]);
		_driver.findElement(By.name("exp-date")).sendKeys(credit_card[1]);
		_driver.findElement(By.name("cvc")).sendKeys(credit_card[2]);
		_driver.switchTo().defaultContent();
		Thread.sleep(4000);
		PlaceOrder.click();
		Thread.sleep(2000);
	}
	
}
