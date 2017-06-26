package com.fourstay.step_definitions;

import static org.junit.Assert.assertTrue;
import com.fourstay.pages.HomePage;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInWithSocialAccountStepDefs {

	@Given("^the user is on the home page$")
	public void the_user_is_on_the_home_page() throws Throwable {
	   Driver.getInstance().get(Config.getProperty("url"));
	}

	@When("^the user clicks on the SIGN IN link$")
	public void the_user_clicks_on_the_SIGN_IN_link() throws Throwable {
	    HomePage homePage = new HomePage();
	    homePage.loginLink.click();
	}

	@Then("^the Sign in with Facebook account option should be available$")
	public void the_Sign_in_with_Facebook_account_option_should_be_available() throws Throwable {
	    HomePage homePage = new HomePage();
		assertTrue(homePage.facebookSignInLink.isDisplayed());
	}
	
	@Then("^the Sign in with Google account option should be available$")
	public void the_Sign_in_with_Google_account_option_should_be_available() throws Throwable {
	   HomePage homePage = new HomePage();
	   assertTrue(homePage.googleSingInLink.isDisplayed());
	}

}
