package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToCompareListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class compareProductsTest extends TestBase{

	SearchPage search;
	ProductDetailsPage details;
	AddToCompareListPage compare;
	String firstProductName="Apple MacBook Pro 13-inch";
	String secondProductName="Asus N551JK-XO076H Laptop";
	
	@Test(priority = 1)
	public void searchingForTheFirstProduct() {
	    search = new SearchPage(driver);
		details = new ProductDetailsPage(driver);
		try {
			search.searchUsingAutoSuggest("mac");
			Assert.assertEquals(firstProductName,details.macbookTitle.getText());
		} catch (InterruptedException e) {
			System.out.println("error occured! "+e.getMessage());
		}
		details.AddToCompareList();
	}
	@Test(priority = 2)
	public void searchingForTheSecondProduct() {
	    search = new SearchPage(driver);
		details = new ProductDetailsPage(driver);
		try {
			search.searchUsingAutoSuggest("asus");
			Assert.assertEquals(secondProductName,details.macbookTitle.getText());
		} catch (InterruptedException e) {
			System.out.println("error occured! "+e.getMessage());
		}
		details.AddToCompareList();
		details.goToProductComparisonPage();
	}
	@Test(priority = 3)
	public void compareProducts() {
		compare = new AddToCompareListPage(driver);
		assertTrue(compare.asusName.getText().contains("Asus N551JK-XO076H Laptop"));
		assertTrue(compare.macName.getText().contains("Apple MacBook Pro 13-inch"));
        compare.compareProducts();
	}
	@Test(priority = 4)
	public void clearCompareList() {
		compare.cleareCompareList();
		assertTrue(compare.clearMsg.getText().contains("You have no items to compare"));
	}
}
