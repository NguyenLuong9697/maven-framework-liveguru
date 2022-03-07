package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.HomePageUI;
import payUIs.user.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BasePage{
	private WebDriver driver;
	public ShoppingCartPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isSuccessMessageAfterAddProductIntoCartDisplay(String productName) {
		waitForElementVisible(driver, ShoppingCartPageUI.SUCCESS_MESSAGE_AFTER_ADD_PRODUCT_INTO_CART,productName);
		return isElementDisplay(driver,ShoppingCartPageUI.SUCCESS_MESSAGE_AFTER_ADD_PRODUCT_INTO_CART, productName);
	}
	public String getDiscountValue(String couponCode) {
		waitForElementVisible(driver, ShoppingCartPageUI.COUPON_CODE,couponCode);
		return getTextElement(driver,ShoppingCartPageUI.COUPON_CODE, couponCode);
	}
	public String getGrandTotal() {
		waitForElementVisible(driver, ShoppingCartPageUI.GRAND_TOTAL);
		return getTextElement(driver,ShoppingCartPageUI.GRAND_TOTAL);
	}
	public void enterToTextboxQtyByProductName(String productName, String qty) {	
		waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_TEXTBOX_QTY_BY_PRODUCT_NAME,productName);
		sendKeyToElement(driver,ShoppingCartPageUI.DYNAMIC_TEXTBOX_QTY_BY_PRODUCT_NAME,qty, productName);
	}
	public void clickButtonUpdateByProductName(String productName) {
		waitForElementClickable(driver, ShoppingCartPageUI.DYNAMIC_BUTTON_UPDATE_BY_PRODUCT_NAME,productName);
		clickToElement(driver, ShoppingCartPageUI.DYNAMIC_BUTTON_UPDATE_BY_PRODUCT_NAME,productName);
	}
	public boolean isErrorMesageAfterAddMore500ProductsIntoCart(String productName) {
		waitForElementVisible(driver, ShoppingCartPageUI.ERROR_MESSAGE_AFTER_ADD_MORE_500_PRODUCT_INTO_CART);
		waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_ERROR_MESSAGE_AFTER_ADD_MORE_500_PRODUCT_INTO_CART_BY_PRODUCT_NAME,productName);
		return isElementDisplay(driver,ShoppingCartPageUI.ERROR_MESSAGE_AFTER_ADD_MORE_500_PRODUCT_INTO_CART) && isElementDisplay(driver,ShoppingCartPageUI.DYNAMIC_ERROR_MESSAGE_AFTER_ADD_MORE_500_PRODUCT_INTO_CART_BY_PRODUCT_NAME,productName);
		
	}
	public void clickIconRemoveByProductName(String productName) {
		waitForElementClickable(driver, ShoppingCartPageUI.DYNAMIC_ICON_REMOVE_BY_PRODUCT_NAME,productName);
		clickToElement(driver, ShoppingCartPageUI.DYNAMIC_ICON_REMOVE_BY_PRODUCT_NAME,productName);
		
	}
	public boolean isShoppingCartEmpty() {		
		waitForElementVisible(driver, ShoppingCartPageUI.TEXT_SHOPPING_CART_EMPTY);
		return isElementDisplay(driver,ShoppingCartPageUI.TEXT_SHOPPING_CART_EMPTY);
	}
	


}
