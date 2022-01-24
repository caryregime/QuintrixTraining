package framework;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager{
	private WebDriver driver;
	private String browserType;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public DriverManager(String browserType) {
		this.browserType = browserType;
	}

	protected void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void quitDriver() {
		this.driver.quit();
	}
	
	public abstract void createDriver(String browserType);
	
}
