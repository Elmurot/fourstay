package db_and_non_db_extras;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;

//import static org.junit.Assert.assertThat;

public class Alert_Actions {
	
	WebDriver driver = Driver.getInstance();
	
	@Test
	public void test(){

		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
		WebElement popUp = driver.findElement(By.cssSelector("button#alert"));
		WebElement newWindow = driver.findElement(By.id("button1"));
		WebElement newTab = driver.findElement(By.xpath("//button[.='New Browser Tab']"));
		WebElement newMessageWindow = driver.findElement(By.xpath("//button[.='New Message Window']"));
		String mainPage = driver.getWindowHandle();
		Actions act = new Actions(driver);
		Select s = new Select(newWindow);
		
		
		popUp.click();
		Alert mAlert = driver.switchTo().alert();
		Page.sleep(3000);
		
		
		WebElement home = Driver.getInstance().findElement(By.linkText("Home"));
		//act.moveToElement(home).perform();
		act.contextClick(home).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		//Driver.getInstance().switchTo().alert();
		
		
//		Driver.getInstance().findElement(By.cssSelector("button#alert")).click();
//		Driver.closeDriver();
		

	}

	
}
