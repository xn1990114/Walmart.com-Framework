package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverContext {
	public static WebDriver driver;
	public static Browser browser;
	public static WebDriver getDriver() {
		return driver;
	}

	public static void initialize(BrowserType type) {
		WebDriver d = null;
		if (type == BrowserType.Chrome) {
			d=new ChromeDriver();
		} else if (type == BrowserType.Safari) {
			d=new SafariDriver();
		} else if (type == BrowserType.IE) {
			d=new InternetExplorerDriver();
		} else if (type == BrowserType.FireFox) {
			d=new FirefoxDriver();
		}
		driver=d;
		browser=new Browser(d);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void closeDriver() {
		driver.close();
	}
}
