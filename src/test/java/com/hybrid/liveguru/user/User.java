package com.hybrid.liveguru.user;

import java.lang.reflect.Method;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import common.BaseTest;
import pageObjects.user.AdvanceSearchPageObject;
import pageObjects.user.CompareProductPageObject;
import pageObjects.user.DashBoardPageObject;
import pageObjects.user.HomePageObject;
import pageObjects.user.LoginPageObject;
import pageObjects.user.PageGeneratorManager;
import pageObjects.user.ProductDetailPageObject;
import pageObjects.user.ProductPageObject;
import pageObjects.user.ProductReviewPageObject;
import pageObjects.user.RegisterPageObject;
import pageObjects.user.ShoppingCartPageObject;
import pageObjects.user.WishListPageObject;
import reportConfig.ExtentTestManager;
import serverConfig.IServer;
import utilities.DataUtil;

public class User extends BaseTest {

	WebDriver driver;
	IServer server;
	DataUtil data;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	DashBoardPageObject dashboardPage;
	LoginPageObject loginPage;
	ProductPageObject productPage;
	ProductDetailPageObject productDetailPage;
	ShoppingCartPageObject shoppingCartPage;
	CompareProductPageObject compareProductPage;
	WishListPageObject wishListPage;
	ProductReviewPageObject productReviewPage;
	AdvanceSearchPageObject advanceSearchPage;
	String customerFirstName, customerLastName,customerFullName, customerEmail, customerPassword;
	String productName, productPriceInListProduct, productPriceInProductDetail;
	String productNameCompare1,productPriceCompare1,productImageCompare1, productNameCompare2,productPriceCompare2,productImageCompare2;
	String productNameWishlist, productImageWishList, productOldPriceWishList, productSpecialPriceWishList;
	String couponCode;
	@Parameters({ "environment", "server", "browser", "ipAddress", "portNumber", "osName", "osVersion" })
	@BeforeClass
	public void beforeClass(@Optional("local") String environment, @Optional("testing") String serverName,
			@Optional("chrome") String browserName, @Optional("localhost") String ipAddress,
			@Optional("4444") String portNumber, @Optional("windows") String osName, @Optional("10") String osVersion) {

		ConfigFactory.setProperty("server", serverName);
		server = ConfigFactory.create(IServer.class);
		System.out.println("browser Name:" + browserName);
		System.out.println("url:" + server.url());
		// ExtentTestManager.getTest().log(LogStatus.INFO,"Preconditon 01: Open browser
		// " + browserName + " and navigate to " + server.url());
		driver = getBrowserDriver(environment, server.url(), browserName, ipAddress, portNumber, osName, osVersion);
		homePage = PageGeneratorManager.getHomePageObject(driver);
		data = DataUtil.getData();
		//System.out.println("driver:" + driver.toString());

	}

	@Test
	public void TC_01_Register_Success_To_System(Method method) {

		ExtentTestManager.startTest(method.getName(), "TC_01_Register_Success_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 01:Click sub menu 'Register' in header");
		homePage.clickSubMenuByLabelName(driver, "Account", "Register");
		registerPage = PageGeneratorManager.getRegisterPageObject(driver);

		customerFirstName = "Henry";
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 02:Enter to 'First Name' textbox with value :"+ customerFirstName);
		registerPage.enterToTextboxByID(driver,"firstname", customerFirstName);
		
		customerLastName = "Tommy"+ randomNumber();
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 03:Enter to 'Last Name' textbox with value :"+ customerLastName);
		registerPage.enterToTextboxByID(driver,"lastname", customerLastName);

		customerFullName= customerFirstName +" "+ customerLastName;
		customerEmail = data.getEmailAddress();
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 04:Enter to 'Email Address' textbox with value :"+ customerEmail);
		registerPage.enterToTextboxByID(driver,"email_address", customerEmail);

		customerPassword= "123456";
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 05:Enter to 'Password' textbox with value :"+ customerPassword);
		registerPage.enterToTextboxByID(driver,"password", customerPassword);

		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 06:Enter to 'Confirm Password' textbox with value : " +customerPassword);
		registerPage.enterToTextboxByID(driver,"confirmation", customerPassword);

		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 07: Click button 'Register' ");
		registerPage.clickButtonByAttributeTitle(driver,"Register");
		if(driver.toString().contains("firefox")) {
			registerPage.acceptAlert(driver);
		}
		dashboardPage= PageGeneratorManager.getDashBoardPageObject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 08: Verify text 'Thank you for registering with Main Website Store' is displayed ");
		verifyTrue(dashboardPage.isSuccessMessageAfterCreateAccountDisplay());
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 09: Verify information of customer is displayed ");
		verifyTrue(dashboardPage.isCustomerInformationDisplay(customerFullName, customerEmail));
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 10: Step 01:Click sub menu 'Log out' in header");
		dashboardPage.clickSubMenuByLabelName(driver, "Account", "Log Out");
		homePage= PageGeneratorManager.getHomePageObject(driver);		
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_01_Register_Success_To_System- Step 11: Step 01:Verify text 'Default welcome msg!' is displayed");
		verifyTrue(homePage.isWelcomeMessageDefaultDisplay());
		ExtentTestManager.endTest();
	}

