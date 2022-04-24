package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
@FindBy(tagName = "h1")
public WebElement macbookTitle;

@FindBy(css="button.button-2.email-a-friend-button")
WebElement emailToFriend;
public void openEmailToFriendPage() {
	clickBTN(emailToFriend);
}
@FindBy(id="price-value-4")
public WebElement priceInEuro;
@FindBy(linkText = "Add your review")
WebElement addReview;
public void openReviewPage() {
	clickBTN(addReview);
}
@FindBy(id="add-to-wishlist-button-4")
WebElement addToWishList;
public void AddToWishList() {
	clickBTN(addToWishList);
}
@FindBy(linkText = "Wishlist")
WebElement wishListLink;
public void goToWishListPage() {
	clickBTN(wishListLink);
}
@FindBy(css = "button.button-2.add-to-compare-list-button")
WebElement addToCompareList;
public void AddToCompareList() {
	clickBTN(addToCompareList);
}
@FindBy(linkText = "product comparison")
WebElement productComparison;
public void goToProductComparisonPage() {
	clickBTN(productComparison);
}
@FindBy(id="add-to-cart-button-4")
WebElement addToCartBtn;
public void addProductToCart() {
	clickBTN(addToCartBtn);
}
@FindBy(linkText = "Shopping cart")
WebElement shoppingCartLink;
public void goToShoppingCart() {
	clickBTN(shoppingCartLink);
}

}
