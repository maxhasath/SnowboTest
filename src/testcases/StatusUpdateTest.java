package testcases;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Scenario;

public class StatusUpdateTest {

	private WebDriver webdriver;
	private WebDriverWait webDriverWait;

	@BeforeTest
	public void beforetest() {
		this.webdriver = new Scenario().initDriver();
		this.webDriverWait = new WebDriverWait(this.webdriver, 20);
		assertNotNull(this.webdriver);

	}

	@Test
	public void statusUpdate() {

		try {
			LoginTest test = new LoginTest();
			test.webDriver = this.webdriver;
			test.loginTest();
			System.out.println("login done");

			System.out.println("done");
			Thread.sleep(2000);

			// load main feed div element
			WebElement snoboFeedElement = this.webDriverWait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='snowbofeed']/div")));
			// get snobofeed count
			int beforeCount = this.webdriver.findElements(By.xpath(".//*[@id='snowbofeed']/div")).size();

			this.webdriver.findElement(By.xpath(".//*[@id='status']")).sendKeys("Weekend with the family");
			Thread.sleep(1000);
			this.webdriver.findElement(By.xpath(".//*[@id='send-btn']")).click();

			// wait till element present after form submit, this check is needed because,
			// page reload
			this.webDriverWait.until(ExpectedConditions.stalenessOf(snoboFeedElement));

			// get snobofeed count
			int afterCount = this.webdriver.findElements(By.xpath(".//*[@id='snowbofeed']/div")).size();
			System.out.println("beforeCount : " + beforeCount);
			System.out.println("afterCount : " + afterCount);
			assertTrue(afterCount > beforeCount);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@AfterTest
	public void aftertest() {
		System.out.println("Status update test case completed..!");

	}

}
