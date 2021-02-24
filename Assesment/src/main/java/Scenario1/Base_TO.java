package Scenario1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_TO {

	public WebDriver driver;

	public Base_TO(WebDriver driver1) {
		driver = driver1;
	}

	public void clickWithJavaScript(WebDriver driver1, WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver1;
		executor.executeScript("arguments[0].click();", element);

		executor.executeScript("arguments[0].click();");

	}

	public void clickOnElement(WebDriver driver, WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		executor.executeScript("arguments[0].click();");
	}

	public void enterText(WebDriver driver, WebElement element, String text) {
		element.sendKeys(text);
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

}