	@Test
	public void TC_02_Login_Success_To_System(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_02_Login_Success_To_System");
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_02_Login_Success_To_System- Step 01:Click sub menu 'Log In' in header");
		homePage.clickSubMenuByLabelName(driver, "Account", "Log In");
		loginPage = PageGeneratorManager.getLoginPageObject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_02_Login_Success_To_System- Step 02:Enter to textbox 'Email Address' with value: "+ customerEmail);
		loginPage.enterToTextboxByID(driver, "email", customerEmail);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_02_Login_Success_To_System- Step 03:Enter to textbox 'Password' with value: "+ customerPassword);
		loginPage.enterToTextboxByID(driver, "pass", customerPassword);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_02_Login_Success_To_System- Step 04: Click button 'LOGIN' ");
		loginPage.clickButtonByAttributeTitle(driver, "Login");		
		if(driver.toString().contains("firefox")) {
			loginPage.acceptAlert(driver);
		}
		dashboardPage= PageGeneratorManager.getDashBoardPageObject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_02_Login_Success_To_System- Step 05: Verify dashboard header text is displayed ");
		verifyTrue(dashboardPage.isDashboardHeaderTextDisplay());
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_02_Login_Success_To_System- Step 06:Verify hello message 'Hello, "+ customerFullName+"!'");
		verifyTrue(dashboardPage.isDashboardHelloTextDisplay(customerFullName));
		
		ExtentTestManager.endTest();
		
	}
	
	@Test
	public void TC_03_Compare_Price_In_List_Product_And_Detail_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_03_Compare_Price_In_List_Product_And_Detail_Product");
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_03_Compare_Price_In_List_Product_And_Detail_Product- Step 01 : Click menu 'Mobile' in navigation");
		dashboardPage.clickMenuInNavigationByLabel(driver,"Mobile");
		productPage = PageGeneratorManager.getProductPageObject(driver);
		
