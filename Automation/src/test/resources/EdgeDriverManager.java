import java.nio.file.Path;
import java.nio.file.Paths;

public class EdgeDriver {
	public void createDriver() {
		Path resourceDirectory = Paths.get("src","test","resources");
		String absolutePath = resourceDirectory.toFile().getAbsolutePath();
		Path driverFile = Paths.get(absolutePath, "msedgedriver.exe");
		System.setProperty("webdriver.edge.driver", driverFile.toFile().getAbsolutePath());
		this.driver = new EdgeDriver();	
		this.driver.manage().window().maximize();
	}
}
