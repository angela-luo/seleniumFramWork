package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCompareListPage extends PageBase{

	public AddToCompareListPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="a.clear-list")
	WebElement clearListBtn;
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	public WebElement macName;
	@FindBy(linkText = "Asus N551JK-XO076H Laptop")
	public WebElement asusName;
	@FindBy(css="div.no-data")
	public WebElement clearMsg;
	@FindBy(tagName = "tr")
	List<WebElement> rows;
	@FindBy(tagName = "td")
	List<WebElement>cols;
	public void compareProducts() {
		
		for(WebElement row : rows) {
			System.out.println(row.getText()+"/t");
			for(WebElement col:cols) {
				System.out.println(col.getText()+"/t");
			}
			
		}
	}
	public void cleareCompareList() {
		clickBTN(clearListBtn);
	}

}
