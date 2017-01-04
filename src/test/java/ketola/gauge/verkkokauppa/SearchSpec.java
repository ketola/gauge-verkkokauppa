package ketola.gauge.verkkokauppa;

import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.gauge.Step;

public class SearchSpec extends MainPageSpec {

	public SearchSpec() {
		this.driver = DriverFactory.getDriver();
	}

	@Step("Type <searchString> to the search field")
	public void typeToSearchField(String searchString) {
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.search(searchString);
	}

	@Step("The results should contain <searchResult>")
	public void verifySearch(String searchResult) {
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.verifySearch(searchResult);
	}

}
