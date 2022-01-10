package projectJavaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;

public class ReadPropertyFile {

	public static void main(String[] args) throws FileNotFoundException {
		final String filepath = "C:\\Users\\Regime Cary\\git\\QuintrixTraining\\Automation\\src\\test\\resources\\config.properties";
		Properties prop=new Properties();
		FileInputStream ip= new 
				
		FileInputStream(filepath);
		//		This path is not working: FileInputStream("Automation\\src\\test\\resources\\config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browserType = prop.getProperty("BrowserType");
		System.out.println(browserType);
		
		Assert.assertTrue(browserType != null);
	}

}
