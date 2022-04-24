package dataDrivenTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.JsonReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationByJsonFile extends TestBase{

	
	HomePage homepage;
	UserRegisterationPage URP;
	LoginPage login;
	
	@Test()
	public void succssfulRegisteration() throws FileNotFoundException, IOException, ParseException {
		JsonReader reader= new  JsonReader();
		 reader.jsonReader();
		
		homepage = new HomePage(driver);
		homepage.openRegisterationPage();
	    URP = new UserRegisterationPage(driver);
		URP.userRegister(reader.firstName,reader.lastName,reader.email,reader.password);
		Assert.assertTrue(URP.registermessage.getText().contains("Your registration completed"));
		URP.userLogout();
		homepage.openLoginPage();
		login = new LoginPage(driver);
		login.userLogin(reader.email,reader.password);
		Assert.assertTrue(URP.logoutLink.getText().contains("Log out"));
		URP.userLogout();

	}
}
