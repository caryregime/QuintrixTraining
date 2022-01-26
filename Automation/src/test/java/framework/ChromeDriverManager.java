package framework;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{
	public final String ENVIRONMENT_VARIABLE = "webdriver.chrome.driver";
	public final String DRIVER_EXE = "chromedriver.exe";	
	
	public void createDriver() {	
		Path resourceDirectory = Paths.get("src","test","resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		Path driverFile = Paths.get(absolutePath, DRIVER_EXE);
		System.setProperty(ENVIRONMENT_VARIABLE, driverFile.toFile().getAbsolutePath());

		WebDriver driver = new ChromeDriver();

		this.setDriver(driver);
	}
}
