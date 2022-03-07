package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.HomePageUI;

public class LoginPageObject extends BasePage{
	private WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver=driver;
	}


}
