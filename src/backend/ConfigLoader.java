package backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

	private String configPath = "src/resource/config.properties";
	
	public String getProperty(String property) {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(configPath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(property);
		
	}
}
