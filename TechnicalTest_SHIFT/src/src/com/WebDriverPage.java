package src.com;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverPage {
	
	private final String keyChromeDriverPath = "ChromeDriverPath";
	private final String keyFirefixDriverPath = "FirefixDriverPath";
	private final String sysPropertyChrome = "webdriver.chrome.driver";
	private final String sysPropertyFirefox = "webdriver.gecko.driver";
	
	private WebDriver webDriver;
	private String driverPath;
	
	
	@SuppressWarnings("deprecation")
	public WebDriverPage(String browser, String appURL) {
		ReadPropertiesFile objReadProp = new ReadPropertiesFile();
		if(browser.equalsIgnoreCase("chrome")) {
			driverPath = objReadProp.getValue(keyChromeDriverPath);
			System.setProperty(sysPropertyChrome, driverPath);
			webDriver = new ChromeDriver();
			webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//webDriver.manage().window().maximize();
			webDriver.get(appURL);
		}
		else if(browser.equalsIgnoreCase("firefox")){
			driverPath = objReadProp.getValue(keyFirefixDriverPath);
			System.setProperty(sysPropertyFirefox, driverPath);
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		    capabilities.setCapability("marionette", true);
		    webDriver = new FirefoxDriver(capabilities);
		    webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    webDriver.get(appURL);
		}
		else {
			System.out.println("Please use Chrome or Firefox only. Currently used : " + browser);
		}
	}
	
	public WebDriver getWebDriver() {
		return this.webDriver;
	}
	
	public void setWebDriver(WebDriver driver) {
		this.webDriver = driver;
	}
}
