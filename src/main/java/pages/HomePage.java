package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
	public HomePage(WebDriver driver) {
		super(driver);
		 js = (JavascriptExecutor)driver;
		 builder=new Actions(driver);
	}
@FindBy(linkText = "Register")
WebElement UserRegisteration;
public void openRegisterationPage() {
	clickBTN(UserRegisteration);
}
@FindBy(css="a.ico-login")
WebElement loginLink;
public void openLoginPage() {
	clickBTN(loginLink);
}

@FindBy(linkText = "Contact us")
WebElement contactUs;
public void openContatusPage() {
	ScrollDown();
	clickBTN(contactUs);
}
@FindBy(id="customerCurrency")
WebElement currencyList;
public void changeCurrency() {
	select = new Select(currencyList);
	select.selectByVisibleText("Euro");
}
@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
WebElement computersHoverList;
@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
WebElement noteBooks;
public void hoverMenu() {
	builder.moveToElement(computersHoverList).moveToElement(noteBooks)
	.click().build().perform();
}
}
