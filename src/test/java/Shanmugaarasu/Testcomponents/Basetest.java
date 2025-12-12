package Shanmugaarasu.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Shanmugaarasu.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Basetest {
	
     public WebDriver driver;
     public LandingPage landingpage;
	public WebDriver initializedriver() throws IOException{
		
		//Properties prop =  new Properties();
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Shanmugaarasu\\resources\\GlobalData.properties");
    	//prop.load(fis);
    	//String browserName = prop.getProperty("browser");
    	//if (browserName.equalsIgnoreCase("chrome")) {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    	//}
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	     driver.manage().window().maximize();
	     return driver;
	}
	
	
	public String getScreenshot(String testcasename ,WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+"testcasename"+"png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir")+"//reports//"+"testcasename"+".png";
	}
	     @BeforeMethod
	     public LandingPage launchapplication() throws IOException {
	    	 driver = initializedriver();
	    	 landingpage = new LandingPage(driver);
	         landingpage.Goto();
	    	return landingpage;
	     }

	     @AfterMethod
	     public void teardown()
	     {
	    	 driver.close();
	     }
}
