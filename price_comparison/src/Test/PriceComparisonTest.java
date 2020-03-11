package Test;

import java.util.Arrays;

import org.testng.annotations.Test;

public class PriceComparisonTest extends FlipkartPageTest{
	@Test(priority = 7)
	public void priceComparison() {
		int price[]= {ap.price_of_the_phone(),fp.price_of_the_phone()};
		Arrays.sort(price);
		int minPrice=price[0]; 	
		if(ap.price_of_the_phone()<fp.price_of_the_phone()) {
			System.out.println("Amazon's phone price is less with Rs."+minPrice);
		}else {
			System.out.println("Flipkart's phone price is less with Rs."+minPrice);
		}
	}
}
