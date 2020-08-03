package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage {

	public WebDriver driver;
	
	private String success_msg = "//span[@class='recharge-status success-msg']";
	private String amount = "//span[@class='recharge-amount']/div";
	
	
	public ConfirmationPage(WebDriver driver2) {
		this.driver = driver2;
	}

	public String getText_Success() {
		 WebDriverWait w = new WebDriverWait(driver,30);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(success_msg)));
		return driver.findElement(By.xpath(success_msg)).getText().trim()+" - "+driver.findElement(By.xpath(amount)).getText().trim();
	}
	
}
