package Test;

import org.testng.annotations.Test;
import framework.CommonMethods;
import framework.Data;
import framework.configMethods;
import pages.AmazonPage;

public class AmazonPageTest extends configMethods {
	AmazonPage ap;
	@Test
	public void homePage() {
		CommonMethods.launchApplication("chrome", "https://amazon.in");
		ap=new AmazonPage();
	}
	@Test(priority = 1)
	public void navigate_to_amazonPage() {
		ap.navigate_to_AmazonHomepage();
	}
	@Test(priority = 2)
	public void enteringValueInSearch() {
		ap.enter_value_in_searchText();
	}
	@Test(priority = 3)
	public void getting_the_price_of_the_phone() {
		int value_in_amazon=ap.price_of_the_phone();
		
		//Data.driver.close();
	}
}
