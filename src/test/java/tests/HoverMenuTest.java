package tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;

public class HoverMenuTest extends TestBase {

	HomePage home;
	 @Test
	 public void userCanChoseFromHoverList() {
		 home = new HomePage(driver);
		 home.hoverMenu();
		 assertTrue(driver.getCurrentUrl().contains("notebooks"));
	 }
}
