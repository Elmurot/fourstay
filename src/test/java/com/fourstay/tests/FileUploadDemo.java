package com.fourstay.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;

public class FileUploadDemo {
    // With selenium no DOWNLOADING 
	// THE farthest selenium can go is --> clicking the download button or link 
	
	// Tools used to automate file download: Wget, Robot, AutoIT
	
	WebDriver driver;
	@Test
	public void upload(){
		driver = Driver.getInstance();
		driver.get("http://the-internet.herokuapp.com/upload");
		WebElement chooseFile = driver.findElement(By.cssSelector("input#file-upload"));
		WebElement uploadBtn = driver.findElement(By.cssSelector("input#file-submit"));
		Actions act = new Actions(driver);
		String projectFolder = System.getProperty("user.dir");
		String textFile = "/src/test/resources/com/fourstay/test_data/test.txt";
		String imgFile = "/src/test/resources/com/fourstay/test_data/image.jpg";
		System.out.println(projectFolder);
		System.out.println(projectFolder + textFile);
		Page.sleep(3000);
		chooseFile.sendKeys(projectFolder + textFile);
		Page.sleep(3000);		
		uploadBtn.click();
	}
}
