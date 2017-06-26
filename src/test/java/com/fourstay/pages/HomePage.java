package com.fourstay.pages;

import static com.fourstay.utilities.Page.sleep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;

public class HomePage {
	// page object class
	// Holds all the web elements in the main actions from that page

	private WebDriver driver;

	public HomePage() {
		this.driver = Driver.getInstance();
		PageFactory.initElements(this.driver, this);
	}

	// HomePage main webelements
	// css, id, name, tagName, className, linkText, partialLinkText, xpath
	@FindBy(xpath = "//img[@alt='HStay Logo']")
	public WebElement homeBtn;

	@FindBy(css = "li[data-target='#modal-login']")
	public WebElement loginLink;

	@FindBy(id = "email")
	public WebElement email;

	@FindBy(id = "key")
	public WebElement password;

	@FindBy(id = "btn-login")
	public WebElement loginBtn;

	@FindBy(id = "iLocName")
	public WebElement schoolName;

	@FindBy(name = "move_in")
	public WebElement moveIn;

	@FindBy(name = "move_out")
	public WebElement moveOut;

	@FindBy(css = "button#themates")
	public WebElement bedsBtn;

	@FindBy(xpath = "//ul[@id='theoption']//li")
	public List<WebElement> bedOptions;

	@FindBy(css = "input#search")
	public WebElement searchBtn;

	@FindBy(xpath = "//body[@class='new-home-page ng-scope']")
	public WebElement body;
	
	@FindBy(css = "a.btn-facebook")
	public WebElement facebookSignInLink;
	
	@FindBy(css = "a.btn-google-plus")
	public WebElement googleSingInLink;
	
	@FindBy(css = "li[data-target='#modal-signup']")
	public WebElement signUpLink;
	
	@FindBy(id = "FirstName")
	public WebElement firstName;
	
	@FindBy(id = "LastName")
	public WebElement lastName;
	
	@FindBy(css = "#modal-signup #email")
	public WebElement signUpEmail;
	
	@FindBy(css = "#modal-signup #key")
	public WebElement signUpPassword;
	
	@FindBy(id = "btn-signup")
	public WebElement signUpBtn;
	
	@FindBy(css = "input#guest")
	public WebElement signUpGuestRadioBtn;
	
	@FindBy (id = "hLocName")
	public WebElement searchInsideAccount;
	

	public void setMoveInDate(int month, int day, int year) {
		String date = month + "/" + day + "/" + year;
		moveIn.click();
		moveIn.sendKeys(date);
	}

	public void setMoveOutDate(int month, int day, int year) {
		String date = month + "/" + day + "/" + year;
		moveOut.click();
		moveOut.sendKeys(date);
	}

	public void setBedNumber(int bedNum) {
		if (bedNum > 6) {
			driver.findElement(By.xpath("(//ul)[2]/li[7]")).click();

		} else if (bedNum >= 1 && bedNum <= 6) {
			String xPath = "(//ul)[2]/li[" + bedNum + "]";
			driver.findElement(By.xpath(xPath)).click();

		} else {
			throw new RuntimeException("Invalid Bed Number Argument");
		}
	}

	// homepage login functionality for 4stay
	public void login(String userName, String userPassword) {
		loginLink.click();
		sleep(450);
		email.sendKeys(userName);
		sleep(450);
		password.sendKeys(userPassword);
		sleep(450);
		loginBtn.click();

	}
	
	public void open(){
		Driver.getInstance().get(Config.getProperty("url"));
	}

}
