package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{
HomePage home;
SearchPage search;
ProductDetailsPage details;
String productName="Apple MacBook Pro 13-inch";
	@Test(priority = 1)
	public void userCanChangeCurrency() {
		home = new HomePage(driver);
		home.changeCurrency();
	}
	@Test(priority = 2)
	public void searchingWithAutoSuggest() {
	    search = new SearchPage(driver);
		details = new ProductDetailsPage(driver);
		try {
			search.searchUsingAutoSuggest("mac");
			Assert.assertEquals(productName,details.macbookTitle.getText());
			Assert.assertTrue(details.priceInEuro.getText().contains("€"));
			System.out.println(details.priceInEuro.getText());
		} catch (InterruptedException e) {
			System.out.println("error occured! "+e.getMessage());
		}
	}
}
