package mainTestClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.ProductPage;
import pageObjects.LoginPage;

public class ProductVersionTest extends Base {

	LoginPage lp;
	WebDriver driver;
	ProductPage pp;
	

	
	@BeforeMethod//Using before method for creating objects of classes and  loading the url as it is common in every test case
	public void openBrowser() throws IOException
	{
		
		driver = intitializedriver();
	    lp = new LoginPage(driver);
	    pp= new ProductPage(driver);
	   
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void check_Version() throws InterruptedException, IOException {
  
		  lp.perform_Login();
		  pp.check_Version();//prints the product version on console
		}
	
	
	
	@AfterMethod//Closing the browser
	public void AfterMethod()
	{
		driver.quit();
	}
	
	
	
}
