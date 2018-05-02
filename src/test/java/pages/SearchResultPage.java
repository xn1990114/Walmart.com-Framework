package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.*;

import base.BasePage;

public class SearchResultPage extends BasePage{
	@FindBy(how=How.CLASS_NAME,using="product-title-link")
	public List<WebElement> result_list;
	@FindBy(how=How.XPATH,using="//*[@id='global-search-input']")
	public WebElement search_textbox;
	@FindBy(how=How.XPATH,using="//*[@id='global-search-form']/div/div[3]/button")
	public WebElement search_button;
	
	public BasePage go_to_Item(int index){
		this.result_list.get(index).click();
		return getCurrentPage(ItemPage.class);
	}
	public BasePage search(String item_name){
		this.search_textbox.sendKeys(item_name);
		this.search_button.click();
		return getCurrentPage(SearchResultPage.class);
	}
}
