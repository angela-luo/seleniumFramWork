package dataDrivenTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationByJavaFaker extends TestBase{
	

	HomePage homepage;
	UserRegisterationPage URP;
	LoginPage login;
	
	Faker fakeData = new Faker();
	String firstName = fakeData.name().firstName();
	String lastName = fakeData.name().lastName();
	String email = fakeData.internet().emailAddress();
	String password = fakeData.number().digits(6).toString();
	 
	
	@Test(priority = 1)
	public void succssfulRegisteration() {
		homepage = new HomePage(driver);
		homepage.openRegisterationPage();
	    URP = new UserRegisterationPage(driver);
		URP.userRegister(firstName,lastName,email,password);
		System.out.println("the user data are : "+firstName+" "+lastName+" "+email+" "+password);
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
