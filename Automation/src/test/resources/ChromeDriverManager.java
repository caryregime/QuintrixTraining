import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriver {
	public void createDriver() {
		Path resourceDirectory = Paths.get("src","test","resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		Path driverFile = Paths.get(absolutePath, "chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", driverFile.toFile().getAbsolutePath());
		this.driver = new ChromeDriver();	
		this.driver.manage().window().maximize();
	}
}
