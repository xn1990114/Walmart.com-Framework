package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import base.DriverContext;

public class CartPage extends BasePage{
	@FindBy(how=How.XPATH,using="(//button[@data-automation-id='cart-pos-proceed-to-checkout'])[2]")
	public WebElement checkout_button;
	@FindBy(how=How.XPATH,using="//a[@data-automation-id='cart-item-name']")
	public List<WebElement> item_list;
	@FindBy(how=How.XPATH,using="//div[@class='arrange arrange-shrink pull-right pos-relative cart-quantity-s']/div/div/div/label/div/select")
	public List<Select> qty_list;
	@FindBy(how=How.XPATH,using="//button[@data-automation-id='cart-item-remove']")
	public List<WebElement> remove_buttons;
	@FindBy(how=How.XPATH,using="//*[@id='global-search-input']")
	public WebElement search_textbox;
	@FindBy(how=How.XPATH,using="//*[@id='global-search-form']/div/div[3]/button")
	public WebElement search_button;
	
	public BasePage search(String item_name){
		this.search_textbox.sendKeys(item_name);
		this.search_button.click();
		return getCurrentPage(SearchResultPage.class);
	}
	
	public boolean confirm_items(List<String> exp_items,List<String> exp_qty){
		if(exp_items.size()!=this.item_list.size()){
			return false;
		}
		for(int i=0;i<this.item_list.size();i++){
			if(!item_list.get(i).getText().equals(exp_items.get(exp_items.size()-1-i))){
				return false;
			}
			if(!qty_list.get(i).getFirstSelectedOption().getText().equals(exp_qty.get(exp_qty.size()-1-i))){
				return false;
			}
		}
		return true;
	}
	public BasePage navigate_to_checkout() throws InterruptedException{
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) DriverContext.driver;
		js.executeScript("window.scrollBy(0,-5000)");
		this.checkout_button.click();
		return getCurrentPage(CheckOut_FullfillmentPage.class);
	}
	public BasePage remove_kth_item(int index) throws Exception{
		if(index<1||index>this.remove_buttons.size()){
			throw new Exception("index out of remove button boundary");
		}
		this.remove_buttons.get(index-1).click();
		return getCurrentPage(CartPage.class);
	}
}
