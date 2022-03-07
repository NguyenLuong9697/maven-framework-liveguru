package payUIs.user;

public class ShoppingCartPageUI {
	public static final String SUCCESS_MESSAGE_AFTER_ADD_PRODUCT_INTO_CART="//li[@class='success-msg']//span[text()='%s was added to your shopping cart.']";
	public static final String COUPON_CODE="//td[contains(text(),'Discount (%s)')]/following-sibling::td/span";
	public static final String GRAND_TOTAL="//strong[text()='Grand Total']/parent::td/following-sibling::td//span";
	public static final String DYNAMIC_TEXTBOX_QTY_BY_PRODUCT_NAME="//a[text()='%s']/parent::h2[@class='product-name']/parent::td/following-sibling::td[@class='product-cart-actions']/input[@title='Qty']";
	public static final String DYNAMIC_BUTTON_UPDATE_BY_PRODUCT_NAME="//a[text()='%s']/parent::h2[@class='product-name']/parent::td/following-sibling::td[@class='product-cart-actions']/button[@title='Update']";
	public static final String ERROR_MESSAGE_AFTER_ADD_MORE_500_PRODUCT_INTO_CART="//li[@class='error-msg']//span[text()='Some of the products cannot be ordered in requested quantity.']";
	public static final String DYNAMIC_ERROR_MESSAGE_AFTER_ADD_MORE_500_PRODUCT_INTO_CART_BY_PRODUCT_NAME="//a[text()='%s']/parent::h2/following-sibling::p[contains(text(),'* The maximum quantity allowed for purchase is 500.')]";
	public static final String DYNAMIC_ICON_REMOVE_BY_PRODUCT_NAME="//a[text()='%s']/parent::h2[@class='product-name']/parent::td/following-sibling::td[@class='a-center product-cart-remove last']/a[@title='Remove Item']";
	public static final String TEXT_SHOPPING_CART_EMPTY="//h1[text()='Shopping Cart is Empty']/parent::div/following-sibling::div/p[text()='You have no items in your shopping cart.']";

	
}
