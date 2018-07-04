package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scenario {
	/**
	 * Initialize web driver
	 * 
	 * @return
	 */
	public WebDriver initDriver() {
		WebDriver driver = null;
		try {
			driver = new FirefoxDriver();
			driver.get("https://snowbo.itelasoft.com.au");
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
