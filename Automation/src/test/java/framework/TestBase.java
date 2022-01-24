package framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {

	private ChromeDriver driver;
	protected WebDriver getDriver() {
		return this.driver;
	}
	
	public void setup() {
		launchDriver();
	}
	
	public void cleanup() {
		this.driver.quit();
	}
	
	private void launchDriver() {
		long pageLoadTimeout = 60;
		this.driver.manage().timeouts().implicitlyWait(pageLoadTimeout , TimeUnit.SECONDS);
	}
}