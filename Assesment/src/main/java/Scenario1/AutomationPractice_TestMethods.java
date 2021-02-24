package Scenario1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pageObjects.LoginPage;

public class AutomationPractice_TestMethods extends Base_TO {

	public static WebDriver driver;
	LoginPage loginPage;

	public AutomationPractice_TestMethods() {
		super(driver);
		loginPage = new LoginPage(driver);
	}

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ankanku1\\Desktop\\Drivers\\chromedriver_win32 (2)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public void quitBrowser() {
		driver.quit();
	}

	public void enterUserName() {

		driver.findElement(By.cssSelector("#email")).sendKeys("jetblue@grr.la");
	}

	public void enterPassword() {

		driver.findElement(By.cssSelector("#passwd")).sendKeys("jetblue");
	}

	public void clickLoginButton() {
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();

	}

	public void clickSubmitButton() {
		driver.findElement(By.cssSelector("#SubmitLogin")).click();

	}

	public void clickOnTshirtTab() {
		driver.findElement(By.xpath("(//a[text()='T-shirts'])[2]")).click();
	}

	public void selectFadedShort() {
		driver.findElement(By.xpath("//a[@class='product_img_link']/img")).click();
	}

	public void addShortToCart() {

		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		driver.findElement(By.cssSelector("#add_to_cart")).click();
	}

	public void verifyItemText() {
		driver.switchTo().defaultContent();
		String expectedMessage = "Faded Short Sleeve T-shirts";

		String msgFromApp = driver.findElement(By.xpath("//span[text()='Faded Short Sleeve T-shirts']")).getText();

		Assert.assertEquals(expectedMessage, msgFromApp);
	}

	public void verifyColorOfAddedProduct() {

		String expectedColor = "Orange, S";

		String colorFromApp = driver.findElement(By.xpath("//span[text()='Orange, S']")).getText();

		Assert.assertEquals(expectedColor, colorFromApp);
	}

	public void verifyQuantityIsDisplayed() {

		WebElement element = driver.findElement(By.cssSelector("#layer_cart_product_quantity"));
		Assert.assertTrue(element.isDisplayed());

	}

	public void verifyPriceMatchedAsExpected() {

		WebElement element = driver.findElement(By.cssSelector("#layer_cart_product_quantity"));
		String quantity = element.getText();
		int qnt = Integer.parseInt(quantity);
		String totalPrice = driver.findElement(By.cssSelector("#layer_cart_product_price")).getText();
		totalPrice = totalPrice.substring(1, 6);
		double finalPrice = 16.51 * qnt;
		Assert.assertEquals(totalPrice, Double.toString(finalPrice));

	}

	public void verifyProductAddedSuccessfullyMessage() {

		String expectedMessage = "Product successfully added to your shopping cart";

		String msgFromApp = driver.findElement(By.xpath("//span[@title='Close window']/following-sibling::h2"))
				.getText();

		Assert.assertEquals(expectedMessage, msgFromApp);
	}

	public void proceedToCheckOut() {
		driver.findElement(By.xpath("//a[@title='Proceed to checkout']")).click();
	}

}