		productName="Sony Xperia";
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_03_Compare_Price_In_List_Product_And_Detail_Product- Step 02 : Get price of product: " +productName+" in list product page");
		productPriceInListProduct=productPage.getProductPriceByProductName( productName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_03_Compare_Price_In_List_Product_And_Detail_Product- Step 03 : Click on product: " +productName);
		productDetailPage=productPage.clickToProductByProductName(productName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_03_Compare_Price_In_List_Product_And_Detail_Product- Step 04 : get price of product: "+productName+" in product detail page" );
		productPriceInProductDetail=productDetailPage.getPriceOfProduct();
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_03_Compare_Price_In_List_Product_And_Detail_Product- Step 05 : Verify price of product: "+productName+" in list product page and product detail page are equal" );
		verifyEquals(productPriceInListProduct,productPriceInProductDetail);
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_04_Discount_Coupon(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_04_Discount_Coupon");
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_04_Discount_Coupon - Step 01 : click button 'Add to Cart'");
		productDetailPage.clickButtonAddToCart();
		if(driver.toString().contains("firefox")) {
			loginPage.acceptAlert(driver);
		}
		shoppingCartPage = PageGeneratorManager.getShoppingCartPageObject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_04_Discount_Coupon - Step 01 : verify product: "+productName+" is added into shopping cart");
		verifyTrue(shoppingCartPage.isSuccessMessageAfterAddProductIntoCartDisplay(productName));
	
		couponCode="GURU50";
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_04_Discount_Coupon - Step 01 : Enter coupon code: "+ couponCode);
		shoppingCartPage.enterToTextboxByID(driver, "coupon_code", couponCode);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_04_Discount_Coupon - Step 01 : Click button 'Apply'");
		shoppingCartPage.clickButtonByAttributeTitle(driver, "Apply");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_04_Discount_Coupon - Step 01 : verify 'Discount ("+ couponCode+")' is -$5.00" );
		verifyEquals(shoppingCartPage.getDiscountValue(couponCode), "-$5.00");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_04_Discount_Coupon - Step 01 : verify 'Grand Total' is $95.00" );
		verifyEquals(shoppingCartPage.getGrandTotal(), "$95.00");
		
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_05_Check_Maximum_Number_Of_Products_That_Can_Be_Purchased(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_05_Check_Maximum_Number_Of_Products_That_Can_Be_Purchased");
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_05_Check_Maximum_Number_Of_Products_That_Can_Be_Purchased - Step 01 : Enter to textbox 'Qty' with value: 501 at product: "+ productName);
		shoppingCartPage.enterToTextboxQtyByProductName(productName,"501");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_05_Check_Maximum_Number_Of_Products_That_Can_Be_Purchased - Step 02 : Click button 'Update' ");
		shoppingCartPage.clickButtonUpdateByProductName(productName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_05_Check_Maximum_Number_Of_Products_That_Can_Be_Purchased - Step 03 : Verify text 'Some of the products cannot be ordered in requested quantity.' is displayed and text '* The maximum quantity allowed for purchase is 500.' is displayed");
		verifyTrue(shoppingCartPage.isErrorMesageAfterAddMore500ProductsIntoCart(productName));
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_05_Check_Maximum_Number_Of_Products_That_Can_Be_Purchased - Step 04 : Click icon 'Delete' at product : "+productName);
		shoppingCartPage.clickIconRemoveByProductName(productName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_05_Check_Maximum_Number_Of_Products_That_Can_Be_Purchased - Step 05 : Verify shopping cart is empty");
		verifyTrue(shoppingCartPage.isShoppingCartEmpty());
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_06_Compare_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_06_Compare_Product");
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_06_Compare_Product - Step 01 : Click menu 'Mobile' in navigation");
		shoppingCartPage.clickMenuInNavigationByLabel(driver,"Mobile");
		productPage = PageGeneratorManager.getProductPageObject(driver);
		String parentID= driver.getWindowHandle();
		
		productNameCompare1= productName;
		productPriceCompare1="$100.00";
		productImageCompare1="xperia.jpg";
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_06_Compare_Product - Step 01 : Add prouduct: "+productNameCompare1+ "to compare");
		productPage.clickButtonAddToCompareByProductName(productNameCompare1);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_06_Compare_Product - Step 01 : Verify text 'The product "+productNameCompare1+" has been added to comparison list.");
		verifyTrue(productPage.isMessageAddProductToCompareDisplay(productNameCompare1));
		
		productNameCompare2="IPhone";
		productPriceCompare2="$500.00";
		productImageCompare2="iphone.png";
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_06_Compare_Product - Step 01 : Add prouduct: "+productNameCompare2+ "to compare");
		productPage.clickButtonAddToCompareByProductName(productNameCompare2);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_06_Compare_Product - Step 01 : Verify text 'The product "+productNameCompare2+" has been added to comparison list.");
		verifyTrue(productPage.isMessageAddProductToCompareDisplay(productNameCompare2));
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_06_Compare_Product - Step 01 : Click button 'Compare'");
		productPage.clickButtonByAttributeTitle(driver, "Compare");
		productPage.switchToWindowByTitle(driver,"Products Comparison List - Magento Commerce");
		compareProductPage= PageGeneratorManager.getCompareProductPageObject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Verify information of product: "+ productNameCompare1+" is displayed");
		verifyTrue(compareProductPage.isInformationCompareProductDisplay(productImageCompare1, productNameCompare1, productPriceCompare1));
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"Verify information of product: "+ productNameCompare2+" is displayed");
		verifyTrue(compareProductPage.isInformationCompareProductDisplay(productImageCompare2, productNameCompare2, productPriceCompare2));
		compareProductPage.closeTabWithoutParent(driver, parentID);
		productPage= PageGeneratorManager.getProductPageObject(driver);
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_07_WishList(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_07_WishList");
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_07_WishList - Step 01 : Click menu 'TV' in navigation");
		productPage.clickMenuInNavigationByLabel(driver,"TV");
		
		productNameWishlist="LG LCD";
		productImageWishList="lg.gif";
		productOldPriceWishList="$650.00";
		productSpecialPriceWishList="$615.00";
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_07_WishList - Step 01 : Add prouduct: "+productNameWishlist+ "to wishlist");
		productPage.clickButtonAddToWishlistByProductName(productNameWishlist);
		wishListPage = PageGeneratorManager.getWishListPageObject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_07_WishList - Step 02 : Verify text '"+ productNameCompare1+"has been added to your wishlist. Click here to continue shopping.'");
		verifyTrue(wishListPage.isMessageAddProductToWishListDisplay(productNameWishlist));
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_07_WishList - Step 03 : Click button 'Share Wishlist'");
		wishListPage.clickButtonByAttributeTitle(driver, "Share Wishlist");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_07_WishList - Step 04 : Enter to textarea 'Email address, seperated by commas' with value: auto_testing@gmail.net");
		wishListPage.enterToTextAreaByID(driver,"email_address","auto_testing@gmai.net");
		
				
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_07_WishList - Step 05 : Click button 'Share Wishlist'");
		wishListPage.clickButtonByAttributeTitle(driver, "Share Wishlist");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_07_WishList - Step 06 : Verify message 'Your Wishlist has been shared.' is displayed");
		verifyTrue(wishListPage.isSuccessMessageShareWishListDisplay());
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_07_WishList - Step 07 : Verify in my wishlist has only 1 product");
		verifyEquals(wishListPage.getNumberProductInMyWishList(), 1);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_07_WishList - Step 08 : Verify product: "+productNameWishlist +"is displayed in my wishlist");
		verifyTrue(wishListPage.isProductDisplayInMyWishList(productImageWishList, productNameWishlist, productOldPriceWishList, productSpecialPriceWishList));
		ExtentTestManager.endTest();
	
	}
	
	@Test
	public void TC_08_Add_Your_Review(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_08_Add_Your_Review");
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 01 : Click menu 'TV' in navigation");		
		wishListPage.clickMenuInNavigationByLabel(driver,"TV");
		
		productName="Samsung LCD";		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 02 : Click on product: " +productName);
		productDetailPage=productPage.clickToProductByProductName(productName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 03 : Click on link 'Add Your Review'" );
		productDetailPage.clickLinkByLabel(driver,"Add Your Review");
		productReviewPage = PageGeneratorManager.getProductReviewPageObject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 04 :Remove data in textbox 'What's your nickname'" );
		productReviewPage.enterToTextboxByID(driver, "nickname_field", "");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 05: Click button 'Submit Review'" );
		productReviewPage.clickButtonByAttributeTitle(driver,"Submit Review");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 06: Verify error message is displayed" );
		verifyTrue(productReviewPage.isErrorMessagesDisplay());
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 07 :Select quanlity" );		
		productReviewPage.clickRadioButtonByID(driver,"Quality 1_5");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 08 :Select quanlity rating 5 is selected" );		
		verifyTrue(productReviewPage.isRadioButtonSelectedByID(driver,"Quality 1_5"));
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 09 :Enter to textbox 'Let us know your thoughts'" );
		productReviewPage.enterToTextAreaByID(driver, "review_field", "Good");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 10 :Enter to textbox 'Summary your review'" );
		productReviewPage.enterToTextboxByID(driver, "summary_field", "Good");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 11 :Enter to textbox 'What's your nickname'" );
		productReviewPage.enterToTextboxByID(driver, "nickname_field", customerFullName);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 12: Click button 'Submit Review'" );
		productReviewPage.clickButtonByAttributeTitle(driver,"Submit Review");
		if(driver.toString().contains("firefox")) {
			loginPage.acceptAlert(driver);
		}
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_08_Add_Your_Review - Step 13: Verify text 'Your review has been accepted for moderation.' is displayed" );
		verifyTrue(productReviewPage.isReviewMessageDisplay());
		
		ExtentTestManager.endTest();
	}
	
	@Test
	public void TC_09_Purchase_Product(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_09_Purchase_Product");
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_09_Purchase_Product - Step 01 : Click link 'Go to Wishlist'");	
		productReviewPage.clickLinkByLabel(driver,"Go to Wishlist");			
		wishListPage =PageGeneratorManager.getWishListPageObject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_09_Purchase_Product - Step 01 : Click button 'Add to cart' at row contains product: "+productNameWishlist);
		wishListPage.clickButtonAddToCartByProductName(productNameWishlist);
//		if(driver.toString().contains("firefox")) {
//			loginPage.acceptAlert(driver);
//		}
		shoppingCartPage = PageGeneratorManager.getShoppingCartPageObject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_04_Discount_Coupon - Step 01 : verify product: "+productNameWishlist+" is added into shopping cart");
		verifyTrue(shoppingCartPage.isSuccessMessageAfterAddProductIntoCartDisplay(productNameWishlist));
	
		ExtentTestManager.endTest();
		
	}
	
	@Test
	public void TC_10_Search(Method method) {
		ExtentTestManager.startTest(method.getName(), "TC_10_Search");
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 01 : Navigate to url 'http://live.techpanda.org/' ");	
		shoppingCartPage.openUrl(driver, "http://live.techpanda.org/");
		homePage = PageGeneratorManager.getHomePageObject(driver);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 02 : Click link 'Advanced Search' in footer ");
		homePage.clickFooterLinkByLabel(driver,"Advanced Search");
		advanceSearchPage = PageGeneratorManager.getAdvanceSearchPageObject(driver);
		sleepInSecond(5);
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 02 : Enter data in textbox Price with value 100");
		advanceSearchPage.enterToTextboxByID(driver, "price", "100");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 02 : Enter data in textbox Price to with value 150");
		advanceSearchPage.enterToTextboxByID(driver, "price_to", "150");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 02 : Click button 'Search'");
		advanceSearchPage.clickSearchButton();
		
		if(driver.toString().contains("firefox")) {
			advanceSearchPage.acceptAlert(driver);
		}
			
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 02 : Verify each product from result search has price is range 100 -150 ");
		verifyTrue(advanceSearchPage.isPriceProductRange("100", "150"));	
		
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 02 : Click link 'Advanced Search' in footer ");
		advanceSearchPage.clickFooterLinkByLabel(driver,"Advanced Search");
		
		sleepInSecond(5);
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 02 : Enter data in textbox Price with value 151");
		advanceSearchPage.enterToTextboxByID(driver, "price", "151");
		
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 02 : Enter data in textbox Price to with value 1000");
		advanceSearchPage.enterToTextboxByID(driver, "price_to", "1000");
		
	
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 02 : Click button 'Search'");
		advanceSearchPage.clickSearchButton();
		
		if(driver.toString().contains("firefox")) {
			advanceSearchPage.acceptAlert(driver);
		}
			
		ExtentTestManager.getTest().log(LogStatus.INFO,"TC_10_Search- Step 02 : Verify each product from result search has price is range 151 -1000 ");
		verifyTrue(advanceSearchPage.isPriceProductRange("151", "1000"));
		
		ExtentTestManager.endTest();
		
	}
	@Parameters({ "browser" })
	@AfterClass(alwaysRun = true)
	public void afterClass(String browserName) {
		ExtentTestManager.getTest().log(LogStatus.INFO, "Postcondition: Close the browser");
		cleanBrowserAndDriver();
	}

}
