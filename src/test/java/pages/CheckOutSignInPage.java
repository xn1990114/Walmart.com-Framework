package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.DriverContext;

public class CheckOutSignInPage extends BasePage{
	@FindBy(how=How.CLASS_NAME,using="checkout-header-checkout-text")
	public WebElement checkout_header;
	@FindBy(how=How.XPATH,using="//input[@type='email']")
	public WebElement email_textbox;
	@FindBy(how=How.XPATH,using="//input[@type='password']")
	public WebElement password_textbox;
	@FindBy(how=How.XPATH,using="(//button[@type='submit'])[1]")
	public WebElement submit_button;
	@FindBy(how=How.XPATH,using="//button[text()='Continue']")
	public WebElement continue_without_signin_button;
	
	public BasePage signIn(String userId,String password){
		this.email_textbox.sendKeys(userId);
		this.password_textbox.sendKeys(password);
		this.submit_button.click();
		return getCurrentPage(CheckOut_FullfillmentPage.class);
	}
	
	public boolean isCheckoutWithSignInPage(){
		return this.checkout_header.isDisplayed()&&this.email_textbox.isDisplayed();
	}
	public BasePage continue_without_signin() throws InterruptedException{
		this.continue_without_signin_button.click();
		Thread.sleep(3000);
		return getCurrentPage(CheckOut_FullfillmentPage.class);
	}
}
