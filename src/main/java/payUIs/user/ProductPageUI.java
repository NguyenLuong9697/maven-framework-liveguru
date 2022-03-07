package payUIs.user;

public class ProductPageUI {
	public static final String DYNAMIC_PRODUCT_BY_PRODUCT_NAME="//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_PRICE_BY_PRODUCT_NAME="//a[text()='%s']/parent::h2/following-sibling::div[@class='price-box']//span[@class='price']";
	public static final String LINK_ADD_TO_COMPARE_BY_PRODUCT_NAME="//a[text()='%s']/parent::h2/following-sibling::div//a[text()='Add to Compare']";
	public static final String SUCCESS_MESAGE_ADD_TO_COMPARE_BY_PRODUCT_NAME="//span[text()='The product %s has been added to comparison list.']";
	public static final String LINK_ADD_TO_WISHLIST_BY_PRODUCT_NAME="//a[text()='%s']/parent::h2/following-sibling::div//a[text()='Add to Wishlist']";

}

