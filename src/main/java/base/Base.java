package base;

import org.openqa.selenium.support.PageFactory;

public class Base {
	public static BasePage currentPage;
	public <Tpage extends BasePage> BasePage getCurrentPage(Class<Tpage> page){
		return PageFactory.initElements(DriverContext.driver,page);
	}
}
