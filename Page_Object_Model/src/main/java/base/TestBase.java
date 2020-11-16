package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
//	public  static EventFiringWebDriver e_driver;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/rajive/EclipseRoot/Page_Object_Model/src/main/java/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					"/Users/rajive/EclipseRoot/Page_Object_Model/Driver/geckodriver");
			System.out.println("launching firefox browser");
			driver = new FirefoxDriver();
		}
		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					"/Users/rajive/EclipseRoot/Page_Object_Model/Driver/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {

			System.setProperty("webdriver.ie.driver", "D:\\My Work\\Setup\\JAR\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("opera")) {

			System.setProperty("webdriver.opera.driver",
					"/Users/rajive/EclipseRoot/Page_Object_Model/Driver/operadriver");
			driver = new OperaDriver();

		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}
	public static void ClickElementByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0.click();]", element);
		
	}
	public static void ScrollElementByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor scrollJs = ((JavascriptExecutor)driver);
		scrollJs.executeScript("arguments[0.scrollIntoView(true);]", element);
		
	}
	
	public static void FlashElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i = 0; i<100; i++) { 
			changeColor("#000000", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}
		public static void changeColor(String color, WebElement element, WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0.scrollIntoView(true);]", element);
			
			
		
		
	}


}
