package com.fourstay.tests;

import static com.fourstay.utilities.Page.sleep;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.fourstay.pages.HomePage;
import com.fourstay.utilities.Config;

public class NegativeLoginTests {

	WebDriver driver;
	HomePage homePage;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty(Config.getProperty("webdriver"), Config.getProperty("driverPath"));
		driver = new ChromeDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
	}
	
	@Test
	public void invalidPasswordTest(){
		homePage.loginLink.click();
		sleep(400);
		homePage.email.sendKeys(Config.getProperty("guest_username"));
		sleep(450);
		homePage.password.sendKeys("12345");
		sleep(300);
		homePage.loginBtn.click();
		sleep(1000);
		assertTrue(homePage.email.isDisplayed());
	}
	
	@Test
	public void invalidUserNameTest(){
		homePage.login("thisisbadusername@gmail.com", Config.getProperty("guest_password"));
		assertTrue(homePage.email.isDisplayed());

	}
	
	@After
	public void tearDown(){
		sleep(2000);
		driver.close();
	}
	
}










