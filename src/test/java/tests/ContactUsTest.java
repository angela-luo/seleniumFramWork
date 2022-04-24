package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage home;
	ContactUsPage contact;
	String name = "ahmed samir";
	String email = "test@test.com";
	String text = "the user can contact us from here ";
	@Test
	public void userCanContactUs() {
		home = new HomePage(driver);
		home.openContatusPage();
		contact = new ContactUsPage(driver);
		contact.contactUs(name, email, text);
		Assert.assertTrue(contact.successMsg.getText().contains("Your enquiry has been successfully sent to the store owner"));
		
	}
	
}
