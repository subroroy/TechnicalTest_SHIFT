package src.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPayment {
	private WebDriver driver;
	private WebElement lblTotalPrice, btnOtherMethods, btnConfirmOrder, btnPayBankWire, btnPayCheque, lblOrderSuccess;
	
	public CheckOutPayment(WebDriver driver) {
		this.driver = driver;
	}

	public void clickPayByBankWire() {
		setBtnPayBankWire();
		getBtnPayBankWire().click();
	}
	
	public void clickPayByCheque() {
		setBtnPayCheque();
		getBtnPayCheque().click();
	}
	
	public void clickOtherMethods() {
		setBtnOtherMethods();
		getBtnOtherMethods().click();
	}
	
	public void clickConfirmOrder() {
		setBtnConfirmOrder();
		getBtnConfirmOrder().click();
	}
	
	public String getSuccessMessage() {
		setLblOrderSuccess();
		return getLblOrderSuccess().getText();
	}
	public WebElement getLblOrderSuccess() {
		return lblOrderSuccess;
	}

	public void setLblOrderSuccess() {
		this.lblOrderSuccess = driver.findElement(By .xpath("//*[contains(text(), 'Your order on My Store is complete.')]"));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLblTotalPrice() {
		return lblTotalPrice;
	}

	public void setLblTotalPrice() {
		this.lblTotalPrice = driver.findElement(By .id("total_price"));
	}

	public WebElement getBtnOtherMethods() {
		return btnOtherMethods;
	}

	public void setBtnOtherMethods() {
		this.btnOtherMethods = driver.findElement(By .className("button-exclusive btn btn-default"));
	}

	public WebElement getBtnConfirmOrder() {
		return btnConfirmOrder;
	}

	public void setBtnConfirmOrder() {
		this.btnConfirmOrder = driver.findElement(By .xpath("//button[@type='submit' and @class='button btn btn-default button-medium']"));
	}

	public WebElement getBtnPayBankWire() {
		return btnPayBankWire;
	}

	public void setBtnPayBankWire() {
		this.btnPayBankWire = driver.findElement(By .className("bankwire"));
	}

	public WebElement getBtnPayCheque() {
		return btnPayCheque;
	}

	public void setBtnPayCheque() {
		this.btnPayCheque = driver.findElement(By .className("cheque"));
	}

}
