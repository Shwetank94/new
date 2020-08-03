package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Xls_Reader;

public class PaymentPage {
	public WebDriver driver;
	
	private	String cardName_Txt = "//div[@class='field form-group']/input[@name='cardname']";
	private	String cardNumber_Txt = "cardnumberunique";
	private	String month_Txt ="//div[@class='field col-xs-5 col-md-5 paddleft0']/input[@data-conekta='card[exp_month]']";
	private String expyear_Txt = "//div[@class='field col-xs-7 col-md-7 paddleft0']/input[@name='expyear']";
	private String cvv_Txt = "//div[@class='field form-group']/input[@name='cvvno']";
	private String electronico_Email_Txt= "//input[@class='form-control email']";
	private String target_Btn = "(//div[@id='tarjetaNuevaUpdate']/following-sibling::div[1])/div";
	private String email_Layer = "//input[@id='usrname']";
	private String password_Layer= "//input[@id='psw']";
	private String captcha = "//span[@id='recaptcha-anchor']";
	private String submit_Btn="//button[@id='loginBtn']";
    Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\RechargeData.xlsx");
    
	public PaymentPage(WebDriver driver2) {
		this.driver = driver2;
	}

	
	public void fill_cardName_Txt(String name) {
		driver.findElement(By.xpath(cardName_Txt)).sendKeys(name);
	}
	
	public void fill_CardNamber_Txt(String num) {
		driver.findElement(By.id(cardNumber_Txt)).sendKeys(num);
	}
	
	public void fill_month_Txt(String month) {
		driver.findElement(By.xpath(month_Txt)).sendKeys(month);
	}
	
	public void fill_expyear_Txt(String year) {
		driver.findElement(By.xpath(expyear_Txt)).sendKeys(year);
	}
	
	public void fill_cvv_Txt(String cvv) {
		driver.findElement(By.xpath(cvv_Txt)).sendKeys(cvv);
	}
	
	public void fill_email(String email) {
		driver.findElement(By.xpath(electronico_Email_Txt)).sendKeys(email);
	}

	public void click_Target_Btn() {
		driver.findElement(By.xpath(target_Btn)).click();
	}
	
	public void fill_email_Layer(String email_layer) {
		driver.findElement(By.xpath(email_Layer)).sendKeys(email_layer);
	}
	
	public void fill_password_Layer(String pass) {
		driver.findElement(By.xpath(password_Layer)).sendKeys(pass);
	}
	
	public void click_Captcha() throws InterruptedException {
		WebDriverWait w = new WebDriverWait(driver,30);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submit_Btn)));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath(captcha)).click();
		driver.switchTo().defaultContent();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submit_Btn)));
	}
	
	public void click_submit_btn() throws InterruptedException {
		Thread.sleep(3000);
		 WebDriverWait w = new WebDriverWait(driver,30);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submit_Btn)));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement element = driver.findElement(By.xpath(submit_Btn));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submit_Btn)));
		js.executeScript("arguments[0].click();", element);

	}

	public void fill_paymentPageDetails() {
		 WebDriverWait w = new WebDriverWait(driver,15);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(cardName_Txt)));
		  fill_cardName_Txt(excel.getCellData("payment", "NameOnCard", 2));
		  fill_CardNamber_Txt(excel.getCellData("payment", "CardNumber", 2));
		  fill_month_Txt(excel.getCellData("payment", "Month", 2));
		  fill_expyear_Txt(excel.getCellData("payment", "Year", 2));
		  fill_cvv_Txt(excel.getCellData("payment", "CVV", 2).trim());
		  fill_email(excel.getCellData("payment", "Email", 2));
		  
	}

	public void fill_authenticationPage() throws InterruptedException {
		 WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(email_Layer)));
		fill_email_Layer(excel.getCellData("authentication_page", "Email", 2).trim());
		 fill_password_Layer(excel.getCellData("authentication_page", "Password", 2).trim());
		 click_Captcha();
		 click_submit_btn();
	}
	
	
	
}
