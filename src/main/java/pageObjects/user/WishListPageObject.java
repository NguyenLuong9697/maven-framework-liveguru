package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.WishListPageUI;

public class WishListPageObject extends BasePage{
	private WebDriver driver;
	public WishListPageObject(WebDriver driver) {
		this.driver=driver;
	}

	public boolean isMessageAddProductToWishListDisplay(String productNameWishlist) {
		waitForElementVisible(driver, WishListPageUI.SUCCESS_MESAGE_ADD_TO_WISHLIST_BY_PRODUCT_NAME,productNameWishlist);
		return isElementDisplay(driver, WishListPageUI.SUCCESS_MESAGE_ADD_TO_WISHLIST_BY_PRODUCT_NAME,productNameWishlist);
	}

	public boolean isSuccessMessageShareWishListDisplay() {
		waitForElementVisible(driver, WishListPageUI.SUCCESS_MESSAGE_SHARE_WISHLIST);
		return isElementDisplay(driver, WishListPageUI.SUCCESS_MESSAGE_SHARE_WISHLIST);
	}

	public boolean isProductDisplayInMyWishList(String productImageWishList, String productNameWishlist,
			String productOldPriceWishList, String productSpecialPriceWishList) {
		waitForElementVisible(driver, WishListPageUI.INFO_PRODUCT_IN_MY_WISHLIST_BY_IMG_NAME_OLDPRICE_SPECIALPRICE,productImageWishList,productNameWishlist,productOldPriceWishList,productSpecialPriceWishList);
		return isElementDisplay(driver, WishListPageUI.INFO_PRODUCT_IN_MY_WISHLIST_BY_IMG_NAME_OLDPRICE_SPECIALPRICE,productImageWishList,productNameWishlist,productOldPriceWishList,productSpecialPriceWishList);
		
	}

	public int getNumberProductInMyWishList() {		
		return getElementSize(driver, WishListPageUI.NUMBER_PRODUCT_IN_MY_WISHLIST);
	}

	public void clickButtonAddToCartByProductName(String productNameWishlist) {
		waitForElementClickable(driver, WishListPageUI.DYNAMIC_ADD_TO_CART_BY_PRODUCT_NAME,productNameWishlist);
		clickToElement(driver,WishListPageUI.DYNAMIC_ADD_TO_CART_BY_PRODUCT_NAME, productNameWishlist);
	}



}
