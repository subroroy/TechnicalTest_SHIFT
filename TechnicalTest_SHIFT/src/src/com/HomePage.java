package src.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends ElementSynchronization {

	private WebDriver driver;
	private WebElement signIn, shoppingCart, searchInput, searchButton, checkOut;
	private WebElement signOut, userAccount;
	private WebElement item1, item1Rate, item1AddToCart, item2, item2Rate, item2AddToCart;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

	public void setCheckOut() {
		this.checkOut = driver.findElement(By.id("button_order_cart"));
	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		shoppingCart = waitTillElementVisible(driver, this.driver.findElement(By.className("shopping_cart")));
		searchInput = waitTillElementVisible(driver, this.driver.findElement(By.name("search_query")));
		searchButton = waitTillElementVisible(driver, this.driver.findElement(By.name("submit_search")));
	}

	/**
	 * This method is used to add item 1 to cart.
	 */
	public String addItem1ToCart() {
		String itemDetails = "Item 1 added to cart. Details: ";
		clickItem1AddToCart();
		AddedToCartConfirmation objAddCart = new AddedToCartConfirmation(driver);
		itemDetails = itemDetails + objAddCart.getCartDetails();
		return itemDetails;
	}

	/**
	 * This method is used to click on the Add to Cart button for Item 1. It will
	 * first hover over Item 1 to bring it to visibility.
	 */

	public void clickItem1AddToCart() {
		Actions objActions = new Actions(driver);
		setItem1();
		setItem1AddToCart();
		objActions.moveToElement(getItem1()).build().perform();
		getItem1AddToCart().click();
	}

	/**
	 * This method is used to add item 2 to cart.
	 */

	public String addItem2ToCart() {
		String itemDetails = "Item 2 added to cart. Details: ";
		clickItem2AddToCart();
		AddedToCartConfirmation objAddCart = new AddedToCartConfirmation(driver);
		itemDetails = itemDetails + objAddCart.getCartDetails();
		return itemDetails;
	}

	/**
	 * This method is used to click on the Add to Cart button for Item 2. It will
	 * first hover over Item 2 to bring it to visibility.
	 */
	public void clickItem2AddToCart() {
		Actions objActions = new Actions(driver);
		setItem2();
		setItem2AddToCart();
		objActions.moveToElement(getItem2()).build().perform();
		objActions.moveToElement(getItem2AddToCart()).build().perform();
		getItem2AddToCart().click();
	}

	/**
	 * This method is used to click on the Item 1.
	 */
	public void clickItem1() {
		setItem1();
		getItem1().click();
	}

	/**
	 * This method is used to click on the Item 2.
	 */
	public void clickItem2() {
		setItem2();
		getItem2().click();
	}

	/**
	 * This method is used to click on the Shopping Cart Button.
	 */
	public void clickShoppingCart() {
		Actions obj = new Actions(getDriver());
		obj.moveToElement(shoppingCart).build().perform();
		setCheckOut();
		getCheckOut().click();
	}

	/**
	 * This method is used to enter a search string in the Search textbox.
	 */
	public void enterSearchText(String text) {
		waitTillElementVisible(driver, searchInput).sendKeys(text);
	}

	/**
	 * This method is used to click on the Search Button.
	 */
	public void clickSearchButton() {
		waitTillElementVisible(driver, searchButton).click();
	}
	
	/**
	 * This method is used to click on the Logout button.
	 */
	public void logOut() {
		setSignOut();
		waitTillElementVisible(driver, signOut).click();
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public void setSignIn() {
		this.signIn = driver.findElement(By.className("login"));
		;
	}

	public WebElement getItem1() {
		return item1;
	}

	public void setItem1() {
		this.item1 = driver.findElement(
				By.xpath("(//a[@title='Faded Short Sleeve T-shirts' and @class='product_img_link'])[1]/img"));
	}

	public WebElement getItem1Rate() {
		return waitTillElementVisible(driver, item1Rate);
	}

	public void setItem1Rate() {
		this.item1Rate = waitTillElementVisible(driver, driver.findElement(By.xpath(
				"(//a[@title='Faded Short Sleeve T-shirts' and @class='product_img_link'])[1]/following-sibling::div[@class='content_price']/span")));
	}

	public WebElement getItem1AddToCart() {
		return item1AddToCart;
	}

	public void setItem1AddToCart() {
		this.item1AddToCart = driver.findElement(By.xpath("(//a[@title='Add to cart' and @data-id-product='1'])[1]"));
	}

	public WebElement getItem2() {
		return item2;
	}

	public void setItem2() {
		this.item2 = driver.findElement(By.xpath("(//a[@title='Blouse' and @class='product_img_link'])[1]/img"));
	}

	public WebElement getItem2Rate() {
		return waitTillElementVisible(driver, item2Rate);
	}

	public void setItem2Rate() {
		this.item2Rate = waitTillElementVisible(driver, driver.findElement(
				By.xpath("(//a[@title='Blouse'])[1]/following-sibling::div[@class='content_price']/span")));
	}

	public WebElement getItem2AddToCart() {
		return item2AddToCart;
	}

	public void setItem2AddToCart() {
		this.item2AddToCart = driver.findElement(By.xpath("(//a[@title='Add to cart' and @data-id-product='2'])[1]"));
	}

	public String getUserAccount() {
		return waitTillElementVisible(driver, userAccount).getText();
	}

	public void setUserAccount() {
		this.userAccount = waitTillElementVisible(driver, driver.findElement(By.className("account")));
	}

	public WebElement getSignOut() {
		return waitTillElementVisible(driver, signOut);
	}

	public void setSignOut() {
		this.signOut = waitTillElementVisible(driver, driver.findElement(By.className("logout")));
	}

	public void clickSignIn() {
		waitTillElementVisible(driver, signIn).click();
	}

}
