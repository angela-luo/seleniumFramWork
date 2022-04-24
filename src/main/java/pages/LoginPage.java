package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="Email")
	WebElement emailBox;
	
	@FindBy(id="Password")
	WebElement passwordBox;
	
	@FindBy(css = "button.button-1.login-button")
	WebElement loginBTN;
	
	public void userLogin(String email,String pass) {
		sendTxtToElement(emailBox,email );
		sendTxtToElement(passwordBox,pass );
		clickBTN(loginBTN);
	}

}
