package HCLAssesmnt.Assesment;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Scenario1.AutomationPractice_TestMethods;

public class Scenario1 extends AutomationPractice_TestMethods {

	

	@Test
	public void addingItemToCartTest() {

		clickLoginButton();
		enterUserName();
		enterPassword();
		clickSubmitButton();
		clickOnTshirtTab();
		selectFadedShort();
		addShortToCart();
		verifyItemText();
		verifyColorOfAddedProduct();
		verifyQuantityIsDisplayed();
		verifyPriceMatchedAsExpected();
		verifyProductAddedSuccessfullyMessage();
		proceedToCheckOut();

	}

	@BeforeTest
	public void beforeTest() {
		openBrowser();
	}

	@AfterTest
	public void afterTest() {
		//quitBrowser();
	}

}
