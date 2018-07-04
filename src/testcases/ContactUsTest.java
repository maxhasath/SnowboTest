package testcases;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Scenario;

public class ContactUsTest {
	private WebDriver webDriver;

	@BeforeTest
	public void beforeTest() {
		this.webDriver = new Scenario().initDriver();
		assertNotNull(this.webDriver);
	}

	@Test
	public void ContactUsTestTest() {
		this.webDriver.findElement(By.xpath(".//*[@id='navbarSupportedContent']/ul/li[4]/a/span")).click();
		this.webDriver.findElement(By.xpath(".//*[@id='contactform-name']")).sendKeys("Praveen");
		this.webDriver.findElement(By.xpath(".//*[@id='contactform-email']")).sendKeys("praveenjt94@gmail.com");
		this.webDriver.findElement(By.xpath(".//*[@id='contactform-subject']")).sendKeys("Counld not signup");
		this.webDriver.findElement(By.xpath(".//*[@id='contactform-body']"))
				.sendKeys("I could not sign up, Please do something");
		this.webDriver.findElement(By.xpath(".//*[@id='contactform-verifycode']")).sendKeys("qoqulu");
		this.webDriver.findElement(By.xpath(".//*[@id='contactform-btn']")).click();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Contact us Test Case Completed !...");
	}

}
