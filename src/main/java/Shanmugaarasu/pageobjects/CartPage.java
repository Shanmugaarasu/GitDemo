package Shanmugaarasu.pageobjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shanmugaarasu.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
    WebDriver driver;
    @FindBy(css = ".cartSection h3")
	 List<WebElement> cartproducts;
    @FindBy(css = ".totalRow button")
	 WebElement checkout;
	public CartPage(WebDriver driver)
	{   super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
		
   public Boolean verifyProductDisplay(String productname) {
	   Boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
	   return match;
   }
   
   public CheckoutPage getToCheckout() {
	   checkout.click();
	  return new CheckoutPage(driver);  
   }
}
