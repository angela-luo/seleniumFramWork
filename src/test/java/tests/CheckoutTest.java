package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.OrdeDetails;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;

public class CheckoutTest extends TestBase{

	HomePage homepage;
	UserRegisterationPage URP;
	SearchPage search;
	ProductDetailsPage details;
	ShoppingCartPage cart;
	CheckoutPage checkout;
	String productName="Apple MacBook Pro 13-inch";
	String firstName="Ahmed";
	String lastName="samir";
	String email="ahmedsami2@gmail.com";
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
	public void ShoppingCart() {
		details.addProductToCart();
		details.goToShoppingCart();
		cart = new ShoppingCartPage(driver);
		assertTrue(cart.productName.getText().contains(productName));
		cart.goToCheckoutPage();
	}
	@Test(priority = 4)
	public void checkoutCompletion() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		checkout = new CheckoutPage(driver);
		checkout.registeredUserCheckOutProcess("Sers Ellyan","Barakat St", "641616", "651981");
		Thread.sleep(3000);
		assertTrue(checkout.productName.getText().equals(productName));
		checkout.confirmPayment();
		//assertTrue(driver.getCurrentUrl().contains("checkout/completed"));
		checkout.goToOrderDetails();
		OrdeDetails order = new OrdeDetails(driver);
		assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		order.getPDF();
		order.print();
	}
}
