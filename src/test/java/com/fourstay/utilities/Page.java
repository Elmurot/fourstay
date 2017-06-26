package com.fourstay.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	
	public static void sleep(long millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void waitForElement(WebElement element, int seconds){
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForClickable(WebElement element, int seconds){
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForPageToLoad(){
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.se-pre-con")));
	}

}
