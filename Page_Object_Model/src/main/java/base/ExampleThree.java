package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

public class ExampleThree {
	
	public WebDriver driver;
	
	@Test
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/Users/rajive/EclipseRoot/Page_Object_Model/Driver/chromedriver");
		//System.setProperty("webdriver.opera.driver", "/Users/rajive/EclipseRoot/Page_Object_Model/Driver/operadriver");
		driver = new ChromeDriver();
    	//driver = new OperaDriver();
	}

	@Test
	public void openApplication() {
		driver.navigate().to("https://www.justfly.com/");
	}
	
	@Test 
	public void clickSignIn() {
		driver.findElement(By.xpath("//div[@class='jfly-header-user-profile header-dropdown-btn']")).click();
	}
	
//	@Test
//	public void closeDriver() {
//		if(driver!=null) {
//			driver.close();
//		}
//	}

}
