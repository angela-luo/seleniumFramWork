package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase {

	HomePage homepage;
	UserRegisterationPage URP;
	LoginPage login;
	MyAccountPage myAccount;
	String firstName="Ahmed";
	String lastName="samir";
	String email="ahmed12354@gmail.com";
	String oldPass="123456";
	String newPass="123321";
	
	@Test(priority = 1)
	public void succssfulRegisteration() {
		homepage = new HomePage(driver);
		homepage.openRegisterationPage();
	    URP = new UserRegisterationPage(driver);
		URP.userRegister(firstName,lastName, email, oldPass);
		Assert.assertTrue(URP.registermessage.getText().contains("Your registration completed"));
	}
	@Test(priority = 2)
	public void openMyAccount() {
		URP.openMyAccountPage();
		myAccount=new MyAccountPage(driver);
		myAccount.openChangePasswordLink();
		myAccount.changePassword(oldPass, newPass);
		Assert.assertTrue(myAccount.succssesMSG.getText().contains("Password was changed"));
		myAccount.closeMsg();
	}
	@Test(priority = 3)
	public void registerdUserLogout() {
		URP.userLogout();
	}
	@Test(priority = 4)
	public void registerdUserLogin() {
		homepage.openLoginPage();
		login = new LoginPage(driver);
		login.userLogin(email, newPass);
		Assert.assertTrue(URP.logoutLink.getText().contains("Log out"));
	}
}
