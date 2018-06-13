package src.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPopup extends ElementSynchronization{
	private WebDriver driver;

	private WebElement lblRate, txtQnty, btnIncrementQnty, btnDecrementQnty, selSize, btnAddToCart;

	public ProductDetailPopup(WebDriver driver) {
		this.driver = driver;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBtnAddToCart();
		setBtnDecrementQnty();
		setBtnIncrementQnty();
		setLblRate();
		setSelSize();
		setTxtQnty();
	}

	public String incrementQuantity() {
		getBtnIncrementQnty().click();
		return getTxtQnty().getText();
	}

	public String decrementQuantity() {
		getBtnDecrementQnty().click();
		return getTxtQnty().getText();
	}

	public String selectSize(String size) {
		Select objSel = new Select(getSelSize());
		objSel.selectByVisibleText(size);
		return objSel.getFirstSelectedOption().getText();
	}

	public String addToCartAndContinue() {

		getBtnAddToCart().click();
		AddedToCartConfirmation objAddCart = new AddedToCartConfirmation(driver);
		String itemDetails = "Object added to cart. Details : " + objAddCart.getCartDetails();
		objAddCart.clickContinueShopping();
		return itemDetails;
	}

	public String addToCartAndProceed() {

		getBtnAddToCart().click();
		AddedToCartConfirmation objAddCart = new AddedToCartConfirmation(driver);
		String itemDetails = "Object added to cart. Details : " + objAddCart.getCartDetails();
		objAddCart.clickCheckoutCart();
		return itemDetails;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLblRate() {
		return lblRate;
	}

	public void setLblRate() {
		this.lblRate = driver.findElement(By .id("our_price_display"));
	}

	public WebElement getTxtQnty() {
		return txtQnty;
	}

	public void setTxtQnty() {
		this.txtQnty = driver.findElement(By .id("quantity_wanted"));
	}

	public WebElement getBtnIncrementQnty() {
		return btnIncrementQnty;
	}

	public void setBtnIncrementQnty() {
		this.btnIncrementQnty = driver.findElement(By .className("icon-plus"));
	}

	public WebElement getBtnDecrementQnty() {
		return btnDecrementQnty;
	}

	public void setBtnDecrementQnty() {
		this.btnDecrementQnty = driver.findElement(By .className("icon-minus"));
	}

	public WebElement getSelSize() {
		return selSize;
	}

	public void setSelSize() {
		this.selSize = driver.findElement(By .id("group_1"));
	}

	public WebElement getBtnAddToCart() {
		return btnAddToCart;
	}

	public void setBtnAddToCart() {
		this.btnAddToCart = driver.findElement(By .name("Submit"));
	}




}
