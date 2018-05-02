package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;

public class SignInPage extends BasePage{
	@FindBy(how=How.XPATH,using="/html/body/div/div/div/div[2]/div/section/form/div[1]/div/label/div[2]/div/input")
	public WebElement email_textBox;
	@FindBy(how=How.XPATH,using="/html/body/div/div/div/div[2]/div/section/form/div[2]/div/div[1]/label/div[2]/div/input")
	public WebElement password_textbox;
	@FindBy(how=How.XPATH,using="/html/body/div/div/div/div[2]/div/section/form/div[5]/button")
	public WebElement submit_button;
	
	public BasePage signIn(String userId,String password) throws InterruptedException{
		this.email_textBox.sendKeys(userId);
		this.password_textbox.sendKeys(password);
		this.submit_button.click();
		Thread.sleep(3000);
		return getCurrentPage(HomePage.class);
	}
}
