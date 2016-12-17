package ketola.gauge.verkkokauppa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.gauge.Step;

public class SearchSpec {
	
	private static final String BASE_URL = "http://www.verkkokauppa.com";
	private final WebDriver driver;

    public SearchSpec() {
		this.driver = DriverFactory.getDriver();
    }

    @Step("Open the main page")
    public void navigateToCustomersPage() {
        driver.get(BASE_URL);
    }
    
    @Step("Type <searchString> to the search field")
    public void verifyCustomers(String searchString) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.search(searchString);
    }
    
    @Step("The results should contain <searchResult>")
    public void verifySearch(String searchResult) {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.verifySearch(searchResult);
    }

}
