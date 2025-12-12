package Shanmugaarasu.AbstractComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orderPage extends AbstractComponent {
    WebDriver driver;
	public orderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
     
	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> ordernames;
	
	public Boolean verifyorderDisplay(String productname) {
		   Boolean match = ordernames.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
		   return match;
	   }
	
}
