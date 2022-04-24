package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddProductToWishListPage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToWishListTest extends TestBase{

	SearchPage search;
	ProductDetailsPage details;
	AddProductToWishListPage wishlistOpject;
	String productName="Apple MacBook Pro 13-inch";
	
	@Test(priority = 1)
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
	@Test(priority = 2)
	public void addProductToWishList() {
		details.AddToWishList();
		details.goToWishListPage();
		wishlistOpject=new AddProductToWishListPage(driver);
		assertTrue(wishlistOpject.productName.getText().contains("Apple MacBook Pro 13-inch"));
		assertTrue(wishlistOpject.title.getText().contains("Wishlist"));
	}
	@Test(priority = 3)
	public void removeProductFromWishlist() {
		wishlistOpject.removeAndUpdateWishList();
		assertTrue(wishlistOpject.successMsg.getText().contains("The wishlist is empty!"));
	}
}
