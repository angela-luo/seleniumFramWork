package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdeDetails extends PageBase{

	public OrdeDetails(WebDriver driver) {
		super(driver);
	}

	@FindBy(css="a.button-2.print-order-button")
	WebElement printBtn;
	@FindBy(css="a.button-2.pdf-invoice-button")
	WebElement PDFBtn;
	public void print() {
		clickBTN(printBtn);
	}
	public void getPDF() {
		clickBTN(PDFBtn);
	}
}
