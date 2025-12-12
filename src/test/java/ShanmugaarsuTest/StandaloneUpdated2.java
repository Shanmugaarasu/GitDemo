package ShanmugaarsuTest;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Shanmugaarasu.AbstractComponents.orderPage;
import Shanmugaarasu.Testcomponents.Basetest;
import Shanmugaarasu.pageobjects.CartPage;
import Shanmugaarasu.pageobjects.CheckoutPage;
import Shanmugaarasu.pageobjects.ProductCatalogue;
import Shanmugaarasu.pageobjects.confirmationPage;


public class StandaloneUpdated2 extends Basetest{
	String productname = "ZARA COAT 3";
    @Test
	public void submitOrder() throws IOException {
    	
     ProductCatalogue ProductCatalogue = landingpage.Landingapplication("tamilnadu@gmail.com", "Tamil@1234");
     List<WebElement> products = ProductCatalogue.getProductlist();
     ProductCatalogue.addProductToCart(productname);
     CartPage CartPage =ProductCatalogue.goToCartPage();
     Boolean match = CartPage.verifyProductDisplay(productname);
     Assert.assertTrue(match);
    CheckoutPage checkoutpage = CartPage.getToCheckout();
    checkoutpage.slectcountry("India");
    confirmationPage confirmationPage =checkoutpage.SubmitOrder();
    String confirmationMessage = confirmationPage.getConfirmationMessage();
    Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
 
@Test(dependsOnMethods={"submitOrder"})
public void Orderhistory() 
{
	 ProductCatalogue ProductCatalogue = landingpage.Landingapplication("tamilnadu@gmail.com", "Tamil@1234");
	 orderPage orderPage = ProductCatalogue.goToorderPage();
	 Assert.assertTrue(orderPage.verifyorderDisplay(productname));	
}


}





