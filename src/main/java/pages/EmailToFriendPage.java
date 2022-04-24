package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailToFriendPage extends PageBase{

	public EmailToFriendPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="FriendEmail")
	WebElement friendEmail;
	@FindBy(id="PersonalMessage")
	WebElement msg;
	@FindBy(name = "send-email")
	WebElement sendBtn;
	@FindBy(css="div.result")
	public WebElement successMsg;
	public void emailToFriend(String email,String text) {
		sendTxtToElement(friendEmail,email );
		sendTxtToElement(msg, text);
		clickBTN(sendBtn);
	}
}
