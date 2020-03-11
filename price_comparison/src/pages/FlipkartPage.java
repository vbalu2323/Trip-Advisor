package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.Data;
import framework.EventMethods;

public class FlipkartPage {
	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']") WebElement closeButton;
	@FindBy(xpath = "//img[@title='Flipkart']") WebElement flipkartLogo;
	@FindBy(xpath = "//input[@title='Search for products, brands and more']") WebElement searchBox;
	@FindBy(xpath = "//button[@class='vh79eN']") WebElement searchButton;
	@FindBy(xpath = "//div[@class='_1vC4OE _2rQ-NK']") WebElement price;
	public FlipkartPage() {
		PageFactory.initElements(Data.driver, this);
	}
	public boolean navigate_to_flipkart_page() {
		EventMethods.clickElement(closeButton);
		return flipkartLogo.isDisplayed();
	}
	public void enter_value_in_searchText() {
		EventMethods.Enter_value(searchBox, "iphone xr(64gb)-yellow");
		EventMethods.clickElement(searchButton);
	}
	public int price_of_the_phone() {
		String value=price.getText();
		value=value.replaceAll("[^0-9]","");
		int value_in_flipkart= Integer.parseInt(value);
		return value_in_flipkart;
	}
	
}
