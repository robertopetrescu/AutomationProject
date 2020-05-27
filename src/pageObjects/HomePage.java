package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how=How.CSS, using ="a[href='/devices']")
	WebElement products;
	
	//click to open products page
	public void clickProducts() {
		clickElement(products);
	}
}
