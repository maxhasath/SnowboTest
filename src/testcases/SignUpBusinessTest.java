package testcases;

import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Scenario;

public class SignUpBusinessTest {

	private WebDriver webdriver;

	@BeforeTest
	public void beforetest() {

		this.webdriver = new Scenario().initDriver();
		assertNotNull(this.webdriver);

	}

	@Test
	public void signupBusiness() {

		this.webdriver.findElement(By.xpath(".//*[@id='navbarSupportedContent']/button")).click();
		this.webdriver.findElement(By.xpath(".//*[@id='accordion']/div/div[1]/div[2]/button")).click();
		this.webdriver.findElement(By.xpath(".//*[@id='user-form-signup']/div[1]/div/div/label[2]")).click();
		this.webdriver.findElement(By.xpath(".//*[@id='signupform-contact']")).sendKeys("peter paker");
		this.webdriver.findElement(By.xpath(".//*[@id='signupform-name']")).sendKeys("Snow snow");
		this.webdriver.findElement(By.xpath(".//*[@id='signupform-email']"))
				.sendKeys("Dilusha.alphonso+600@itelasoft.com");
		this.webdriver.findElement(By.xpath(".//*[@id='signupform-password']")).sendKeys("123456");
		this.webdriver.findElement(By.xpath(".//*[@id='signup-btn']")).click();

	}

	@AfterTest
	public void aftretest() {

		System.out.println("Business user Signup Test case completed..!");

	}

}
