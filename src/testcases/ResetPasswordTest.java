package testcases;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Scenario;

public class ResetPasswordTest {
	
	
	private WebDriver webdriver;
	
	
	@BeforeTest
	public void beforetest() {
		
		this.webdriver = new Scenario().initDriver();
		assertNotNull(this.webdriver);
		
	}
	
	
	@Test
	public void resetpassword() {
		
		
		this.webdriver.findElement(By.xpath(".//*[@id='navbarSupportedContent']/button")).click();
		this.webdriver.findElement(By.xpath(".//*[@id='login-form']/a")).click();
		this.webdriver.findElement(By.xpath(".//*[@id='passwordresetrequestform-email']")).sendKeys("praveenjt94@gmail.com");
		this.webdriver.findElement(By.xpath(".//*[@id='forgotpass-btn']")).click();
		
		
	}
	
	
	@AfterTest
	public void aftretest() {
		
		System.out.println("Resetpassword test case completed...!");
	}
	
	

}
