package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {

	HomePage homepage;
	UserRegisterationPage URP;
	LoginPage login;
	@Test(priority = 1)
	public void succssfulRegisteration() {
		homepage = new HomePage(driver);
		homepage.openRegisterationPage();
	    URP = new UserRegisterationPage(driver);
		URP.userRegister("Ahmed","Samir", "ahmeddsamir1234567@gmail.com", "123456");
		Assert.assertTrue(URP.registermessage.getText().contains("Your registration completed"));

	}
	@Test(dependsOnMethods = {"succssfulRegisteration"})
	public void registerdUserLogout() {
		URP.userLogout();

			}
	@Test(dependsOnMethods = {"registerdUserLogout"})
	public void registerdUserLogin() {
		homepage.openLoginPage();
		login = new LoginPage(driver);
		login.userLogin("ahmeddsamir1234567@gmail.com", "123456");
		Assert.assertTrue(URP.logoutLink.getText().contains("Log out"));
	}
}
