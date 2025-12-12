package Shanmugaarasu.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shanmugaarasu.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
    WebDriver driver;
	public LandingPage(WebDriver driver)
	{   super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(id = "userEmail")
    WebElement userEmail;
	
	@FindBy(id = "userPassword")
    WebElement userPassword;
	
	@FindBy(id = "login")
    WebElement login;
	
	@FindBy(css="[class*='toast-message']")
    WebElement errormessage;
	
	public ProductCatalogue Landingapplication(String email,String password){
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		login.click();
		ProductCatalogue productcatalogue = new ProductCatalogue(driver);
		return productcatalogue;
	}
	
	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
	
	public String geterrormessage() {
		waitForwebElementToAppear(errormessage);
		return errormessage.getText();
	}
}
