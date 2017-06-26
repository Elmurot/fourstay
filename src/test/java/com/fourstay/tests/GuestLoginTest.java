package com.fourstay.tests;

import java.util.concurrent.TimeUnit;
import static com.fourstay.utilities.Page.*;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Config;

public class GuestLoginTest {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty(Config.getProperty("webdriver"), Config.getProperty("driverPath"));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void guestLoginTest() {
		// Create the home page object
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		// PageFactory class is from selenium it enables the page object model
		// ( POM )
		// init elements initializes the page object class with the weblements 
		// initElements makes the FindBy work
		
		homePage.loginLink.click();
		homePage.email.sendKeys(Config.getProperty("guest_username"));
		sleep(500);
		homePage.password.sendKeys(Config.getProperty("guest_password"));
		sleep(300);
		homePage.loginBtn.click();
		
		// page object for user account page
		UserAccountPage userAccountPage = PageFactory.initElements(driver, UserAccountPage.class);
		assertTrue(userAccountPage.accountHolderName.isDisplayed());
		
		String expected = "Currently no listings reserved by ";
		String actual = userAccountPage.message.getText();
		assertTrue(actual.startsWith(expected));
		
	}

}








