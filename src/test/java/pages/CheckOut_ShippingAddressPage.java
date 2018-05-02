package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BasePage;
import base.DriverContext;

public class CheckOut_ShippingAddressPage extends BasePage{
	@FindBy(how=How.XPATH,using="//input[@title='First name']")
	public WebElement cust_first_name;
	@FindBy(how=How.XPATH,using="//input[@title='Last name']")
	public WebElement cust_last_name;
	@FindBy(how=How.XPATH,using="//input[@title='Street address']")
	public WebElement cust_st_address;
	@FindBy(how=How.XPATH,using="//input[@title='Phone number']")
	public WebElement cust_phone_number;
	@FindBy(how=How.XPATH,using="//input[@title='Email']")
	public WebElement cust_email;
	@FindBy(how=How.XPATH,using="//input[@title='City']")
	public WebElement cust_city;
	@FindBy(how=How.XPATH,using="//select[@title='State']")
	public WebElement cust_state;
	@FindBy(how=How.XPATH,using="//input[@title='Zip code']")
	public WebElement cust_zip;
	@FindBy(how=How.XPATH,using="//button[@aria-label='Continue to Payment Options']")
	public WebElement continue_to_payment_button;
	@FindBy(how=How.XPATH,using="//a[@class='pull-right']")
	public WebElement navigate_to_cart_button;
	
	public BasePage fill_cust_info(String firstName,String lastName,String st,String phone,String email,String city,String state,String zip){
		this.cust_city.clear();
		this.cust_zip.clear();
		this.cust_first_name.sendKeys(firstName);
		this.cust_last_name.sendKeys(lastName);
		this.cust_st_address.sendKeys(st);
		this.cust_phone_number.sendKeys(phone);
		this.cust_email.sendKeys(email);
		this.cust_city.sendKeys(city);
		this.cust_state.sendKeys(state);
		this.cust_zip.sendKeys(zip);
		WebDriverWait w=new WebDriverWait(DriverContext.driver,10);
		w.until(ExpectedConditions.elementToBeClickable(this.continue_to_payment_button));
		this.continue_to_payment_button.click();
		return getCurrentPage(CheckOut_PaymentPage.class);
	}
	public BasePage navigate_to_cart(){
		this.navigate_to_cart_button.click();
		return getCurrentPage(CartPage.class);
	}
}
