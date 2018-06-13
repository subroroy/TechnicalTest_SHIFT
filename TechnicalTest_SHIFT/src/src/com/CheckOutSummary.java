package src.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutSummary extends CheckOutButtons{

	private WebDriver driver;
	private WebElement btnProceedToCheckout, lblTotalPrice;
	
	public CheckOutSummary(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void proceedToCheckout() {
		setBtnProceedToCheckout();
		hoverToElement(getDriver(), getBtnProceedToCheckout()).click();;
		//getBtnProceedToCheckout().click();
	}
	
	public String verifyTotalPrice() {
		setLblTotalPrice();
		return getLblTotalPrice().getText();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBtnProceedToCheckout() {
		return btnProceedToCheckout;
	}

	public void setBtnProceedToCheckout() {
		this.btnProceedToCheckout = driver.findElement(By .xpath("(//a[@title='Proceed to checkout'])[2]"));
	}

	public WebElement getLblTotalPrice() {
		return lblTotalPrice;
	}

	public void setLblTotalPrice() {
		this.lblTotalPrice = driver.findElement(By .id("total_price"));
	}
}
