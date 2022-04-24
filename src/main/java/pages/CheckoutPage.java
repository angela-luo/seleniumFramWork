package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement firstName;
	@FindBy(id="BillingNewAddress_LastName")
	WebElement secondName;
	@FindBy(id="BillingNewAddress_Email")
	WebElement email;
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countryList;
	@FindBy(id="BillingNewAddress_StateProvinceId")
	WebElement stateList;
	@FindBy(id="BillingNewAddress_City")
	WebElement city;
	@FindBy(id="BillingNewAddress_Address1")
	WebElement address;
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement postalCode;
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phoneNumber;
	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement continue1;
	@FindBy(id="shippingoption_1")
	WebElement paymentMethod;
	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement continue2;
	@FindBy(css="button.button-1.payment-method-next-step-button")
	WebElement continue3;
	@FindBy(css="button.button-1.payment-info-next-step-button")
	WebElement continue4;
	@FindBy(linkText ="Apple MacBook Pro 13-inch")
	public WebElement productName;
	@FindBy(css="button.button-1.confirm-order-next-step-button")
	WebElement confirm;
	@FindBy(css = "strong")
	public WebElement successfulCheckoutMsg;
	@FindBy(css="span.sku-number")
	public WebElement sku;
	@FindBy(tagName = "strong")
	public WebElement total;
	@FindBy(css="h1")
	public WebElement title;
	@FindBy(css="div.page-title")
	public WebElement pageTitle;
	@FindBy(linkText = "Click here for order details.")
	public WebElement orderDetails;
	public void registeredUserCheckOutProcess(String City, String Address,String zip,String num) throws InterruptedException {
		select = new Select(countryList);
		select.selectByValue("1");
		select = new Select(stateList);
		select.selectByValue("1");
		sendTxtToElement(city, City);
		sendTxtToElement(address, Address);
		sendTxtToElement(postalCode, zip);
		sendTxtToElement(phoneNumber, num);
		clickBTN(continue1);
		clickBTN(paymentMethod);
		clickBTN(continue2);
		clickBTN(continue3);
		clickBTN(continue4);
	}
	public void confirmPayment() {
		clickBTN(confirm);
	}
	public void goToOrderDetails() {
		clickBTN(orderDetails);
	}
	public void guestUserCheckOutProcess(String Fname,String Lname ,String Email, String City, String Address,String zip,String num) {
		sendTxtToElement(firstName, Fname);
		sendTxtToElement(secondName, Lname);
		sendTxtToElement(email, Email);
		select = new Select(countryList);
		select.selectByValue("1");
		select = new Select(stateList);
		select.selectByValue("1");
		sendTxtToElement(city, City);
		sendTxtToElement(address, Address);
		sendTxtToElement(postalCode, zip);
		sendTxtToElement(phoneNumber, num);
		clickBTN(continue1);
		clickBTN(paymentMethod);
		clickBTN(continue2);
		clickBTN(continue3);
		clickBTN(continue4);
	}
}
