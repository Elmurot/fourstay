package com.fourstay.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fourstay.models.User;
import com.fourstay.pages.GeneralAccountSettings;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;
import com.fourstay.utilities.Universal;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserLoginStepDefs {
	WebDriver driver = Driver.getInstance();
	
	HomePage homePage = new HomePage();
    GeneralAccountSettings accountSettings = new GeneralAccountSettings();

	@Given("^the user is on the FourStay homepage$")
	public void the_user_is_on_the_FourStay_homepage() throws Throwable {
	    homePage.open();
	   
	    
	}

	@Given("^the user signs in using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_signs_in_using_and(String email, String password) throws Throwable {
	    homePage.login(email, password);
	    
	}

	@When("^the user goes to the user general settings page$")
	public void the_user_goes_to_the_user_general_settings_page() throws Throwable {
	    UserAccountPage userAccountPage = new UserAccountPage();
	    Page.waitForPageToLoad();
	    userAccountPage.profilePicture.click();
	    userAccountPage.editProfile.click();
	}

	@Then("^the user full name should be \"([^\"]*)\" \"([^\"]*)\"$")
	public void the_user_full_name_should_be(String firstName, String lastName) throws Throwable {
	    Page.waitForPageToLoad();
	    
	    assertEquals(firstName, accountSettings.firstNameInputBox.getAttribute("value"));
	    assertEquals(lastName, accountSettings.lastNameInputBox.getAttribute("value"));

	}

	@Then("^the user phone number should be \"([^\"]*)\"$")
	public void the_user_phone_number_should_be(String phoneNumber) throws Throwable {
	    assertEquals(phoneNumber, accountSettings.phoneNumber.getAttribute("value"));
	}

	@Then("^the user email should be \"([^\"]*)\"$")
	public void the_user_email_should_be(String email) throws Throwable {
	    assertEquals(email, accountSettings.emailBox.getAttribute("value"));
	}
	
	@Then("^bed options should have the following entries:$")
	public void bed_options_should_have_the_following_entries(List<String> list) throws Throwable {
	    System.out.println(list.size());
	    for(String option: list)
	    	System.out.println(option);
	    Universal uni = new Universal();
	    uni.closeSupportWindow(10);
	    homePage.body.click();
	    homePage.bedsBtn.click();
	    List<WebElement> options = homePage.bedOptions;
	    for(WebElement option: options){
	    	System.out.println(option.getText());
	    }
	    for(int i = 0; i < list.size(); i++){
	    	assertEquals(list.get(i), options.get(i).getText());
	    }
	}
	
	@Then("^the user information should be displayed on general settings page$")
	public void the_user_information_should_be_displayed_on_general_settings_page(List<User> users) throws Throwable {
	    System.out.println(users.size());
	    
	    for(User user: users){
	    	System.out.println(user.getFirstName());
	    	System.out.println(user.getLastName());
	    	System.out.println(user.getEmail());
	    	System.out.println(user.getPassword());
	    	System.out.println(user.getPhoneNumber());
	    	System.out.println("*********************");
	    }
	}

	
	
	
	
}






