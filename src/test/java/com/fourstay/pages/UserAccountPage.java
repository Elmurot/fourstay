package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class UserAccountPage {
	private WebDriver driver;
	
	public UserAccountPage(){
		this.driver = Driver.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "h3.user-name")
	public WebElement accountHolderName;
	
	@FindBy (css = "div[class='col-md-10 col-md-offset-1 zrl-padding dave-listings large-section-container']")
	public WebElement message;
	
	@FindBy (css = "[ng-if='userImage']")
	public WebElement profilePicture;
	
	@FindBy (linkText = "Edit Profile")
	public WebElement editProfile;

}
