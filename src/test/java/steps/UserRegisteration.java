package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisteration extends TestBase{
HomePage home;
UserRegisterationPage URP;
LoginPage login ;

@Given("the user is in the home page")
public void the_user_is_in_the_home_page() {
    home = new HomePage(driver);
    URP= new UserRegisterationPage(driver);
}
@When("the user clicks on the register link")
public void the_user_clicks_on_the_register_link() {
    home.openRegisterationPage();
    assertTrue(driver.getCurrentUrl().contains("register"));
}

/*
 * @When("the user enters the user data") public void
 * the_user_enters_the_user_data() { URP.userRegister("ahmed", "samir",
 * "ahmed1@gmail.com", "123456"); }
 */
@When("the user enters {string},{string},{string},{string}")
public void the_user_enters(String firstname, String lastname, String email, String password) {
	URP.userRegister(firstname,lastname,email,password);
}
@Then("the registeration page should be displlayed successfully")
public void the_registeration_page_should_be_displlayed_successfully() {
    assertTrue(URP.registermessage.getText().contains("Your registration completed"));
    URP.userLogout();
}

}
