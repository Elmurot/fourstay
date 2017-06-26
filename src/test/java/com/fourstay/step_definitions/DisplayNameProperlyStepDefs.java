package com.fourstay.step_definitions;

import static org.junit.Assert.assertEquals;
import java.time.LocalTime;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class DisplayNameProperlyStepDefs {
	HomePage homePage = new HomePage();

	@Given("^the user is on the FourStay sign up dialog$")
	public void the_user_is_on_the_FourStay_sign_up_dialog() throws Throwable {
	    Driver.getInstance().get(Config.getProperty("url"));
	    homePage.signUpLink.click();
	}

	@Given("^the user enters enter first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
	public void the_user_enters_enter_first_name_and_last_name(String firstName, String lastName) throws Throwable {
		Page.sleep(500);
		homePage.firstName.sendKeys(firstName); 
		Page.sleep(500);
		homePage.lastName.sendKeys(lastName);
	}

	@Given("^the user enters any unregistered email and password$")
	public void the_user_enters_any_unregistered_email_and_password() throws Throwable {
	    String str = LocalTime.now().toString();
	    str = str.replaceAll(":","");
	    str = str.replaceAll("\\.", "");
	    String email = str + "jsmith@gmail.com";
	    homePage.signUpEmail.sendKeys(email);
	    homePage.signUpPassword.sendKeys("password");
	}

	@Given("^click on the Sign up button$")
	public void click_on_the_Sign_up_button() throws Throwable {
	    homePage.signUpBtn.click();
	}

	@Then("^first name \"([^\"]*)\" and last name \"([^\"]*)\" should be displayed$")
	public void first_name_and_last_name_should_be_displayed(String firstName, String lastName) throws Throwable {
	    String expected = firstName + " " + lastName;
	    UserAccountPage userAccountPage = new UserAccountPage();
	    Page.waitForElement(userAccountPage.accountHolderName, 10);
	    String actual = userAccountPage.accountHolderName.getText();
	    assertEquals(expected, actual);
	    
	}
	
	@Given("^the user clicks on the guest radio button$")
	public void the_user_clicks_on_the_guest_radio_button() throws Throwable {
	    homePage.signUpGuestRadioBtn.click();
	}

}
