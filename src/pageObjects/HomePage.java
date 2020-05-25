package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	@FindBy(how=How.CSS, using ="a[href='/devices']")
	WebElement products;
	
	public void clickProducts() {
		products.click();
		
	}
}
