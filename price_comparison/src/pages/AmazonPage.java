package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.Data;
import framework.EventMethods;

public class AmazonPage {
	@FindBy(id = "nav-logo") WebElement logo;
	@FindBy(id = "twotabsearchtextbox") WebElement searchText;
	@FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']") WebElement searchButton;
	@FindBy(xpath = "//span[@class='a-price-whole']") WebElement price;
	public AmazonPage() {
		PageFactory.initElements(Data.driver, this);
	}
	public boolean navigate_to_AmazonHomepage() {
		return logo.isDisplayed();
	}
	public void enter_value_in_searchText() {
		EventMethods.Enter_value(searchText, "iphone xr(64gb)-yellow");
		EventMethods.clickElement(searchButton);
	}
	public int price_of_the_phone() {
		String value=price.getText();
		value=value.replaceAll("[^0-9]","");
		int value_in_amazon= Integer.parseInt(value);
		
		return value_in_amazon;
	}
}
