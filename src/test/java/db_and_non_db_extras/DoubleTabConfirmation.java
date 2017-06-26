package db_and_non_db_extras;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fourstay.pages.HomePage;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;

public class DoubleTabConfirmation {
	WebDriver driver;
	TempMail tempMail;
	JavascriptExecutor jsx;
	HomePage homePage;
	String mainTab;
	@Before
	public void setUp() throws Exception {
		driver = Driver.getInstance();
		tempMail = new TempMail();
		jsx = (JavascriptExecutor)driver;
		homePage = new HomePage();
	}

	//@After
	public void tearDown() throws Exception {
		Page.sleep(3000);
		driver.close();
	}

	@Test
	public void test() {
		driver.get("https://temp-mail.org/en/");
		String email = tempMail.email.getAttribute("value");
		mainTab = driver.getWindowHandle();
		jsx.executeScript("window.open('http://fourstay.herokuapp.com','_blank');");
		switchToSecond();
		homePage.signUpLink.click();
		Page.sleep(500);
		homePage.firstName.sendKeys("Cyber");
		Page.sleep(400);
		homePage.lastName.sendKeys("Trump");
		homePage.signUpEmail.sendKeys(email);
		homePage.signUpPassword.sendKeys("CyberTrump");
		homePage.signUpBtn.click();
		
		driver.switchTo().window(mainTab);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(tempMail.firstInbox));
		String sender = tempMail.firstInbox.getText();
		if(sender.contains("4stay")){
			tempMail.firstInbox.click();
			assertTrue(tempMail.confirmation.isDisplayed());
		}
		System.out.println(tempMail.confirmation.getText());
		homePage.searchInsideAccount.sendKeys(tempMail.confirmation.getText());
		
	}
	
	private void switchToSecond(){
		String tempTab = driver.getWindowHandle();
		List<String> handles = new ArrayList<String>(driver.getWindowHandles());
		for(String handle: handles){
			if(!handle.equals(tempTab))
				driver.switchTo().window(handle);
		}
	}

}
