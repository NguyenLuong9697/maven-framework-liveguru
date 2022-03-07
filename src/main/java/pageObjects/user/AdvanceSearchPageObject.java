package pageObjects.user;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.BasePage;
import payUIs.user.AdvanceSearchPageUI;
import payUIs.user.DashBoardPageUI;

public class AdvanceSearchPageObject extends BasePage{
	private WebDriver driver;
	public AdvanceSearchPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isPriceProductRange(String price, String priceTo) {
		boolean check = true;
		double priceMin= Double.parseDouble(price);
		double priceMax= Double.parseDouble(priceTo) ;
			
		waitForAllElementsVisible(driver, AdvanceSearchPageUI.PRODUCT_AFTER_SEARCH);
		List<WebElement> products= getListWebElements(driver, AdvanceSearchPageUI.PRODUCT_AFTER_SEARCH);
		for (WebElement webElement : products) {
			double productPrice= Double.parseDouble(webElement.getText().replace("$", ""));
			if(productPrice > priceMax || productPrice< priceMin) {
				check=false;
				break;
			}
		}
		return check;
	}
	public void clickSearchButton() {
		waitForElementClickable(driver,AdvanceSearchPageUI.SEARCH_BUTTON_IN_FORM_SEARCH);
		clickToElement(driver, AdvanceSearchPageUI.SEARCH_BUTTON_IN_FORM_SEARCH);
	}

	

}
