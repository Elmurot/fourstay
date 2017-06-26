package com.fourstay.step_definitions;

import com.fourstay.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Uptake_Homepage_contactPage {
	

@When("^user goes to uptake homepage$")
public void user_goes_to_uptake_homepage() throws Throwable {
    Driver.getInstance().get("http://uptake.com");
}

@Then("^user clicks on contact button$")
public void user_clicks_on_contact_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^user should be able to see contact page$")
public void user_should_be_able_to_see_contact_page() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^user navigates back$")
public void user_navigates_back() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Then("^user should see uptake homepage$")
public void user_should_see_uptake_homepage() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}



}
