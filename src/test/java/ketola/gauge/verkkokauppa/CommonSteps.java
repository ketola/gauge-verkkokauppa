package ketola.gauge.verkkokauppa;

import com.thoughtworks.gauge.Step;

public class CommonSteps extends MainPageSpec {

	public CommonSteps() {
		this.driver = DriverFactory.getDriver();
	}

	@Step("Open the main page")
	public void navigateToMainPage() {
		driver.get(BASE_URL);
	}
}
