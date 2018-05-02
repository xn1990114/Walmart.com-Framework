package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import base.BasePage;

public class OrderSummaryPage extends BasePage{
	@FindBy(how=How.CLASS_NAME,using="checkout-header-checkout-text")
	public WebElement checkout_header;
	@FindBy(how=How.XPATH,using="//button[@aria-label='Place Order']")
	public WebElement place_order_button;
	
	public boolean isSummaryPage(){
		return this.checkout_header.isDisplayed()&&this.place_order_button.isDisplayed();
	}
	public BasePage complateTransaction(){
		this.place_order_button.click();
		return getCurrentPage(OrderCompletePage.class);
	}
	public BasePage complateTransaction_invlvalidPayment(){
		this.place_order_button.click();
		return getCurrentPage(CheckOut_PaymentPage.class);
	}
}
