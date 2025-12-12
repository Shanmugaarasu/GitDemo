package Shanmugaarasu.pageobjects;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shanmugaarasu.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css = ".btnn")
	WebElement submit;
	@FindBy(css = "input[class*='validated']:nth-child(1)")
	WebElement Country;
	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
	WebElement Selectcountry;
	
	public void slectcountry(String Countryname) {
		Actions a = new Actions(driver);
		a.sendKeys(Country,Countryname).build().perform();
		Selectcountry.click();
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	public confirmationPage SubmitOrder() {
		submit.click();
		return new confirmationPage(driver);
	}
}
