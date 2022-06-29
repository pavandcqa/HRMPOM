package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	File file;
	FileInputStream fis;
	Properties prop;

	public ConfigReader() {

		try {
			file = new File("./config.properties");

			fis = new FileInputStream(file);

			prop = new Properties();

			prop.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getAppUrl() {
		return prop.getProperty("appUrl");
	}

	public String getChromePath() {
		return prop.getProperty("chromePath");
	}
	
	public String getUserName() {
		return prop.getProperty("userName");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public int getImplicitWaitTime() {
		
		String wait = prop.getProperty("implicitWait");
		return Integer.parseInt(wait);
	}
}
