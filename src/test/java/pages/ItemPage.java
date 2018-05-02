package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;

public class ItemPage extends BasePage{
	@FindBy(how=How.XPATH,using="//*[@id='global-search-input']")
	public WebElement search_textbox;
	@FindBy(how=How.XPATH,using="//*[@id='global-search-form']/div/div[3]/button")
	public WebElement search_button;
	@FindBy(how=How.CLASS_NAME,using="ProductTitle")
	public WebElement item_name;
	@FindBy(how=How.XPATH,using="//button[@data-tl-id='ProductPrimaryCTA-cta_add_to_cart_button']")
	public WebElement add_to_cart_Button;
	@FindBy(how=How.XPATH,using="//button[@data-automation-id='pac-pos-view-cart']")
	public WebElement go_to_cart_Button;
	@FindBy(how=How.XPATH,using="//button[@data-tl-id='PACElContShoppingBtn']")
	public WebElement continue_shopping_Button;
	@FindBy(how=How.XPATH,using="//button[@data-automation-id='pac-pos-proceed-to-checkout']")
	public WebElement checkout_Button;
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div/div/div[1]/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[9]/div[1]/div[1]/div[1]/span/span[2]/div/div")
	public WebElement qty_Button;
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div/div/div[1]/div/div/div/div[1]/div/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[9]/div[1]/div[1]/div[1]/span/span[2]/div/select/option")
	public List<WebElement> qty_options;
	
	
	public boolean is_item_info_page(){
		return this.item_name.isDisplayed();
	}
	public BasePage add_item_and_navigate_to_cart(){
		this.add_to_cart_Button.click();
		this.go_to_cart_Button.click();
		return getCurrentPage(CartPage.class);
	}
	public BasePage add_item_and_navigate_to_checkout(){
		this.add_to_cart_Button.click();
		this.checkout_Button.click();
		return getCurrentPage(CheckOutSignInPage.class);
	}
	public BasePage add_item_and_stay(){
		this.add_to_cart_Button.click();
		this.continue_shopping_Button.click();
		return getCurrentPage(ItemPage.class);
	}
	public BasePage enter_qty(int qty) throws Exception{
		if(qty<=0||qty>13){
			throw new Exception("not valid qty");
		}
		this.qty_Button.sendKeys("3");
		return this;
	}
	public BasePage search(String item_name){
		this.search_textbox.sendKeys(item_name);
		this.search_button.click();
		return getCurrentPage(SearchResultPage.class);
	}
}
