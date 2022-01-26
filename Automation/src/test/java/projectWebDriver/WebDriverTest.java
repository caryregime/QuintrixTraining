package projectWebDriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.DriverManager;
import framework.DriverManagerFactory;

public class WebDriverTest {
	@DataProvider(name = "browserTypesDataProvider")
	public Object[] dpMethod() {
		return new Object[] { "chrome", "msedge" };
	}

	@Test(dataProvider = "browserTypesDataProvider")
	public void canLaunchSpecificWebDriver(String browserType) {
		DriverManager manager = DriverManagerFactory.getManager(browserType);
		manager.createDriver();
		WebDriver driver = manager.getDriver();
		manager.quitDriver();
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		String actualBrowserName = capabilities.getBrowserName().toLowerCase();
		Assert.assertEquals(actualBrowserName, browserType,
				"factory returned the wrong driver for browserType: " + browserType);
	}
}
