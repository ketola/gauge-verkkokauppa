package ketola.gauge.verkkokauppa;

import static ketola.gauge.verkkokauppa.DriverFactory.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import org.junit.Assert;
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
	
	public void search(String username) {
		searchField.clear();
		searchField.sendKeys(username);
		new WebDriverWait(getDriver(), 10).until(visibilityOf(searchButton));
		searchButton.click();
	}
	
	public void verifySearch(String result) {
		Assert.assertTrue(searchResults.getText().contains(result));
	}
}
