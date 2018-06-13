package src.test;

import org.testng.annotations.*;
import src.com.CheckOutAddress;
import src.com.CheckOutPayment;
import src.com.CheckOutShipping;
import src.com.CheckOutSummary;
import src.com.HomePage;
import src.com.LoginPage;
import src.com.ProductDetailPage;
import src.com.ReadPropertiesFile;
import src.com.UserAccountPage;
import src.com.WebDriverPage;
import org.testng.annotations.BeforeSuite;
import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;

/**
 * This is the TestNG Test Suite class. It contains the various Test Cases that need to be executed.
 */

public class TestNGTestSuite {
	private final String LoginEmail = "LoginEmail", LoginPassword = "LoginPassword", IncorrectEmail = "IncorrectEmail",
			IncorrectPassword = "IncorrectPassword", IncorrectLoginErrorMessage = "IncorrectLoginErrorMessage",
			IncorrectPasswordErrorMessage = "IncorrectPasswordErrorMessage", UserName = "UserName", 
					SuccessMessage = "SuccessMessage";
	private final String keyBrowser = "Browser", keyAppURL = "ApplicationURL";
	private String browser, driverPath, appURL;
	WebDriverPage objWDP;
	ReadPropertiesFile objReadProp;

	public String getAppURL() {
		return appURL;
	}

	public void setAppURL(String appURL) {
		this.appURL = appURL;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getDriverPath() {
		return driverPath;
	}

	public void setDriverPath(String driverPath) {
		this.driverPath = driverPath;
	}

	/**
	 * Instantiation of webdriver and properties file
	 */

	@BeforeMethod
	public void beforeTest() {
		objWDP = new WebDriverPage(getBrowser(), getAppURL());
		objReadProp = new ReadPropertiesFile();
	}

	/**
	 * This method is used to test Login functionality against invalid input
	 */

	@Test
	public void FailLogin() {
		LoginPage objLP = new LoginPage(objWDP.getWebDriver());
		//Authenticate login - incorrect password
		objLP.enterLoginEmail(objReadProp.getValue(LoginEmail));
		objLP.enterLoginPassword(objReadProp.getValue(IncorrectPassword));
		objLP.clickBtnSignIn();
		assertEquals(objLP.showErrorMessage(), objReadProp.getValue(IncorrectPasswordErrorMessage));
		//Authenticate login - incorrect email
		objWDP.setWebDriver(objLP.getWebDriver());
		objLP = new LoginPage(objWDP.getWebDriver());
		objLP.clearEmailField();
		objLP.enterLoginEmail(objReadProp.getValue(IncorrectEmail));
		objLP.clearPasswordField();
		objLP.enterLoginPassword(objReadProp.getValue(LoginPassword));
		objLP.clickBtnSignIn();
		assertEquals(objLP.showErrorMessage(), objReadProp.getValue(IncorrectLoginErrorMessage));
	}

	
	/**
	 * This method is used to test Logout functionality
	 */
	@Test
	public void LogOut() {
		LoginPage objLP = new LoginPage(objWDP.getWebDriver());
		objLP.enterLoginEmail(objReadProp.getValue(LoginEmail));
		objLP.enterLoginPassword(objReadProp.getValue(LoginPassword));
		objLP.clickBtnSignIn();
		objWDP.setWebDriver(objLP.getWebDriver());
		UserAccountPage objUAP = new UserAccountPage(objWDP.getWebDriver());
		assertEquals(objUAP.userName(), objReadProp.getValue(UserName));
		objUAP.clickSignOut();
		assertEquals(objUAP.getDriver().getTitle(), "Login - My Store");
	}

	/**
	 * This method is used to test product purchase functionality
	 */

	@Test
	public void PurchaseProduct() {
		LoginPage objLP = new LoginPage(objWDP.getWebDriver());
		//Perform sign-in
		objLP.enterLoginEmail(objReadProp.getValue(LoginEmail));
		objLP.enterLoginPassword(objReadProp.getValue(LoginPassword));
		objLP.clickBtnSignIn();
		objWDP.setWebDriver(objLP.getWebDriver());

		//Log user name and click on Home Page
		UserAccountPage objUserAccount = new UserAccountPage(objWDP.getWebDriver());
		Reporter.log("User name : " + objUserAccount.getBtnUserAccount().getText());
		objUserAccount.clickHomePage();
		objWDP.setWebDriver(objUserAccount.getDriver());

		//Add Item 1 to cart - Size M, Quantity 2
		HomePage objHomePage = new HomePage(objWDP.getWebDriver());
		objHomePage.clickItem1();
		objWDP.setWebDriver(objHomePage.getDriver());
		ProductDetailPage objProdDetail = new ProductDetailPage(objWDP.getWebDriver());
		Reporter.log("Size Selected : " + objProdDetail.selectSize("M"));
		System.out.println("Quantity Selected : " + objProdDetail.incrementQuantity());
		System.out.println(objProdDetail.addToCartAndContinue());
		objProdDetail.goToHomePage();
		objWDP.setWebDriver(objProdDetail.getDriver());

		//Add Item 2 to cart and proceed to checkout - Size L, Quantity 3
		objHomePage.clickItem2();
		objWDP.setWebDriver(objHomePage.getDriver());
		objProdDetail = new ProductDetailPage(objWDP.getWebDriver());
		Reporter.log("Size Selected : " + objProdDetail.selectSize("L"));
		objProdDetail.incrementQuantity();
		Reporter.log("Quantity Selected : " + objProdDetail.incrementQuantity());
		Reporter.log(objProdDetail.addToCartAndProceed());
		objWDP.setWebDriver(objProdDetail.getDriver());

		//Verify total cart price and proceed to checkout
		CheckOutSummary objCOM = new CheckOutSummary(objWDP.getWebDriver());
		Reporter.log("\nTotal cart price : " + objCOM.verifyTotalPrice());
		objCOM.proceedToCheckout();
		objWDP.setWebDriver(objCOM.getDriver());

		//Select shipping address and proceed to checkout
		CheckOutAddress objCOA = new CheckOutAddress(objWDP.getWebDriver());
		objCOA.clickProceedCheckout();
		objWDP.setWebDriver(objCOA.getDriver());

		//Agree to terms of service and proceed to checkout
		CheckOutShipping objCOS = new CheckOutShipping(objWDP.getWebDriver());
		Reporter.log("\nError message on not agreeing to Terms of Service : " + objCOS.getErrorMessage());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objCOS.clickProceedToCheckout();
		objWDP.setWebDriver(objCOS.getDriver());

		//Select payment mode and checkout
		CheckOutPayment objCOP = new CheckOutPayment(objWDP.getWebDriver());
		objCOP.clickPayByBankWire();
		objCOP.clickConfirmOrder();
		objCOP.setLblOrderSuccess();
		assertEquals(objCOP.getSuccessMessage(), objReadProp.getValue(SuccessMessage));
	}

	@AfterMethod
	public void afterTest() {
		objWDP.getWebDriver().quit();
	}

	@BeforeSuite
	public void beforeSuite() {
		ReadPropertiesFile objReadProp = new ReadPropertiesFile();
		browser = objReadProp.getValue(keyBrowser);
		appURL = objReadProp.getValue(keyAppURL);
	}

	@AfterSuite
	public void afterSuite() {
	}

}
