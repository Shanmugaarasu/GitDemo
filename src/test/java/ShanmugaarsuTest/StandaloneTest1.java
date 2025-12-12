package ShanmugaarsuTest;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Shanmugaarasu.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest1 {

	public static void main(String[] args) throws InterruptedException {
		String productname = "ZARA COAT 3";
     WebDriverManager.chromedriver().setup();
     WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://rahulshettyacademy.com/client/#/auth/login");
     driver.findElement(By.id("userEmail")).sendKeys("tamilnadu@gmail.com");
     driver.findElement(By.id("userPassword")).sendKeys("Tamil@1234");
     driver.findElement(By.id("login")).click();
     LandingPage landingpage = new LandingPage(driver);
     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
     List<WebElement> products = driver.findElements(By.className("mb-3"));
     WebElement prod =  products.stream().filter(product->
     product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
     prod.findElement(By.xpath("//button[contains(@class,'rounded')][2]")).click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
     wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ng-animating")));
     driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
     List<WebElement> cartproducts = driver.findElements(By.cssSelector(".cartSection h3"));
    Boolean match = cartproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(productname));
    Assert.assertTrue(match);
    driver.findElement(By.cssSelector(".totalRow button")).click();
    Actions a = new Actions(driver);
    a.sendKeys(driver.findElement(By.cssSelector("input[class*='validated']:nth-child(1)")),"india").build().perform();
    driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[2]")).click();
    a.sendKeys(Keys.PAGE_DOWN).build().perform();
    driver.findElement(By.cssSelector(".btnn")).click();
    String Confirmationimage = driver.findElement(By.cssSelector("h1.hero-primary")).getText();
    System.out.println(Confirmationimage);
    Assert.assertTrue(Confirmationimage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    driver.close();
	}}


