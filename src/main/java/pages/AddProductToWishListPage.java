package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductToWishListPage extends PageBase {

	public AddProductToWishListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "h1")
	public WebElement title;
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement productName;
	@FindBy(css="button.remove-btn")
	WebElement removeProductBtn;
	@FindBy(id="updatecart")
	WebElement updateWishListBtn;
	@FindBy(css="div.no-data")
	public WebElement successMsg;
	public void removeAndUpdateWishList() {
		clickBTN(removeProductBtn);
	}
}
