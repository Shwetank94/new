package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public WebDriver driver; 
    public Properties prop;
	public WebDriver intitializedriver() throws IOException {	
	prop = new Properties();
	//Using properties file in below line for global parameterization of URL and browser
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\data.properties");
    prop.load(fis);
    String browsername = prop.getProperty("browser");
   
    if(browsername.equalsIgnoreCase("chrome")) {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");//You can change the path for where your chromedriver is placed
    	driver = new ChromeDriver();
    	}
 
    else if(browsername.equalsIgnoreCase("firefox")) {
    	System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
    	driver=new FirefoxDriver();
    }
    
    else if (browsername.equalsIgnoreCase("IE")) {
    	System.setProperty("webdriver.ie.driver", "C:\\MicrosoftWebDriver.exe");
    	driver=new InternetExplorerDriver();
    }
    
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    
  
  
    return driver;
  }
	
	}
