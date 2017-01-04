package ketola.gauge.verkkokauppa;

import static ketola.gauge.verkkokauppa.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

	@FindBy(how = How.CSS, css = "input.search-field__query--input")
	public WebElement searchField;

	@FindBy(how = How.CSS, css = "button.search-field__submit")
	public WebElement searchButton;

	@FindBy(how = How.CSS, css = "div.search-results")
	public WebElement searchResults;

	@FindBy(how = How.CSS, css = "div.open-hours__stores")
	public WebElement stores;

	public void search(String username) {
		searchField.clear();
		searchField.sendKeys(username);
		new WebDriverWait(getDriver(), 10).until(visibilityOf(searchButton));
		searchButton.click();
	}

	public void verifySearch(String result) {
		assertTrue(searchResults.getText().contains(result));
	}

	public void verifyStore(int index, String storeName, String storeAddress) {
		assertTrue(
				stores.findElements(By.cssSelector(".store-hours__item")).get(index - 1).getText().contains(storeName));
		assertTrue(stores.findElements(By.cssSelector(".store-hours__item")).get(index - 1).getText()
				.contains(storeAddress));
	}
}
