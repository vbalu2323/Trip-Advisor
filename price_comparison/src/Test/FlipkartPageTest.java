package Test;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.CommonMethods;
import pages.FlipkartPage;

public class FlipkartPageTest extends AmazonPageTest {
	FlipkartPage fp;
	@Test(priority = 4)
	public void navigate_to_flipkartPage() {
		CommonMethods.launchApplication("chrome", "https://flipkart.com");
		fp=new FlipkartPage();
		boolean flag=fp.navigate_to_flipkart_page();
		Assert.assertTrue(flag);
	}
	@Test(priority = 5)
	public void enterValueInSearchBox() {
		fp.enter_value_in_searchText();
	}
	@Test(priority = 6)
	public void phone_price() {
		int value_in_flipkart=fp.price_of_the_phone();
	}
	
}
