package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewpage extends PageBase{

	public ProductReviewpage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="AddProductReview_Title")
	WebElement title;
	@FindBy(id="AddProductReview_ReviewText")
	WebElement textBox;
	@FindBy(id="addproductrating_3")
	WebElement rating;
	@FindBy(name = "add-review")
	WebElement submitBtn;
	@FindBy(css="div.result")
	public WebElement successMsg;
	public void sendReview(String Title,String text) {
		sendTxtToElement(title, Title);
		sendTxtToElement(textBox, text);
		clickBTN(rating);
		clickBTN(submitBtn);
	}

}
