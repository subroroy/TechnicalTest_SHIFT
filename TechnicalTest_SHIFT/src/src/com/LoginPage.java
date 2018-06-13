package src.com;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ElementSynchronization {

	private WebElement txtRegisterEmail, txtLoginEmail, txtLoginPassword, btnCreateAccount, btnSignIn, lblAuthMessage;
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// Initialize webelements that appear on the page by default
		try {
			setTxtRegisterEmail();
			setTxtLoginEmail();
			setTxtLoginPassword();
			setBtnCreateAccount();
			setBtnSignIn();
		} catch (NoSuchElementException e) {
			System.out.println("Could not find element. Details:\n" + e.getMessage());
		}
	}

	public String showErrorMessage() {
		setLblAuthMessage();
		return getLblAuthMessage().getText();
	}

	public void clearEmailField() {
		txtLoginEmail.clear();
	}

	public void clearPasswordField() {
		txtLoginPassword.clear();
	}

	public WebElement getLblAuthMessage() {
		return lblAuthMessage;
	}

	public void setLblAuthMessage() {
		this.lblAuthMessage = this.driver.findElement(By.xpath("//*[@id='center_column']/div[1]/ol/li"));
	}

	public void enterRegEmail(String email) {
		waitTillElementVisible(driver, txtRegisterEmail).sendKeys(email);
	}

	public void enterLoginEmail(String email) {
		waitTillElementVisible(driver, txtLoginEmail).sendKeys(email);
	}

	public void enterLoginPassword(String pass) {
		waitTillElementVisible(driver, txtLoginPassword).sendKeys(pass);
	}

	public void clickBtnCreateAccount() {
		waitTillElementVisible(driver, btnCreateAccount).click();
	}

	public void clickBtnSignIn() {
		waitTillElementVisible(driver, btnSignIn).click();
	}

	public WebDriver getWebDriver() {
		return this.driver;
	}

	public void setWebDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getTxtRegisterEmail() {
		return txtRegisterEmail;
	}

	public void setTxtRegisterEmail() {
		this.txtRegisterEmail = this.driver.findElement(By.id("email_create"));;
	}

	public WebElement getTxtLoginEmail() {
		return txtLoginEmail;
	}

	public void setTxtLoginEmail() {
		this.txtLoginEmail = this.driver.findElement(By.id("email"));;
	}

	public WebElement getTxtLoginPassword() {
		return txtLoginPassword;
	}

	public void setTxtLoginPassword() {
		this.txtLoginPassword = this.driver.findElement(By.id("passwd"));;
	}

	public WebElement getBtnCreateAccount() {
		return btnCreateAccount;
	}

	public void setBtnCreateAccount() {
		this.btnCreateAccount = this.driver.findElement(By.id("SubmitCreate"));;
	}

	public WebElement getBtnSignIn() {
		return btnSignIn;
	}

	public void setBtnSignIn() {
		this.btnSignIn = this.driver.findElement(By.id("SubmitLogin"));;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setLblAuthMessage(WebElement lblAuthMessage) {
		this.lblAuthMessage = lblAuthMessage;
	}
}