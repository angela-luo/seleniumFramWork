package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
@FindBy(linkText="Change password")
WebElement changePasswordLink;
public void openChangePasswordLink() {
	clickBTN(changePasswordLink);
}

@FindBy(id="OldPassword")
WebElement oldPasswordBox;
@FindBy(id="NewPassword")
WebElement newPasswordBox;
@FindBy(id="ConfirmNewPassword")
WebElement confirmedPasswordBox;
@FindBy(css = "button.button-1.change-password-button")
WebElement changePasswordBTN;
@FindBy(css = "p.content")
public WebElement succssesMSG;
@FindBy(css = "span.close")
WebElement closeSuccssesMSG;
public void changePassword(String oldPass, String newPass) {
	sendTxtToElement(oldPasswordBox, oldPass);
	sendTxtToElement(newPasswordBox, newPass);
	sendTxtToElement(confirmedPasswordBox, newPass);
	clickBTN(changePasswordBTN);
}
public void closeMsg() {
	clickBTN(closeSuccssesMSG);
}


}
