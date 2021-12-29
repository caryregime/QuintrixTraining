package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {
	private ChromeDriver driver;
	private final String url = "https://www.selenium.dev/";;

	@Test
	public void canLaunchWebDriver() {
		String currenturl = driver.getCurrentUrl();
		Assert.assertEquals(url, currenturl);
	}

	@Test
	public void canClickButton() {
		WebElement element = driver.findElement(By.cssSelector("a[href='/documentation/webdriver/']"));
		element.click();
		driver.quit();
	}

	@BeforeMethod
	public void setup() {
		//String driverpath = "C:\\Users\\Regime Cary\\eclipse-quintrix-training\\driver\\chromedriver.exe";
		//System.setProperty("webdriver.chrome.driver", driverpath);
		String driverpath = System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.navigate().to(url);
	}
	
	@AfterMethod
	public void cleanup() {
		this.driver.quit();
	}
}
