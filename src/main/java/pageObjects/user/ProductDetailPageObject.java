package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.HomePageUI;
import payUIs.user.ProductDetailPageUI;
import payUIs.user.ProductPageUI;

public class ProductDetailPageObject extends BasePage{
	private WebDriver driver;
	public ProductDetailPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public String getPriceOfProduct() {
		waitForElementVisible(driver, ProductDetailPageUI.PRICE_OF_PRODUCT);
		return getTextElement(driver, ProductDetailPageUI.PRICE_OF_PRODUCT);
		
	}
	public void clickButtonAddToCart() {
		waitForElementClickable(driver, ProductDetailPageUI.BUTTON_ADD_TO_CART);
		clickToElement(driver, ProductDetailPageUI.BUTTON_ADD_TO_CART);		
	
	}



}
