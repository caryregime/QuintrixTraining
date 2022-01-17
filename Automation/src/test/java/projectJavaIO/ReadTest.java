package projectJavaIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReadTest {
	
	@Test
	public void browserType() throws FileNotFoundException {
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
		Assert.assertTrue(browserType != null);
	}

	@Test
	public void csvfile() {
		String csvfilepath = System.getProperty("user.dir")+"\\src\\test\\resources\\basses.csv";
		BufferedReader reader = null;
		try {
			String line = "";
			reader = new BufferedReader(new FileReader(csvfilepath));
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				System.out.println("Make: " + fields[0] + " Model: " + fields[1]);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
