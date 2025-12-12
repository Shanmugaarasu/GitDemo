package Shanmugaarasu.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shanmugaarasu.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
    WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{   super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(className = "mb-3")
    List<WebElement> products;
	@FindBy(css = "#ng-animating")
    WebElement spinner;
	By product = By.className("mb-3");
	By addTocart= By.xpath("//button[contains(@class,'rounded')][2]");
	By tostmessage = By.id("toast-container");
	public List<WebElement> getProductlist() 
	{   waitForElementToAppear(product);
		return products;
	}
	
	public WebElement getProductByname(String productname) 
	{   
		 WebElement prod =  getProductlist().stream().filter(product->
	     product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
		 return prod;
	}
	
	public void addProductToCart(String productname) 
	{   WebElement prod = getProductByname(productname);
		prod.findElement(addTocart).click(); 
		waitForElementToAppear(tostmessage);
		waitForElementTodisAppear(spinner);
	
	}
}
