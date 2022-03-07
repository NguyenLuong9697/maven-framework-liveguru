package pageObjects.user;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	private PageGeneratorManager() {

	}

	public static HomePageObject getHomePageObject(WebDriver driver) {

		return new HomePageObject(driver);
	}
	public static RegisterPageObject getRegisterPageObject(WebDriver driver) {

		return new RegisterPageObject(driver);
	}
	public static DashBoardPageObject getDashBoardPageObject(WebDriver driver) {

		return new  DashBoardPageObject(driver);
	}	
	public static LoginPageObject getLoginPageObject(WebDriver driver) {

		return new  LoginPageObject(driver);
	}
	
	public static ProductPageObject getProductPageObject(WebDriver driver) {

		return new ProductPageObject(driver);
	}
	
	public static ProductDetailPageObject getProductDetailPageObject(WebDriver driver) {

		return new ProductDetailPageObject(driver);
	}
	
	
	public static ShoppingCartPageObject getShoppingCartPageObject(WebDriver driver) {

		return new ShoppingCartPageObject(driver);
	}
	
	public static CompareProductPageObject getCompareProductPageObject(WebDriver driver) {

		return new CompareProductPageObject(driver);
	}	
	public static WishListPageObject getWishListPageObject(WebDriver driver) {

		return new WishListPageObject(driver);
	}
	
	public static ProductReviewPageObject getProductReviewPageObject(WebDriver driver) {

		return new ProductReviewPageObject(driver);
	}
	
	
	public static AdvanceSearchPageObject getAdvanceSearchPageObject(WebDriver driver) {

		return new AdvanceSearchPageObject(driver);
	}
}
