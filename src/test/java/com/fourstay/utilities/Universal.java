package com.fourstay.utilities;

import static com.fourstay.utilities.Page.sleep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Universal {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public Universal(){
		this.driver = Driver.getInstance();
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(css = "iframe.intercom-borderless-frame")
	WebElement supportWindow;
	
	@FindBy(css = "div.intercom-blocks")
	WebElement iFrameMessage;
	
	@FindBy(css = "div.intercom-borderless-dismiss-button")
	WebElement closeMessage;
	
	public void closeSupportWindow(int secondsToShowUp) {
		Page.waitForElement(supportWindow, secondsToShowUp);
		driver.switchTo().frame(supportWindow);
		iFrameMessage.click();
		sleep(200);
		closeMessage.click();
		driver.switchTo().defaultContent();
	}
	
	
}












