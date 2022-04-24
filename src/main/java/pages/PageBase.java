package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
protected WebDriver driver;
public JavascriptExecutor js;
public Select select;
public Actions builder;
	
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public static void clickBTN(WebElement button) {
		button.click();
	}
	public static void sendTxtToElement(WebElement txt,String value) {
		txt.sendKeys(value);
	}
	
	public  void ScrollDown() {
		js.executeScript("scrollBy(0,2500)");
	}
}
