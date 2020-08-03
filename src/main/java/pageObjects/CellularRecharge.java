package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Resources.Xls_Reader;


public class CellularRecharge {

	public WebDriver driver;
	
	private String operador_Txt = "//div[@to-do='mobile']/div/div[2]/ul/li/div/div[1]/input[@name='operator']";
	private String telecal_Logo = "//b[contains(text(),'Telcel')]";
	private String numero_Txt = "//div[@to-do='mobile']/div/div[2]/ul/li/div/div[1]/input[@name='mobile']";
	private String Montoderecharg_Txt = "//div[@to-do='mobile']/div/div[2]/ul/li/div/div[1]/input[@name='amount']";
	private String tendollars_Card = "//li[@data-name='10']/a";
	private String siguinte_Btn = "//div[@to-do='mobile']/div[1]/div[3]/div/button";
		
    Xls_Reader excel = new Xls_Reader(System.getProperty("user.dir")+"\\RechargeData.xlsx");
    
    
    
	public CellularRecharge(WebDriver driver2) {
    this.driver=driver2;
	}

	 //WebDriverWait w = new WebDriverWait(driver,10);
	
	public void click_Operador_Btn() {
		driver.findElement(By.xpath(operador_Txt)).click();
		
	}
	
	public void click_Telecal_Logo() {
		driver.findElement(By.xpath(telecal_Logo)).click();
	}
	
	public void fill_Numero_Txt(String text) {
		driver.findElement(By.xpath(numero_Txt)).sendKeys(text);
	}
	
	public void click_Montoderecharg_Txt() {
		driver.findElement(By.xpath(Montoderecharg_Txt)).click();
	}
	
	public void click_Tendollars_Card() {
		driver.findElement(By.xpath(tendollars_Card)).click();
	}
	
	public void click_siguinte_Btn() {
		driver.findElement(By.xpath(siguinte_Btn)).click();
	}
	
		
	public void fill_UserDetails() {
		 WebDriverWait w = new WebDriverWait(driver,10);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(operador_Txt)));
		  click_Operador_Btn();
		  click_Telecal_Logo();
		  fill_Numero_Txt(excel.getCellData("User_Detail", "ContactNumber", 2).trim());
		  click_Montoderecharg_Txt();
		  click_Tendollars_Card();
	}
	

}

