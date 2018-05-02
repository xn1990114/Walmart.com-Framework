package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;

public class CheckOut_FullfillmentPage extends BasePage{
	@FindBy(how=How.CLASS_NAME,using="checkout-header-checkout-text")
	public WebElement checkout_header;
	//@FindBy(how=How.CLASS_NAME,using="CXO-InlineShippingOptions-option display-block")
	//public List<WebElement> shipping_options;
	@FindBy(how=How.XPATH,using="//button[@aria-label='Continue to Shipping Address']")
	public WebElement continue_to_shipping_address_button;
	@FindBy(how=How.XPATH,using="//a[@class='pull-right']")
	public WebElement navigate_to_cart_button;
	
	
	public BasePage select_kth_shipping_option(int index){
		/*if(index<=0||index>this.shipping_options.size()){
			return this;
		}
		this.shipping_options.get(index-1).click();*/
		this.continue_to_shipping_address_button.click();
		return getCurrentPage(CheckOut_ShippingAddressPage.class);
	}
	public BasePage navigate_to_cart(){
		this.navigate_to_cart_button.click();
		return getCurrentPage(CartPage.class);
	}
	public boolean isCheckout_fullfillment_page(){
		return this.continue_to_shipping_address_button.isDisplayed();
	}
	
}
