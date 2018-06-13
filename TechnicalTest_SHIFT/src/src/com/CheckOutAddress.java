package src.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutAddress {

	private WebDriver driver;
	private WebElement btnProceedCheckout;
	
	public CheckOutAddress(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickProceedCheckout() {
		setBtnProceedCheckout();
		getBtnProceedCheckout().click();
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getBtnProceedCheckout() {
		return btnProceedCheckout;
	}
	public void setBtnProceedCheckout() {
		this.btnProceedCheckout = driver.findElement(By .name("processAddress"));
	}
	
}
