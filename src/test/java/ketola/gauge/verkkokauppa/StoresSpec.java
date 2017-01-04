package ketola.gauge.verkkokauppa;

import java.util.Arrays;

import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;

public class StoresSpec extends MainPageSpec {

	public StoresSpec() {
		this.driver = DriverFactory.getDriver();
	}

	@Step("Footer should contain stores <table>")
	public void footerShouldContainStores(Table stores) {
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

		for (TableRow row : stores.getTableRows()) {
			int index = Integer.valueOf(row.getCell("index"));
			String store = row.getCell("store");
			String streetAddress = row.getCell("street address");
			mainPage.verifyStore(index, store, streetAddress);
		}
	}

	public static void main(String[] args) {

		Table stores = new Table(Arrays.asList("index", "store", "street address"));
		stores.addRow(Arrays.asList("1", "Kaubamaja", "Katu 1"));

		new DriverFactory().setup();
		StoresSpec storesSpec = new StoresSpec();
		storesSpec.driver.get(BASE_URL);
		storesSpec.footerShouldContainStores(stores);
	}
}
