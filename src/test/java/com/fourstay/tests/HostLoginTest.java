package com.fourstay.tests;

import static com.fourstay.utilities.Page.sleep;
import static org.junit.Assert.assertTrue;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;

public class HostLoginTest {
	
WebDriver driver;
HomePage homePage;
	
	@Before
	public void setUp() throws Exception {
		driver = Driver.getInstance();
		// Create HomePage object 
		homePage = new HomePage();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Config.getProperty("url"));
	}

	@After
	public void tearDown() throws Exception {
		sleep(2000);
		driver.close();
		
	}

	@Test
	public void guestLoginTest() {
		
		homePage.loginLink.click();
		sleep(500);
		homePage.email.sendKeys(Config.getProperty("host_username"));
		sleep(500);
		homePage.password.sendKeys(Config.getProperty("host_password"));
		sleep(500);
		homePage.loginBtn.click();
		
		// Creating the UserAccountPage object
		UserAccountPage userAccountPage = new UserAccountPage();
		assertTrue(userAccountPage.accountHolderName.isDisplayed());

		String expected = "Currently no listings by ";
		String actual = userAccountPage.message.getText();
		assertTrue(actual.startsWith(expected));
		
	}

}
