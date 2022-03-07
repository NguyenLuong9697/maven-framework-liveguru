package factoryEnvironment;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import browserList.BROWSER;
import common.GlobalConstants;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.FirefoxDriverManager;

public class SauceLabFactory {
	private WebDriver driver;
	private String browserName;
	private String osName;
		
	public SauceLabFactory(String browserName, String osName) {
		this.browserName = browserName;
		this.osName = osName;
	}


	public WebDriver createDriver() {
		DesiredCapabilities capability =null;
		capability.setCapability("platformName", osName);
		capability.setCapability("browserName", browserName);
		capability.setCapability("browser_version", "latest");
		
		capability.setCapability("name", "Run on "+ osName + " | " + browserName);
		try {
			driver = new RemoteWebDriver(new URL(GlobalConstants.SAUCE_LAB_URL), capability);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
	

}
