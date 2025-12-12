package Shanmugaarasu.AbstractComponents;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Shanmugaarasu.pageobjects.CartPage;

public class AbstractComponent {
	 WebDriver driver;
	 
	 public AbstractComponent(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver,this);
	 }
	 @FindBy(css = "[routerlink*='cart']")
	 WebElement cartheader;
	 
	 @FindBy(css = "[routerlink*='myorders']")
	 WebElement orderheader;
	 
	public void waitForElementToAppear(By findby){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitForwebElementToAppear(WebElement findby){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}
    
	public void waitForElementTodisAppear(WebElement ele){
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public CartPage goToCartPage() {
		cartheader.click();
		CartPage CartPage = new CartPage(driver);
		return CartPage;
		
	}
	public orderPage goToorderPage() {
		orderheader.click();
		orderPage orderPage = new orderPage(driver);
		return orderPage;
		
	}
}
