package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public static WebDriver driver;

	@BeforeTest
	public WebDriver setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		tdriver.set(driver);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tdriver.get();
	}
}
