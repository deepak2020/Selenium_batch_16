package commonMethods_package;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CommonMethods {
	public static WebDriver driver;
	

	public void openBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Selenium_Driver\\chromedriver2.31.exe");
		URL hubURL = new URL("http://localhost:4444/wd/hub");
		
		
		
		DesiredCapabilities capababilities = DesiredCapabilities.chrome();	
		System.out.println(hubURL);
		System.out.println(capababilities);
		driver = new RemoteWebDriver(hubURL, capababilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	public void getURL(String url) {
		driver.get(url);
	}
	
	public WebElement findElement(String locator, String element){	
		WebElement elem = null;
		if (locator=="xpath"){
			 elem =driver.findElement(By.xpath(element));
		} else if (locator=="id"){
			elem =driver.findElement(By.id(element));
		} else if (locator == "css"){
			elem = driver.findElement(By.cssSelector(element));
		}
		
		return  elem;
	}
	
	public void sendKeys(WebElement element, String value){
		element.sendKeys(value);
		
	}
	
	public void click (WebElement element){
		element.click();
		
	}
	
	
	public String getProperties(String Key) throws IOException{
		
		File file = new File("C:\\Users\\deepak.kumar\\New_Workspace\\Selenium_Framework\\config.properties");
				
		FileInputStream fileInput = new FileInputStream(file);
		
		Properties prop = new Properties();
		prop.load(fileInput);
	
		return prop.getProperty(Key);		
		
	}

}
