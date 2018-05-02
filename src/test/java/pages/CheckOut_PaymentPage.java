package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.DriverContext;

public class CheckOut_PaymentPage extends BasePage{

	@FindBy(how=How.XPATH,using="//input[@id='creditCard']")
	public WebElement card_num_testbox;
	@FindBy(how=How.XPATH,using="//select[@id='month-chooser']")
	public WebElement exp_date_MM;
	@FindBy(how=How.XPATH,using="//select[@id='year-chooser']")
	public WebElement exp_date_YY;
	@FindBy(how=How.XPATH,using="//input[@name='cvv']")
	public WebElement cvv_textbox;
	@FindBy(how=How.XPATH,using="//button[@class='btn btn-primary']")
	public WebElement review_order_button;
	@FindBy(how=How.XPATH,using="//a[@class='pull-right']")
	public WebElement navigate_to_cart_button;
	
	public BasePage fill_credit_card_info(String cardNum,String expMM,String expYY,String cvv){
		this.card_num_testbox.sendKeys(cardNum);
		this.exp_date_MM.sendKeys(expMM);
		this.exp_date_YY.sendKeys(expYY);
		this.cvv_textbox.sendKeys(cvv);
		WebDriverWait w=new WebDriverWait(DriverContext.driver,10);
		w.until(ExpectedConditions.elementToBeClickable(this.review_order_button));
		this.review_order_button.click();
		return getCurrentPage(OrderSummaryPage.class);
	}
	public boolean isCheckout_paymentPage(){
		return this.review_order_button.isDisplayed();
	}
	public BasePage navigate_to_cart(){
		this.navigate_to_cart_button.click();
		return getCurrentPage(CartPage.class);
	}
}
