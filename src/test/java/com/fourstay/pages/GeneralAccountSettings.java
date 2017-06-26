package com.fourstay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Driver;

public class GeneralAccountSettings {
	
	private WebDriver driver;
	
	public GeneralAccountSettings(){
		this.driver = Driver.getInstance();
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "(//input[contains(@ng-model, 'email')])[2]")
	public WebElement emailBox;
	
	@FindBy (css = "[ng-model*='FirstName']")
	public WebElement firstNameInputBox;
	
	@FindBy(css = "[ng-model*='LastName']")
	public WebElement lastNameInputBox;
	
	@FindBy(xpath = "(//input[contains(@ng-model, 'phone')])[2]")
	public WebElement phoneNumber;
	
	@FindBy(css = "ng-model*='aboutme']")
	public WebElement aboutMeInputBox;
	

}
