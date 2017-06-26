package com.fourstay.step_definitions;

import java.util.List;

import org.openqa.selenium.By;

import com.fourstay.models.UserModule;
import com.fourstay.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class fannie_mae_negative_register_step_defs {


@Given("^User is on homepage$")
public void user_is_on_homepage() throws Throwable {
    // go to homepage 
	Driver.getInstance().findElement(By.id("")).sendKeys("esen");
}

@Given("^I click on \"([^\"]*)\" link$")
public void i_click_on_link(String arg1) throws Throwable {
    // click on to link
}

@Then("^I register with wrong information and I should see proper message$")
public void i_register_with_wrong_information_and_I_should_see_proper_message(List<UserModule> users) throws Throwable {
	// users is full of users with some empty information
	// Select s = new Select(dropdown company);
		
	// 
		// Create object of registration page regPage
		for(UserModule user: users){
			System.out.println(user.getCity());
			// regPage.email.clear
			// regPage.email.sendkeys(user.getEmail())
			// regPage.pwd.sendkeys(user.getPwd())
			// regPage.firstName.sendkeys(user.getFirstName())
			// s.selectByVisibleText(user.getCompanyType());
			// bla- bla 
			// rs.seuser.get
			// You can control blank information from feature file
			// just leave | | -> empty 
			
			// regPage.register.click
			
			//String actual =  regPage.errorMessage.gettext()
			// assert come up with proper logic according to what message it gives you 
			// assertequal ( user.getErrormessage())
			
			
		}
   }

}
