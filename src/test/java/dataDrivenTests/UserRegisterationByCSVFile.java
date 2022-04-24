package dataDrivenTests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationByCSVFile extends TestBase{

	
	HomePage homepage;
	UserRegisterationPage URP;
	LoginPage login;
	
	CSVReader reader;
	@Test(priority = 1)
	public void succssfulRegisteration() throws CsvValidationException, IOException {
		String CSV_File = System.getProperty("user.dir")+"/src/test/java/data/Book.csv";
		reader = new CSVReader(new FileReader(CSV_File));
		
		String[] CSVCell;
		while((CSVCell= reader.readNext())!= null){
			String firstName = CSVCell[0];
			String lastName = CSVCell[1];
			String email = CSVCell[2];
			String password = CSVCell[3];
			homepage = new HomePage(driver);
		homepage.openRegisterationPage();
	    URP = new UserRegisterationPage(driver);
		URP.userRegister(firstName,lastName,email,password);
		Assert.assertTrue(URP.registermessage.getText().contains("Your registration completed"));
		URP.userLogout();
		homepage.openLoginPage();
		login = new LoginPage(driver);
		login.userLogin(email,password);
		Assert.assertTrue(URP.logoutLink.getText().contains("Log out"));
		URP.userLogout();
		}
		
	}
}
