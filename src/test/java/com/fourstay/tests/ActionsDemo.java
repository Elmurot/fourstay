package com.fourstay.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;
import com.fourstay.utilities.Universal;

public class ActionsDemo {
	WebDriver driver = Driver.getInstance();
	
	//@Test
	public void hoverOver(){
		HomePage homePage = new HomePage();
		homePage.open();
		homePage.login("sking@testmail.com", "password");
		Page.waitForPageToLoad();
		// Actions class provides advanced user interaction such as 
		// double click, mouse hover, drag and drop ...
		Actions act = new Actions(driver);
		Universal uni = new Universal();
		UserAccountPage userAccountPage = new UserAccountPage();
		uni.closeSupportWindow(5);
		Page.sleep(2000);
		act.moveToElement(userAccountPage.profilePicture).perform();
		userAccountPage.editProfile.click();
		
	}
	
	//@Test
	public void dragAndDropTest(){
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions actions = new Actions(driver);
		Page.sleep(2000);
		actions.dragAndDrop(source, target).perform();
		
	}

	@Test
	public void scrollToElement(){
		driver.get("https://the-internet.herokuapp.com");
		Page.sleep(2000);
		WebElement link = driver.findElement(By.linkText("Nested Frames"));
		Actions actions = new Actions(driver);
		//actions.moveToElement(link).perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", link);
	}
	
}









