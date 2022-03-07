package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.HomePageUI;
import payUIs.user.ProductPageUI;
import payUIs.user.UserBasePageUI;

public class ProductPageObject extends BasePage{
	private WebDriver driver;
	public ProductPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public ProductDetailPageObject clickToProductByProductName(String productName) {
		waitForElementClickable(driver, ProductPageUI.DYNAMIC_PRODUCT_BY_PRODUCT_NAME, productName);
		clickToElement(driver, ProductPageUI.DYNAMIC_PRODUCT_BY_PRODUCT_NAME, productName);
		return PageGeneratorManager.getProductDetailPageObject(driver);
	}

	public String getProductPriceByProductName(String productName) {
		waitForElementVisible(driver, ProductPageUI.DYNAMIC_PRODUCT_PRICE_BY_PRODUCT_NAME,productName);
		return getTextElement(driver, ProductPageUI.DYNAMIC_PRODUCT_PRICE_BY_PRODUCT_NAME,productName);
	}
	public void clickButtonAddToCompareByProductName(String productNameCompare1) {
		waitForElementClickable(driver, ProductPageUI.LINK_ADD_TO_COMPARE_BY_PRODUCT_NAME, productNameCompare1);
		clickToElement(driver, ProductPageUI.LINK_ADD_TO_COMPARE_BY_PRODUCT_NAME, productNameCompare1);
		
	}
	public boolean isMessageAddProductToCompareDisplay(String productNameCompare1) {
		waitForElementVisible(driver, ProductPageUI.SUCCESS_MESAGE_ADD_TO_COMPARE_BY_PRODUCT_NAME,productNameCompare1);
		return isElementDisplay(driver, ProductPageUI.SUCCESS_MESAGE_ADD_TO_COMPARE_BY_PRODUCT_NAME,productNameCompare1);
	}
	public void clickButtonAddToWishlistByProductName(String productNameWishlist) {
		waitForElementClickable(driver, ProductPageUI.LINK_ADD_TO_WISHLIST_BY_PRODUCT_NAME, productNameWishlist);
		clickToElement(driver, ProductPageUI.LINK_ADD_TO_WISHLIST_BY_PRODUCT_NAME, productNameWishlist);
		
	}
	
}
