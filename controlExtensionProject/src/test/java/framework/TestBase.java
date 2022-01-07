package framework;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {

	private ChromeDriver driver;
	private String url = "https://demoqa.com/";
	private String urlProgressBar = "https://demoqa.com/progress-bar";
	protected WebDriver getDriver() {
		return this.driver;
	}
	
	public void gotoProgressBar() {
		String Header = "Progress Bar";
		this.driver.navigate().to(urlProgressBar);
		String actualHeader = driver.findElementByClassName("main-header").getText();
		Assert.assertEquals("We reached Progress Bar Page",Header, actualHeader);
		}
	
	public void gotoElements() {
		driver.findElementByXPath("//div[@class=\"card-body\"]//h5[normalize-space(text())=\"Elements\"]").click();
	}
	
	public void gotoWidgets() {
		driver.findElementByXPath("//div[@class=\"card-body\"]//h5[normalize-space(text())=\"Widgets\"]").click();
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