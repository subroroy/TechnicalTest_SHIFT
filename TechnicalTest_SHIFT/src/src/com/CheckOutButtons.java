package src.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutButtons extends ElementSynchronization {

	private WebDriver driver;
	private WebElement btnHomePage, btnSummary, btnSignIn, btnAddress, btnShipping, btnPayment, btnContinueShopping;

	public CheckOutButtons(WebDriver driver) {
		this.driver = driver;
		setBtnHomePage();
	}

	public void goToHomePage() {
		getBtnHomePage().click();
	}

	public WebElement getBtnContinueShopping() {
		return btnContinueShopping;
	}

	public void setBtnContinueShopping() {
		this.btnContinueShopping = driver.findElement(By.xpath("//a[@title='previous']"));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBtnHomePage() {
		return btnHomePage;
	}

	public void setBtnHomePage() {
		this.btnHomePage = driver.findElement(By.className("home"));
	}

	public WebElement getBtnSummary() {
		return btnSummary;
	}

	public void setBtnSummary() {
		this.btnSummary = driver.findElement(By.xpath("//a/em[text()='01.']/parent::a"));
	}

	public WebElement getBtnSignIn() {
		return btnSignIn;
	}

	public void setBtnSignIn() {
		this.btnSignIn = driver.findElement(By.xpath("//a/em[text()='02.']/parent::a"));
	}

	public WebElement getBtnAddress() {
		return btnAddress;
	}

	public void setBtnAddress() {
		this.btnAddress = driver.findElement(By.xpath("//a/em[text()='03.']/parent::a"));
	}

	public WebElement getBtnShipping() {
		return btnShipping;
	}

	public void setBtnShipping() {
		this.btnShipping = driver.findElement(By.xpath("//a/em[text()='04.']/parent::a"));
	}

	public WebElement getBtnPayment() {
		return btnPayment;
	}

	public void setBtnPayment() {
		this.btnPayment = driver.findElement(By.xpath("//a/em[text()='05.']/parent::a"));
		;
	}

}
