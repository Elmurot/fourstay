package com.fourstay.step_definitions;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PositiveLoginTestStepDefs {
	
	WebDriver driver;
	
	@Given("^I am on the fourstay homepage$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {
		driver = Driver.getInstance();//.get(Config.getProperty("url"));
		
		
	}

	@When("^I login as a host$")
	public void i_login_as_a_host() throws Throwable {
	   // home page object
		HomePage homePage = new HomePage();
		String userName = Config.getProperty("host_username");
		String userPassword = Config.getProperty("host_password");
		homePage.login(userName, userPassword);
		Page.sleep(3000);
	}

	@Then("^I should be able to verify that I logged in$")
	public void i_should_be_able_to_verify_that_I_logged_in() throws Throwable {
	  // User account page object
		UserAccountPage userAccountPage = new UserAccountPage();
		assertTrue(userAccountPage.accountHolderName.isDisplayed());
		Driver.closeDriver();
	}
	
	@When("^I login as a guest$")
	public void i_login_as_a_guest() throws Throwable {
		// home page object
		HomePage homePage = new HomePage();
		String userName = Config.getProperty("guest_username");
		String userPassword = Config.getProperty("guest_password");
		homePage.login(userName, userPassword);
		Page.sleep(3000);
	    
	}

}
