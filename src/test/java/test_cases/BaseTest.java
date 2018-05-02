package test_cases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import base.Base;
import base.DriverContext;
import config.ConfigReader;
import config.Setting;
import jxl.read.biff.BiffException;
import pages.HomePage;
import utility.ExcelUtil;
import utility.Logger;

public class BaseTest extends Base{
	@BeforeSuite
	public void loadConfig() throws IOException, BiffException{
		ConfigReader.readConfig();
		ExcelUtil.initUtil(Setting.xlPath);
		Logger.createLogFile();
	}
	@BeforeMethod
	public void load_browser(){
		DriverContext.initialize(Setting.browserType);
		DriverContext.browser.go_to_url(Setting.url);
		currentPage=getCurrentPage(HomePage.class);
	}
	//@AfterMethod
	public void close_browser(){
		DriverContext.closeDriver();
	}
}
