package framework;


import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EventMethods {
	public static void move_to_element_with_offset(WebElement element,int x,int y) {
		Actions act=new Actions(Data.driver);
		act.moveToElement(element, x, y).click().build().perform();
	}
	public static void switch_to_new_window() {
		Set<String>windows=Data.driver.getWindowHandles();
		for (String winHandle :windows) {
			Data.driver.switchTo().window(winHandle);
		}
	}
	public static void scrollTOElement(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)Data.driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	public static boolean waitforElement_is_Displayed(WebElement Element, int timeout){
		boolean isElementDisplayed= false;
		
		try {
			WebDriverWait wait= new WebDriverWait(Data.driver, timeout);
			Element	=wait.until(ExpectedConditions.visibilityOf(Element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementDisplayed=true;
		}catch(Exception e) {
			isElementDisplayed=false;
			System.out.println("Element is not displayed");
		}
		return isElementDisplayed;
	}
	public static boolean waitforElement_is_Enabled(WebElement Element,int timeout) {
		boolean isElementEnabled=false;
		try {

			WebDriverWait wait=new WebDriverWait(Data.driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled=true;
		}catch(Exception e) {
			isElementEnabled=true;
			System.out.println("Element is not Enabled");
		}
		return isElementEnabled;
	}
	public  static void Enter_value(WebElement Element,String input) {
		if(Element==null) {
			Assert.assertFalse(true, "NO such Element is found with that locator");
		} else {
			if( waitforElement_is_Displayed(Element,20)) {
				if(  waitforElement_is_Enabled(Element,20)) {
					Element.clear();
					Element.sendKeys(input);
				}else {
					Assert.assertTrue(false, "Element "+input+" is not enabled even after waiting for 20 seconds");

				}
			}else {
				Assert.assertTrue(false, "Element "+input+" is not Displayed even after waiting for 20 seconds");
			}
		}
	}
	public static void clickElement(WebElement Element) {
		if(Element==null) {
			Assert.assertTrue(false, "No such Element found");
		}else {
			if(waitforElement_is_Displayed(Element, 2)) {
				if(waitforElement_is_Enabled(Element, 2)) {
					Element.click();
				}else {
					Assert.assertTrue(false, "Element is not Enabled even after 20 seconds");
				}
			}else {
				Assert.assertTrue(false, "Element is not Displayed even after 20 seconds");
			}
		}
	}

}

