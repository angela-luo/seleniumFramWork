package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="a.product-name")
	public WebElement productName;
	@FindBy(id ="itemquantity11220")
	public WebElement itemQuantity;
	@FindBy(css="span.product-subtotal")
	public WebElement totalPrice;
	@FindBy(css="button.remove-btn")
	WebElement removeBtn;
	@FindBy(id="updatecart")
	WebElement updateCartBtn;
	@FindBy(css="div.no-data")
	public WebElement clearMsg;
	@FindBy(id="termsofservice")
	WebElement agreementServiceBtn;
	@FindBy(id="checkout")
	WebElement checkoutBtn;
	@FindBy(css="button.button-1.checkout-as-guest-button")
	WebElement checkOutAsGuestBtn;
	public void changeQuantity(String quantity) {
		itemQuantity.clear();
		sendTxtToElement(itemQuantity, quantity);
		clickBTN(updateCartBtn);
	}
	public void removeProduct() {
		clickBTN(removeBtn);
	}
public void goToCheckoutPage() {
	clickBTN(agreementServiceBtn);
	clickBTN(checkoutBtn);
}
public void checkOutAsGuest() {
	clickBTN(checkOutAsGuestBtn);
}
}
