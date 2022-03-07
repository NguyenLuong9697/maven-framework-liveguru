package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.HomePageUI;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isWelcomeMessageDefaultDisplay() {
		waitForElementVisible(driver, HomePageUI.WELCOME_MESSAGE_DEFAULT);
		return isElementDisplay(driver, HomePageUI.WELCOME_MESSAGE_DEFAULT);
	}

}
