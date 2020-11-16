package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LogInPage extends TestBase {

	@FindBy(xpath = "//div[@class='jfly-header-user-profile header-dropdown-btn']")
	WebElement signinBtn;

	@FindBy(xpath = "//input[@id='login-modal-account-login-email']")
	WebElement email;

	@FindBy(xpath = "//*[@class='login-modal-submit-btn is-main-button regular']")
	WebElement ContinueForPassword;

	public LogInPage() {

		PageFactory.initElements(driver, this);

	}

	public String LogInPagePageTitle() {
		return driver.getTitle();
	}

	public void ClickonSignin(){
		signinBtn.click();
		email.click();
		email.sendKeys("asdffffffffffffffffffffffffffffffffffffffffffghj");
	}
	
//	public void enterEmail(){
//		email.click();
//		email.sendKeys("asdffffffffffffffffffffffffffffffffffffffffffghj");
//	}

//	public HomePage login(String un, String pw) {
//		username.sendKeys(un);
//		password.sendKeys(pw);
//		button.click();
//		return new HomePage();
//
//	}

}
