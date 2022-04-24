package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailToFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailToFriendTest extends TestBase {


	HomePage homepage;
	UserRegisterationPage URP;
	SearchPage search;
	ProductDetailsPage details;
	EmailToFriendPage emailObject;
	String productName="Apple MacBook Pro 13-inch";
	String firstName="Ahmed";
	String lastName="samir";
	String email="ahmed1@gmail.com";
	String pass="123456";
	
	@Test(priority = 1)
	public void succssfulRegisteration() {
		homepage = new HomePage(driver);
		homepage.openRegisterationPage();
	    URP = new UserRegisterationPage(driver);
		URP.userRegister(firstName,lastName, email, pass);
		Assert.assertTrue(URP.registermessage.getText().contains("Your registration completed"));
	}
	@Test(priority = 2)
	public void searchingWithAutoSuggest() {
	    search = new SearchPage(driver);
	    details = new ProductDetailsPage(driver);
		try {
			search.searchUsingAutoSuggest("mac");
			Assert.assertEquals(productName,details.macbookTitle.getText());
		} catch (InterruptedException e) {
			System.out.println("error occured! "+e.getMessage());
		}
}
	@Test(priority = 3)
	public void EmailProductToFriend() {
	details.openEmailToFriendPage();
	emailObject = new EmailToFriendPage(driver);
	emailObject.emailToFriend("aaa@test.com", "hello my friend , this product will blow your mind");
	assertTrue(emailObject.successMsg.getText().contains( "Your message has been sent"));
	}
	}
