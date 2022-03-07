package payUIs.user;

public class WishListPageUI {
	public static final String SUCCESS_MESAGE_ADD_TO_WISHLIST_BY_PRODUCT_NAME="//li[@class='success-msg']//span[contains(string(),'%s has been added to your wishlist. Click here to continue shopping.')]";
	public static final String SUCCESS_MESSAGE_SHARE_WISHLIST="//span[text()='Your Wishlist has been shared.']";
	public static final String INFO_PRODUCT_IN_MY_WISHLIST_BY_IMG_NAME_OLDPRICE_SPECIALPRICE="//img[contains(@src,'%s')]/parent::a/parent::td/following-sibling::td//a[text()='%s']/parent::h3/parent::td/following-sibling::td//span[contains(text(),'%s')]/parent::p/following-sibling::p//span[contains(text(),'%s')]";
	public static final String NUMBER_PRODUCT_IN_MY_WISHLIST="//table[@id='wishlist-table']//tbody//tr";
	public static final String DYNAMIC_ADD_TO_CART_BY_PRODUCT_NAME="//a[text()='%s']/parent::h3/parent::td/following-sibling::td//button[@title='Add to Cart']";

}
