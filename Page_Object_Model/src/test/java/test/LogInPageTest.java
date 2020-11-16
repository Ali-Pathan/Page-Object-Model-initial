package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LogInPage;

public class LogInPageTest extends TestBase {

	LogInPage loginpage;

	public LogInPageTest() {
		super();
	}
	

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LogInPage();


	}

	//@Test(priority = 1)
	public void validateLogInPagePageTitleTest() {
		String title = loginpage.LogInPagePageTitle();
		Assert.assertEquals(title, "Cheap Flights, Airline tickets and Hotels - JustFly");
	}
	
	@Test(priority = 2)
	public void SignInTest(){
		loginpage.ClickonSignin();
	}
//	@Test(priority = 3)
//	public void enteremailTest(){
//		loginpage.enterEmail();
//	}

	
	
	
	
	
	
	
	
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
