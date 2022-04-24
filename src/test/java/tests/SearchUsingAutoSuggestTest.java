package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchUsingAutoSuggestTest extends TestBase {

	SearchPage search;
	String productName="Apple MacBook Pro 13-inch";
	
	@Test
	public void searchingWithAutoSuggest() {
	    search = new SearchPage(driver);
		ProductDetailsPage details = new ProductDetailsPage(driver);
		try {
			search.searchUsingAutoSuggest("mac");
			Assert.assertEquals(productName,details.macbookTitle.getText());
		} catch (InterruptedException e) {
			System.out.println("error occured! "+e.getMessage());
		}
	}
}
