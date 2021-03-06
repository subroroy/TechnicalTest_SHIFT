package src.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementSynchronization {
	
	private WebDriverWait webDriverWait;
	
	/**
	 * Exception handling : Wait till WebElement ele is visible on the page
	 */
	public WebElement waitTillElementVisible(WebDriver driver, WebElement ele) {
		webDriverWait = new WebDriverWait(driver, 20);
		ele = webDriverWait.until(ExpectedConditions.visibilityOf(ele));
		return ele;
	}
	
	/**
	 * Exception handling : Hover over the mentioned WebElement on the page 
	 */
	public WebElement hoverToElement(WebDriver driver, WebElement ele) {
		Actions obj = new Actions(driver);
		obj.moveToElement(ele).build().perform();
		return ele;
	}
}
