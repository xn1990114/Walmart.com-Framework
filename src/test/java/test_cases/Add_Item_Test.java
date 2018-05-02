package test_cases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.*;
import utility.ExcelUtil;

public class Add_Item_Test extends BaseTest{
	//@Test(dataProvider="add_item_data_without_signIn")
	public void add_item_no_sign_in_invalidpayment(String itemName,String shippingOption,String firstName,String lastName,String st,String phone,String email,String city,String state,String zip,String cardNum,String expMM,String expYY,String cvv) throws Exception{
		assertTrue(!currentPage.as(HomePage.class).is_signed_in());
		currentPage=currentPage.as(HomePage.class).search(itemName);
		currentPage=currentPage.as(SearchResultPage.class).go_to_Item(0);
		assertTrue(currentPage.as(ItemPage.class).is_item_info_page());
		currentPage=currentPage.as(ItemPage.class).enter_qty(3);
		currentPage=currentPage.as(ItemPage.class).add_item_and_navigate_to_checkout();
		assertTrue(currentPage.as(CheckOutSignInPage.class).isCheckoutWithSignInPage());
		currentPage=currentPage.as(CheckOutSignInPage.class).continue_without_signin();
		currentPage=currentPage.as(CheckOut_FullfillmentPage.class).select_kth_shipping_option(Integer.parseInt(shippingOption));
		currentPage=currentPage.as(CheckOut_ShippingAddressPage.class).fill_cust_info(firstName, lastName, st, phone, email, city, state, zip);
		currentPage=currentPage.as(CheckOut_PaymentPage.class).fill_credit_card_info(cardNum, expMM, expYY, cvv);
		assertTrue(currentPage.as(OrderSummaryPage.class).isSummaryPage());
		currentPage=currentPage.as(OrderSummaryPage.class).complateTransaction_invlvalidPayment();
		assertTrue(currentPage.as(CheckOut_PaymentPage.class).isCheckout_paymentPage());
	}
	@Test(dataProvider="add_item_data_with_signIn")
	public void add_item_with_sign_in(String userName,String password,String itemName1,String itemName2,String shippingOption,String firstName,String lastName,String st,String phone,String email,String city,String state,String zip,String cardNum,String expMM,String expYY,String cvv) throws Exception{
		assertTrue(!currentPage.as(HomePage.class).is_signed_in());
		currentPage=currentPage.as(HomePage.class).navigate_to_signInPage();
		currentPage=currentPage.as(SignInPage.class).signIn(userName, password);
		assertTrue(currentPage.as(HomePage.class).is_signed_in());
		currentPage=currentPage.as(HomePage.class).search(itemName1);
		currentPage=currentPage.as(SearchResultPage.class).go_to_Item(0);
		assertTrue(currentPage.as(ItemPage.class).is_item_info_page());
		currentPage=currentPage.as(ItemPage.class).enter_qty(3);
		currentPage=currentPage.as(ItemPage.class).add_item_and_stay();
		currentPage=currentPage.as(ItemPage.class).search(itemName2);
		currentPage=currentPage.as(SearchResultPage.class).go_to_Item(0);
		assertTrue(currentPage.as(ItemPage.class).is_item_info_page());
		currentPage=currentPage.as(ItemPage.class).add_item_and_navigate_to_cart();
		currentPage=currentPage.as(CartPage.class).remove_kth_item(2);
		currentPage=currentPage.as(CartPage.class).navigate_to_checkout();
		assertTrue(currentPage.as(CheckOut_FullfillmentPage.class).isCheckout_fullfillment_page());
	}
	@DataProvider(name="add_item_data_with_signIn")
	public Object[][] get_item_and_login_data(){
		ExcelUtil.setSheet("add_item_data_with_signin");
		int colCount=ExcelUtil.getColCount();
		Object[][] res=new Object[1][colCount];
		for(int i=0;i<colCount;i++){
			res[0][i]=ExcelUtil.readCell(1, i);
		}
		return res;
	}
	@DataProvider(name="add_item_data_without_signIn")
	public Object[][] get_item_and_cust_data(){
		ExcelUtil.setSheet("add_item_without_signin");
		int colCount=ExcelUtil.getColCount();
		Object[][] res=new Object[1][colCount];
		for(int i=0;i<colCount;i++){
			res[0][i]=ExcelUtil.readCell(1, i);
		}
		return res;
	}
}
