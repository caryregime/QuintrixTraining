package SeleniumTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {
	@Test
	public void canLaunchWebDriver() {
		String driverpath = "C:\\Users\\Regime Cary\\eclipse-quintrix-training\\driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);

		String url = "https://www.selenium.dev/";
		ChromeDriver driver = new ChromeDriver();

		driver.navigate().to(url);
		String currenturl = driver.getCurrentUrl();
		
		Assert.assertEquals(url, currenturl);
		
		driver.quit();
	}
}
