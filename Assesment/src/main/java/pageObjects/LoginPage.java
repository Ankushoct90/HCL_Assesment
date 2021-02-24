package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		System.out.println("Page Factory initialized");
	}

	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	public WebElement signInButton;
	
	public WebElement getSignInButton() {
		return signInButton;
	}


	public WebElement getEmailIdTextBox() {
		return emailIdTextBox;
	}


	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(css="#email")
	public WebElement emailIdTextBox;
	
	@FindBy(css="#passwd")
	public WebElement passwordTextBox;
	

	@FindBy(css="#SubmitLogin")
	public WebElement loginButton;
	
}
