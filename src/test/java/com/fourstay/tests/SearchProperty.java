package com.fourstay.tests;

import static com.fourstay.utilities.Page.sleep;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fourstay.pages.HomePage;
import com.fourstay.utilities.Config;

public class SearchProperty {
	WebDriver driver;
	HomePage homepage;
	JavascriptExecutor jsx;

	@Before
	public void setUp() {
		System.setProperty(Config.getProperty("webdriver"),Config.getProperty("driverPath"));		
		driver = new ChromeDriver();
		jsx = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homepage = PageFactory.initElements(driver, HomePage.class);
		driver.get(Config.getProperty("url"));
		jsx.executeScript("window.scrollBy(0,450)", "");
	
	}

	@Test
	public void positiveSearch() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("iframe.intercom-borderless-frame"))));
		closeSupportWindow();
		
		homepage.schoolName.sendKeys("vienna");
		homepage.setMoveInDate(3, 20, 2017);
		homepage.setMoveOutDate(4, 20, 2017);
		sleep(2000);
		homepage.setBedNumber(9);
		homepage.searchBtn.click();
				
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		sleep(2000);
		driver.close();
		driver.switchTo().window(windowHandles.get(1));
		assertEquals(driver.getTitle(),"4stay");
		closeSupportWindow();
	}

	private void closeSupportWindow() {
		WebElement supportIFrame = driver.findElement(By.cssSelector("iframe.intercom-borderless-frame"));
		driver.switchTo().frame(supportIFrame);
		driver.findElement(By.cssSelector("div.intercom-blocks")).click();
		sleep(200);
		driver.findElement(By.cssSelector("div.intercom-borderless-dismiss-button")).click();
		driver.switchTo().defaultContent();
		
	}

}
