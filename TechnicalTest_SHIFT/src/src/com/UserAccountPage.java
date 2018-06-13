package src.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAccountPage extends ElementSynchronization {

	private WebDriver driver;
	private WebElement btnSignOut, btnUserAccount, shoppingCart, searchInput, 
						searchButton, btnHomePage;
	private WebElement btnAddress, btnPersonalInfo, btnCreditSlips, btnOrderHistoryDetails, 
						btnWishlists;

	public UserAccountPage(WebDriver driver) {
		this.driver = driver;
		setBtnOrderHistoryDetails();
		setBtnWishlists();
		setBtnPersonalInfo();
		setBtnCreditSlips();
		setBtnAddress();
		setBtnHomePage();
		setBtnUserAccount();
		setTxtSearch();
		setBtnSearch();
	}

	public String userName() {
		return getBtnUserAccount().getText();
	}

	public void clickSignOut() {
		setBtnSignOut();
		getBtnSignOut().click();
	}

	public WebElement getBtnSignOut() {
		return btnSignOut;
	}

	public void setBtnSignOut() {
		this.btnSignOut = this.driver.findElement(By.className("logout"));
	}

	public WebElement getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(WebElement shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public WebElement getTxtSearch() {
		return searchInput;
	}

	public void setTxtSearch() {
		this.searchInput = this.driver.findElement(By.name("search_query"));
	}

	public WebElement getBtnSearch() {
		return searchButton;
	}

	public void setBtnSearch() {
		this.searchButton = this.driver.findElement(By.name("submit_search"));
	}

	public WebElement getBtnHomePage() {
		return btnHomePage;
	}

	public void setBtnHomePage() {
		this.btnHomePage = this.driver.findElement(By.xpath("//a[@title='Home']"));
	}

	public WebElement getBtnAddress() {
		return btnAddress;
	}

	public void setBtnAddress() {
		this.btnAddress = this.driver.findElement(By.xpath("//a[@title='Addresses']"));;
	}

	public WebElement getBtnPersonalInfo() {
		return btnPersonalInfo;
	}

	public void setBtnPersonalInfo() {
		this.btnPersonalInfo = this.driver.findElement(By.xpath("//a[@title='Information']"));
	}

	public WebElement getBtnCreditSlips() {
		return btnCreditSlips;
	}

	public void setBtnCreditSlips() {
		this.btnCreditSlips = this.driver.findElement(By.xpath("//a[@title='Credit slips']"));
	}

	public WebElement getBtnOrderHistoryDetails() {
		return btnOrderHistoryDetails;
	}

	public void setBtnOrderHistoryDetails() {
		this.btnOrderHistoryDetails = this.driver.findElement(By.xpath("//a[@title='Orders']"));
	}

	public WebElement getBtnWishlists() {
		return btnWishlists;
	}

	public void setBtnWishlists() {
		this.btnWishlists = this.driver.findElement(By.xpath("//a[@title='My wishlists']"));
	}

	public void clickHomePage() {
		btnHomePage.click();
	}

	public WebElement getBtnUserAccount() {
		return btnUserAccount;
	}

	public void setBtnUserAccount() {
		this.btnUserAccount = this.driver.findElement(By.xpath("//a[@class='account']"));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setBtnSignOut(WebElement btnSignOut) {
		this.btnSignOut = btnSignOut;
	}

	public void setBtnUserAccount(WebElement btnUserAccount) {
		this.btnUserAccount = btnUserAccount;
	}

	public void setBtnPersonalInfo(WebElement btnPersonalInfo) {
		this.btnPersonalInfo = btnPersonalInfo;
	}

	public void setBtnCreditSlips(WebElement btnCreditSlips) {
		this.btnCreditSlips = btnCreditSlips;
	}

	public void setBtnOrderHistoryDetails(WebElement btnOrderHistoryDetails) {
		this.btnOrderHistoryDetails = btnOrderHistoryDetails;
	}

	public void setBtnWishlists(WebElement btnWishlists) {
		this.btnWishlists = btnWishlists;
	}

}
