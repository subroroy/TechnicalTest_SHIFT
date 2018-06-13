package src.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends ProductDetailPopup{

	private WebDriver driver;

	private WebElement btnHome;

	public ProductDetailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		setBtnHome();
		}

	public void goToHomePage() {
		getBtnHome().click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getBtnHome() {
		return btnHome;
	}

	public void setBtnHome() {
		this.btnHome = driver.findElement(By .className("home"));
	}
}
