package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.CompareProductPageUI;
import payUIs.user.HomePageUI;
import payUIs.user.ShoppingCartPageUI;

public class CompareProductPageObject extends BasePage{
	private WebDriver driver;
	public CompareProductPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isInformationCompareProductDisplay(String productImageCompare1, String productNameCompare1,
			String productPriceCompare1) {
		waitForElementVisible(driver, CompareProductPageUI.INFORMATION_PROUDCT_BY_IMAGE_NAME_PRICE_PRODUCT,productImageCompare1,productNameCompare1,productPriceCompare1);
		return isElementDisplay(driver, CompareProductPageUI.INFORMATION_PROUDCT_BY_IMAGE_NAME_PRICE_PRODUCT,productImageCompare1,productNameCompare1,productPriceCompare1);
	}
	


}
