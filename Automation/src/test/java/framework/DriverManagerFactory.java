package framework;

public class DriverManagerFactory extends TestBase{

	public static DriverManager getManager(String browserType) {
		
		if(browserType.equals("chrome")) {
			return new ChromeDriverManager();
		}
		if(browserType.equals("msedge")) {
			return new EdgeDriverManager();
		}
		
		throw new RuntimeException(browserType + " is not supported.");
	}

}
