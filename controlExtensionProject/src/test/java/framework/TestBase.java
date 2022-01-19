package framework;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {

	private ChromeDriver driver;
	protected WebDriver getDriver() {
		return this.driver;
	}
	
	public void setup() {
		launchChromeDriver();
	}
	
	public void cleanup() {
		this.driver.quit();
	}
	
	private void launchChromeDriver() {
		Path resourceDirectory = Paths.get("src","test","resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		Path driverFile = Paths.get(absolutePath, "chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverFile.toFile().getAbsolutePath());
		this.driver = new ChromeDriver();	
		this.driver.manage().window().maximize();
		long pageLoadTimeout = 60;
		this.driver.manage().timeouts().implicitlyWait(pageLoadTimeout , TimeUnit.SECONDS);
	}
}