package dataDrivenTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperty;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationByPropertiesFile extends TestBase{

	HomePage homepage;
	UserRegisterationPage URP;
	LoginPage login;
	String firstName= LoadProperty.userData.getProperty("firstName");
	String lastName= LoadProperty.userData.getProperty("lastName");
	String email= LoadProperty.userData.getProperty("email");
	String password= LoadProperty.userData.getProperty("password");
	@Test(priority = 1)
	public void succssfulRegisteration() {
		homepage = new HomePage(driver);
		homepage.openRegisterationPage();
	    URP = new UserRegisterationPage(driver);
		URP.userRegister(firstName,lastName,email,password);
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
		login.userLogin(email,password);
		Assert.assertTrue(URP.logoutLink.getText().contains("Log out"));
	}
}
