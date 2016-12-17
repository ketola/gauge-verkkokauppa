package ketola.gauge.verkkokauppa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;

public class DriverFactory {
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
}
}
