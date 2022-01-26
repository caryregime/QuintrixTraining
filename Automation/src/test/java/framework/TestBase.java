package framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {

	private WebDriver driver;
	private DriverManager driverManager;
	private Settings settings;

	protected WebDriver getDriver() {		
		return this.driver;
	}

	protected void setup() {
		this.settings = Settings.get();
		launchDriver();
	}

	protected void cleanup() {
		this.driverManager.quitDriver();
	}

	protected Settings getSettings() {
		return this.settings;
	}
	
	private void launchDriver() {		
		String browserType = getSettings().getBrowserType();
		this.driverManager = DriverManagerFactory.getManager(browserType);
		this.driverManager.createDriver();
		this.driver = driverManager.getDriver();

		long pageLoadTimeout = 60;
		this.driver.manage().timeouts().implicitlyWait(pageLoadTimeout , TimeUnit.SECONDS);
	}
}