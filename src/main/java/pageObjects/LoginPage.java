package pageObjects;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Base;
import Resources.Xls_Reader;


public class LoginPage extends Base {

	public WebDriver driver;
	
	private String email_Txt = "//input[@type='standard']";
	private String password_Txt = "//input[@type='password']";
	private String submit_Btn = "//div[@data-id='primary-button']/div[@class='m-text']";	
		
    Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\LoginDetails.xlsx");
    
    
    
	public LoginPage(WebDriver driver2) {
    this.driver=driver2;
	}

	 //WebDriverWait w = new WebDriverWait(driver,10);
	
    public void fill_Email(String email) {
    	driver.findElement(By.xpath(email_Txt)).sendKeys(email);
    }
	

    public void fill_Password(String password) {
    	driver.findElement(By.xpath(password_Txt)).sendKeys(password);
    }
    
    public void click_Submit_Btn() {
    	driver.findElement(By.xpath(submit_Btn)).click();
    }
    
    public void perform_Login() throws IOException {
    	 WebDriverWait w = new WebDriverWait(driver,30);
 		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(email_Txt)));
    	  fill_Email(excel.getCellData("authentication_page", "Email", 2));
    	  fill_Password(excel.getCellData("authentication_page", "Password", 2));
    	  click_Submit_Btn();
    }
}

