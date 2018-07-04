package testcases;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Scenario;

public class LoginTest {
	public WebDriver webDriver;

	@BeforeTest
	public void beforeTest() {
		this.webDriver = new Scenario().initDriver();
		assertNotNull(this.webDriver);
	}

	@Test
	public void loginTest() {
		this.webDriver.findElement(By.xpath(".//*[@id='navbarSupportedContent']/button")).click();
		//this.webDriver.findElement(By.xpath(".//*[@id='loginform-email']")).sendKeys("praveenjt94@gmail.com");
		this.webDriver.findElement(By.xpath(".//*[@id='loginform-email']")).sendKeys("akeela@itelasoft.com");
		this.webDriver.findElement(By.xpath(".//*[@id='loginform-password']")).sendKeys("123456");
		this.webDriver.findElement(By.xpath(".//*[@id='login-form']/button")).click();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Login Test Case Completed !...");
	}
}
