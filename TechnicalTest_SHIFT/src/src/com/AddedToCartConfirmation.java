package src.com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddedToCartConfirmation extends ElementSynchronization{

	private WebDriver driver;
	private String cartDetails;
	private WebElement message, product, details, quantity, price, continueShopping, checkoutCart, close;
	private WebElement totalProductCost, totalShippingCost, totalCartCost, totalCartItems;

	public AddedToCartConfirmation(WebDriver driver){
		this.driver = driver;
	}
	
	public String getCartDetails() {
		setProduct();
		setDetails();
		setQuantity();
		setPrice();
		cartDetails = "Product : " + getProduct() + "; Details : " + getDetails() + "; Quantity : " + getQuantity()
				+ "; Price : " + getPrice();
		//clickContinueShopping();
		return cartDetails;
	}
	
	public String checkOutCart() {
		setTotalCartCost();
		setTotalCartItems();
		setTotalProductCost();
		setTotalShippingCost();
		cartDetails = getTotalCartItems() + "; Total product cost : " + getTotalProductCost() + "Total Shipping cost : "
				+ getTotalShippingCost() + "; Total cart cost : " + getTotalCartCost();
		clickCheckoutCart();
		return cartDetails;
	}
	
	public void clickCheckoutCart() {
		setCheckoutCart();
		getCheckoutCart().click();
	}
	
	public void clickContinueShopping() {
		setContinueShopping();
		this.waitTillElementVisible(driver, getContinueShopping()).click();
		//getContinueShopping().click();
	}
	
	public WebElement getTotalProductCost() {
		return totalProductCost;
	}

	public void setTotalProductCost() {
		this.totalProductCost = driver.findElement(By .xpath("//span[@class='ajax_block_products_total']"));
	}

	public String getTotalShippingCost() {
		return totalShippingCost.getText();
	}

	public void setTotalShippingCost() {
		this.totalShippingCost = driver.findElement(By .xpath("//span[@class='ajax_cart_shipping_cost']"));
	}

	public String getTotalCartCost() {
		return totalCartCost.getText();
	}

	public void setTotalCartCost() {
		this.totalCartCost = driver.findElement(By .xpath("//span[@class='ajax_block_cart_total']"));
	}

	public String getTotalCartItems() {
		return totalCartItems.getText();
	}

	public void setTotalCartItems() {
		this.totalCartItems = driver.findElement(By .xpath("//span[@class='ajax_cart_product_txt ']"));;
	}

	public WebElement getClose() {
		return close;
	}

	public void setClose(WebElement close) {
		this.close = driver.findElement(By .xpath("//span[@title='Close window']"));
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getMessage() {
		return message.getText();
	}

	public void setMessage() {
		this.message = driver.findElement(By .xpath("//div[contains(@class, 'layer_cart_product ')]/h2"));
	}

	public String getProduct() {
		return waitTillElementVisible(driver, product).getText() ;
	}

	public void setProduct() {
		this.product = driver.findElement(By .xpath("//span[@id='layer_cart_product_title' and @class='product-name']"));
	}

	public String getDetails() {
		return waitTillElementVisible(driver, details).getText();
	}

	public void setDetails() {
		this.details = driver.findElement(By .id("layer_cart_product_attributes"));
	}

	public String getQuantity() {
		return waitTillElementVisible(driver, quantity).getText();
	}

	public void setQuantity() {
		this.quantity = driver.findElement(By .id("layer_cart_product_quantity"));
	}

	public String getPrice() {
		return waitTillElementVisible(driver, price).getText();
	}

	public void setPrice() {
		this.price = driver.findElement(By .id("layer_cart_product_price"));
	}

	public WebElement getContinueShopping() {
		return continueShopping;
	}

	public void setContinueShopping() {
		this.continueShopping = driver.findElement(By .xpath("//span[@title='Continue shopping']"));
	}

	public WebElement getCheckoutCart() {
		return checkoutCart;
	}

	public void setCheckoutCart() {
		this.checkoutCart = driver.findElement(By .xpath("//a[@title='Proceed to checkout']"));
	}
}
