package tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {

	HomePage homepage;
	UserRegisterationPage URP;
	LoginPage login;
	String firstName = "Ahmed";
	String lastName = "samir";
	String email;
	String pass = "123456";
	
	@Test(priority = 1)
	public void succssfulRegisteration() {
		homepage = new HomePage(driver);
		homepage.openRegisterationPage();
	    URP = new UserRegisterationPage(driver);
	    Random r = new Random();
	    email = "ahmed" + r.nextInt(1000) + "@gmail.com";
	    URP.userRegister("Ahmed","Samir", email, "123456");
//		URP.userRegister("Ahmed","Samir", "ahmeddsamir1234567@gmail.com", "123456");
		Assert.assertTrue(URP.registermessage.getText().contains("Your registration completed"));
		System.out.println("Registered with email " + email + " successfully!");
	}
	@Test(dependsOnMethods = {"succssfulRegisteration"})
	public void registerdUserLogout() {
		URP.userLogout();

			}
	@Test(dependsOnMethods = {"registerdUserLogout"})
	public void registerdUserLogin() {
		homepage.openLoginPage();
		login = new LoginPage(driver);
//		login.userLogin("ahmeddsamir1234567@gmail.com", "123456");
		login.userLogin(email, pass);
		Assert.assertTrue(URP.logoutLink.getText().contains("Log out"));
	}
}
