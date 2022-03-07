package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.HomePageUI;
import payUIs.user.ProductReviewPageUI;

public class ProductReviewPageObject extends BasePage {
	private WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isErrorMessagesDisplay() {
		waitForElementVisible(driver, ProductReviewPageUI.ERROR_MESSAGE_IN_TEXTBOX_THOUGHTS);
		boolean isErrorMessageAtTextboxThought = isElementDisplay(driver,
				ProductReviewPageUI.ERROR_MESSAGE_IN_TEXTBOX_THOUGHTS);
		waitForElementVisible(driver, ProductReviewPageUI.ERROR_MESSAGE_IN_TEXTBOX_REVIEW);
		boolean isErrorMessageAtTextboxReview = isElementDisplay(driver,
				ProductReviewPageUI.ERROR_MESSAGE_IN_TEXTBOX_REVIEW);
		waitForElementVisible(driver, ProductReviewPageUI.ERROR_MESSAGE_IN_TEXTBOX_NICKNAME);
		boolean isErrorMessageAtTextboxNickname = isElementDisplay(driver,
				ProductReviewPageUI.ERROR_MESSAGE_IN_TEXTBOX_NICKNAME);
		
		return isErrorMessageAtTextboxThought && isErrorMessageAtTextboxReview && isErrorMessageAtTextboxNickname;
	}

	public boolean isReviewMessageDisplay() {
		waitForElementVisible(driver, ProductReviewPageUI.REVIEW_MESSAGE);
		return isElementDisplay(driver, ProductReviewPageUI.REVIEW_MESSAGE);
	}




}
