package testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Scenario;

public class SignUpTest {

	private WebDriver webDriver;

	@BeforeTest
	public void beforeTest() {
		this.webDriver = new Scenario().initDriver();
		assertNotNull(this.webDriver);
	}

	@Test
	public void signupTest() throws Exception {
				
		this.webDriver.findElement(By.xpath(".//*[@id='navbarSupportedContent']/button")).click();
		this.webDriver.findElement(By.xpath(".//*[@id='accordion']/div/div[1]/div[2]/button")).click();
		this.webDriver.findElement(By.xpath(".//*[@id='signupform-contact']")).sendKeys("Dilusha alphonso");
		this.webDriver.findElement(By.xpath(".//*[@id='signupform-email']"))
				.sendKeys("Dilusha.alphonso+952000@itelasoft.com");
		this.webDriver.findElement(By.xpath(".//*[@id='signupform-password']")).sendKeys("123456");
		this.webDriver.findElement(By.xpath(".//*[@id='signup-btn']")).click();
		
		Thread.sleep(20000);

		// https://snowbo.itelasoft.com.au/?signupstatus=success
		String currentUrl = this.webDriver.getCurrentUrl();
		assertEquals(currentUrl, "https://snowbo.itelasoft.com.au/?signupstatus=success");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("SignUp Test Case Completed !...");
	}

}
