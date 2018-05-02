package base;

import org.openqa.selenium.WebDriver;

public class Browser {
	WebDriver driver;
	public Browser(WebDriver driver){
		this.driver=driver;
	}
	public void go_to_url(String url){
		this.driver.get(url);
	}
	public void maximize(){
		this.driver.manage().window().maximize();
	}
}
