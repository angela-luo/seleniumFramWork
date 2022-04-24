package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="FullName")
	WebElement nameBox;
	@FindBy(id="Email")
	WebElement emailBox;
	@FindBy(id="Enquiry")
	WebElement Enquiry;
	@FindBy(name = "send-email")
	WebElement submitBtn;
	@FindBy(css = "div.result")
	public WebElement successMsg;
	public void contactUs(String Fname, String email,String text) {
		sendTxtToElement(nameBox,Fname );
		sendTxtToElement(emailBox,email );
		sendTxtToElement(Enquiry, text);
		clickBTN(submitBtn);
	}
	

}
