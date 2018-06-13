package src.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutShipping extends CheckOutButtons{

	private WebDriver driver;
	private WebElement radAgreeTermsOfService, btnProceedToCheckout, lblErrorMessage, btnCloseErrorMessage;
	
	public CheckOutShipping(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public void clickProceedToCheckout() {
		setBtnProceedToCheckout();
		setRadAgreeTermsOfService();
		hoverToElement(driver, getRadAgreeTermsOfService()).click();
		//getRadAgreeTermsOfService().click();
		waitTillElementVisible(driver, getBtnProceedToCheckout()).click();
	}
	
	public String getErrorMessage() {
		String message;
		setBtnProceedToCheckout();
		waitTillElementVisible(driver, getBtnProceedToCheckout()).click();
		setLblErrorMessage();
		message = getLblErrorMessage().getText();
		setBtnCloseErrorMessage();
		getBtnCloseErrorMessage().click();
		return message;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getRadAgreeTermsOfService() {
		return radAgreeTermsOfService;
	}
	public void setRadAgreeTermsOfService() {
		this.radAgreeTermsOfService = driver.findElement(By .name("cgv"));
	}
	public WebElement getBtnProceedToCheckout() {
		return btnProceedToCheckout;
	}
	public void setBtnProceedToCheckout() {
		this.btnProceedToCheckout = driver.findElement(By .name("processCarrier"));
	}

	public WebElement getLblErrorMessage() {
		return lblErrorMessage;
	}

	public void setLblErrorMessage() {
		this.lblErrorMessage = driver.findElement(By .className("fancybox-error"));
	}

	public WebElement getBtnCloseErrorMessage() {
		return btnCloseErrorMessage;
	}

	public void setBtnCloseErrorMessage() {
		this.btnCloseErrorMessage = driver.findElement(By .xpath("//a[@title='Close' and @class='fancybox-item fancybox-close']"));
	}
	
}
