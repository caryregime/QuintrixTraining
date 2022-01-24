package projectWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import framework.DriverManager;
import framework.TestBase;

public class DriverManagerFactory extends TestBase{

	public DriverManager getManager() throws FileNotFoundException {
		final String filepath = System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties";
		Properties prop=new Properties();
		FileInputStream ip= new FileInputStream(filepath);
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browserType = prop.getProperty("BrowserType");
		System.out.println(browserType);

        DriverManager driverManager = new DriverManager(String browserType);
        return driverManager;
	}

}
