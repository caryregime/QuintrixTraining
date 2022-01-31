package framework;

import java.util.HashMap;

public class Settings {
	private static final String CONFIG_FILE_NAME = "config.properties";
	private Settings settings;
	private String browserType;

	public String getBrowserType() {
		return browserType;
	}

	public void setBrowserType(String value) {
		this.browserType = value;	
	}

	public static Settings get() {
		Settings settings = new Settings();

		ConfigurationProvider configurationProvider = new ConfigurationProvider();
		HashMap<String,String> configurations;
		try {
			configurations = configurationProvider.getPropertiesFromResourceFile(CONFIG_FILE_NAME);
		} catch (Exception e) {
			throw new RuntimeException("Error reading config file: " + e.getLocalizedMessage());
		}

		settings.browserType = configurations.get("BrowserType");
		
		return settings;
	}
}
