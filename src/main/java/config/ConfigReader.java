package config;

import java.io.IOException;
import java.util.Properties;
import base.BrowserType;

public class ConfigReader {
	public static void readConfig() throws IOException{
		Properties p = new Properties();
		p.load(ConfigReader.class.getResourceAsStream("Config.properties"));
		Setting.browserType=BrowserType.valueOf(p.getProperty("browserType"));
		Setting.url=p.getProperty("url");
		Setting.logPath=p.getProperty("logPath");
		Setting.xlPath=p.getProperty("xlPath");
	}
}
