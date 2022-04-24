package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase{

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
	}
@FindBy(id="gender-male")
WebElement MaleGenderSelector;

@FindBy(id="FirstName")
WebElement FirstNameBox;

@FindBy(id="LastName")
WebElement LastNameBox;

@FindBy(id="Email")
WebElement EmailBox;

@FindBy(id="Password")
WebElement PasswordBox;

@FindBy(id="ConfirmPassword")
WebElement ConfirmPasswordBox;

@FindBy(id="register-button")
WebElement RegisterButton;

@FindBy(css = "div.result")
public WebElement registermessage;

@FindBy(linkText = "Log out")
public WebElement logoutLink;
@FindBy(linkText = "My account")
WebElement myAccountLink;

public void userRegister(String FirstName,String LastName,String Email,String Password) {
	clickBTN(MaleGenderSelector);
	sendTxtToElement(FirstNameBox, FirstName);
	sendTxtToElement(LastNameBox, LastName);
	sendTxtToElement(EmailBox, Email);
	sendTxtToElement(PasswordBox, Password);
	sendTxtToElement(ConfirmPasswordBox, Password);
	clickBTN(RegisterButton);
}
public void userLogout() {
	clickBTN(logoutLink);
}

public void openMyAccountPage() {
	clickBTN(myAccountLink);
}
}
