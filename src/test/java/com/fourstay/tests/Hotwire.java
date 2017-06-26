package com.fourstay.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.fourstay.utilities.Driver;

public class Hotwire {

	WebDriver driver = Driver.getInstance();
	@Test
	public void rightClick(){
		driver.get("http://hotwire.com");
		WebElement carsLink = driver.findElement(By.linkText("Cars"));
		Actions actions = new Actions(driver);
		WebElement destination = driver.findElement(By.xpath("(//input[@name='destCity'])[1]"));
		actions.moveToElement(carsLink).contextClick().perform();
		
	
	}
}
