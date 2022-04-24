package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase{

	SearchPage search;
	ProductDetailsPage details;
	ShoppingCartPage cart;
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
	public void testingShoppingCart() throws InterruptedException {
		details.addProductToCart();
		details.goToShoppingCart();
		cart = new ShoppingCartPage(driver);
		assertTrue(cart.productName.getText().contains(productName));
		Thread.sleep(1000);
		if (cart.itemQuantity.isDisplayed())
		cart.changeQuantity("4");
		assertTrue(cart.totalPrice.getText().contains("$7,200"));
	}
	@Test(priority = 3)
	public void removingProduct() {
		cart.removeProduct();
		assertTrue(cart.clearMsg.getText().contains("Your Shopping Cart is empty!"));
	}
}
