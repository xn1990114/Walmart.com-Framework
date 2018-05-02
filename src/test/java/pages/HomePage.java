package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;
import base.DriverContext;

public class HomePage extends BasePage{
	//@FindBy(how=How.XPATH,using="//a[@data-tl-id='header-GlobalAccountFlyout-flyout-link-0']")
	//public WebElement sign_in_button;
	@FindBy(how=How.XPATH,using="//div[@class='header-GlobalAccountFlyout-customerName dropdown-link']")
	public WebElement sign_in_logo;
	@FindBy(how=How.XPATH,using="//*[@id='header-GlobalAccountFlyout-flyout-link']/div[2]/span")
	public WebElement userName;
	@FindBy(how=How.XPATH,using="//*[@id='global-search-input']")
	public WebElement search_textbox;
	@FindBy(how=How.XPATH,using="//*[@id='global-search-form']/div/div[3]/button")
	public WebElement search_button;
	
	public BasePage navigate_to_signInPage(){
		Actions t=new Actions(DriverContext.driver);
		t.moveToElement(this.sign_in_logo).perform();
		DriverContext.driver.findElement(By.xpath("//a[@data-tl-id='header-GlobalAccountFlyout-flyout-link-0']")).click();
		//this.sign_in_button.click();
		return getCurrentPage(SignInPage.class);
	}
	public boolean is_signed_in(){
		return !this.userName.getText().equals("Sign In");
	}
	
	public BasePage search(String item_name){
		this.search_textbox.sendKeys(item_name);
		this.search_button.click();
		return getCurrentPage(SearchResultPage.class);
	}
}
