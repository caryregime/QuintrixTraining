package framework;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager{
	public final String ENVIRONMENT_VARIABLE = "webdriver.edge.driver";
	public final String DRIVER_EXE = "msedgedriver.exe";	
	
	public void createDriver() {	
		Path resourceDirectory = Paths.get("src","test","resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		Path driverFile = Paths.get(absolutePath, DRIVER_EXE);
		System.setProperty(ENVIRONMENT_VARIABLE, driverFile.toFile().getAbsolutePath());
		
		WebDriver driver = new EdgeDriver();

		this.setDriver(driver);
	}
}
