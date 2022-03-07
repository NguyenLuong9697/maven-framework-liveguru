package pageObjects.user;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import payUIs.user.DashBoardPageUI;

public class DashBoardPageObject extends BasePage{
	private WebDriver driver;
	public DashBoardPageObject(WebDriver driver) {
		this.driver=driver;
	}
	public boolean isSuccessMessageAfterCreateAccountDisplay() {
		waitForElementVisible(driver, DashBoardPageUI.SUCCESS_MESSAGE_AFTER_CREATE_ACCOUNT);
		return isElementDisplay(driver, DashBoardPageUI.SUCCESS_MESSAGE_AFTER_CREATE_ACCOUNT);
	}
	public boolean isCustomerInformationDisplay(String customerFullName, String customerEmail) {
		waitForElementVisible(driver, DashBoardPageUI.CUSTOMER_INFORMATION);
		String customerInfor = getTextElement(driver, DashBoardPageUI.CUSTOMER_INFORMATION);		
		return customerInfor.contains(customerFullName) && customerInfor.contains(customerEmail);
	}
	public boolean isDashboardHeaderTextDisplay() {
		waitForElementVisible(driver, DashBoardPageUI.DASHBOARD_HEADER_TEXT);
		return isElementDisplay(driver, DashBoardPageUI.DASHBOARD_HEADER_TEXT);
	}
	public boolean isDashboardHelloTextDisplay(String customerFullName) {
		waitForElementVisible(driver, DashBoardPageUI.DASHBOARD_HELLO_TEXT, customerFullName);
		return isElementDisplay(driver, DashBoardPageUI.DASHBOARD_HELLO_TEXT, customerFullName);
	}


}
