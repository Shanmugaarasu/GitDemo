package ShanmugaarsuTest;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Shanmugaarasu.Testcomponents.Basetest;
import Shanmugaarasu.Testcomponents.retry;


public class Errorvalidation extends Basetest{
    @Test(retryAnalyzer = retry.class)
	public void submitOrder() throws IOException {
    	
	 String productname = "ZARA COAT 3";
     landingpage.Landingapplication("tamilnadu@gmail.com", "Tamil@@1234");
     Assert.assertEquals("Incorrect email or password.",landingpage.geterrormessage());
  }
}

