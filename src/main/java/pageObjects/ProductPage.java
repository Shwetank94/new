package pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Base;

public class ProductPage extends Base {

	public WebDriver driver;
	
	private String help_ToolTip = "//div[@aria-label='Help']/a";
	private String about_Btn = "//div[text()='About Trifacta Wrangler']";
	private String version_Txt = "//div[@class='modal fade in']//p[contains(text(),'7.5.0+53.20200721142709.723803e')]";
	private String close_Icon = "//div[@class='modal fade in']//button[@class='close tricon']";
	private String user_Icon = "//div[@class='m-disk']";
	private String logout_Btn = "//div[@data-id='sign-out']/div";
	
	public ProductPage(WebDriver driver2) {
		this.driver = driver2;
	}
	
	
	public void click_help_ToolTip() throws InterruptedException, IOException {
		  String dashboard = "dashboard";
		  JavascriptExecutor js =(JavascriptExecutor)driver; 
		  WebElement element =driver.findElement(By.xpath(help_ToolTip));
		  Thread.sleep(5000);
		  ScreenshotPath(dashboard);
		  js.executeScript("arguments[0].click();", element); 
		  
	}
	
	public void click_about_Btn() throws IOException, InterruptedException {
		Thread.sleep(2000);
		 driver.findElement(By.xpath(about_Btn)).click();
		 Thread.sleep(2000);
		 String version = "version";
		 ScreenshotPath(version);
	}
	
	public void print_Version() {
		System.out.println("Version is - "+driver.findElement(By.xpath(version_Txt)).getText().trim());
	}
	
	public void click_Close_Icon() {
		driver.findElement(By.xpath(close_Icon)).click();
	}
	
	public void click_User_Icon() throws InterruptedException, IOException {
		WebDriverWait w = new WebDriverWait(driver,30);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath(user_Icon));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(user_Icon)));
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		 String userIcon = "userIcon";
		 ScreenshotPath(userIcon);
	}
	
	public void logout_Btn() throws InterruptedException, IOException {
		Thread.sleep(2000);
		WebDriverWait w = new WebDriverWait(driver,30);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath(logout_Btn));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(logout_Btn)));
		js.executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
		 String logout = "logout";
		 ScreenshotPath(logout);
	}
	
	public void ScreenshotPath(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    String destinationFile = System.getProperty("user.dir")+"\\"+name+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		}

	
	public void check_Version() throws InterruptedException, IOException {
		String login = "login";
		ScreenshotPath(login);
		click_help_ToolTip();
		click_about_Btn();
		print_Version();
		click_Close_Icon();
		click_User_Icon();
		logout_Btn();
		Thread.sleep(2000);
	}

	
}
