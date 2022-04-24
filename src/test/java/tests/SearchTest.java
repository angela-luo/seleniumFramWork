package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchTest extends TestBase{
	
	String productName="Apple MacBook Pro 13-inch";
			
	@Test
	public void search() {
		SearchPage search = new SearchPage(driver);
		search.searchForProduct(productName);
		search.oprnProductDetailsPage();
		ProductDetailsPage details = new ProductDetailsPage(driver);
		Assert.assertEquals(productName, details.macbookTitle.getText());
	}
 
}
