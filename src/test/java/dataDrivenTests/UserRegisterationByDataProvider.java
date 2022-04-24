package dataDrivenTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationByDataProvider extends TestBase{

	HomePage homepage;
	UserRegisterationPage URP;
	LoginPage login;
	
	@DataProvider(name = "testData")
	public static Object[][] userRegisterationData(){
		return new Object[][] {{ "ahmed","samir","ahmed2@test.com","123456"	},
			{"mohammed","ali","mohammed2@test.com","123456"},
				{"khaled","walid","khaled2@test.com","123456"},
				{"samy","ezzat","samy2@test.com","123456"}};
	}
	@Test(dataProvider = "testData")
	public void succssfulRegisteration(String Fname,String Lname,String email,String password) {
		homepage = new HomePage(driver);
		homepage.openRegisterationPage();
	    URP = new UserRegisterationPage(driver);
		URP.userRegister(Fname,Lname,email, password);
		Assert.assertTrue(URP.registermessage.getText().contains("Your registration completed"));
		URP.userLogout();
		homepage.openLoginPage();
		login = new LoginPage(driver);
		login.userLogin(email, password);
		Assert.assertTrue(URP.logoutLink.getText().contains("Log out"));
URP.userLogout();
	}
	
	
}
