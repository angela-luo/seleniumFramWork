package dataDrivenTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationByExcelFile extends TestBase {

	HomePage homepage;
	UserRegisterationPage URP;
	LoginPage login;
	
	@DataProvider(name = "userdata")
	public Object[][] userRegisterData() throws IOException{
		ExcelReader er = new ExcelReader();
		return er.getExcelData();
		
	}
	
	@Test(dataProvider = "userdata")
	public void succssfulRegisteration(String Fname,String Lname,String email, String pw) {
		homepage = new HomePage(driver);
		homepage.openRegisterationPage();
	    URP = new UserRegisterationPage(driver);
		URP.userRegister(Fname,Lname,email,pw);
		Assert.assertTrue(URP.registermessage.getText().contains("Your registration completed"));
		URP.userLogout();
		homepage.openLoginPage();
		login = new LoginPage(driver);
		login.userLogin(email,pw);
		Assert.assertTrue(URP.logoutLink.getText().contains("Log out"));
		URP.userLogout();
	}
	
	
	
}
