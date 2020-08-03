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
import pageObjects.ConfirmationPage;
import pageObjects.PaymentPage;
import pageObjects.CellularRecharge;

public class RechargeTest extends Base {

	CellularRecharge cr;
	WebDriver driver;
	PaymentPage pp;
	ConfirmationPage cp;

	
	@BeforeMethod//Using before method for creating objects of classes and  loading the url as it is common in every test case
	public void openBrowser() throws IOException
	{
		
		driver = intitializedriver();
	    cr = new CellularRecharge(driver);
	    pp= new PaymentPage(driver);
	    cp = new ConfirmationPage(driver);
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void checkRegisterBtn() throws InterruptedException {
  
		  cr.fill_UserDetails();//Filling the user contact details
		  cr.click_siguinte_Btn();// Submitting the details
		  pp.fill_paymentPageDetails(); // Filling the payment details
		  pp.click_Target_Btn(); // Submitting the payment details
		  pp.fill_authenticationPage(); // Filling the authentication Layer
		  Assert.assertEquals(cp.getText_Success(), "¡Exitosa! - $10"); //Verifying the success message
		}
	
	@AfterMethod//Closing the browser
	public void AfterMethod()
	{
		driver.quit();
	}
	
	
	
}
