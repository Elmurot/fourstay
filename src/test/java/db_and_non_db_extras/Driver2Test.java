package db_and_non_db_extras;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.fourstay.utilities.Config;
import com.fourstay.utilities.Driver;
import com.fourstay.utilities.Page;

public class Driver2Test {
	WebDriver driver;
	@Test
	public void test() throws Exception{
	driver = Driver.getInstance();
	driver.get(Config.getProperty("url"));
	Page.sleep(3000);
	//driver.findElement(By.cssSelector("body")).sendKeys(Keys.META + "T");
	JavascriptExecutor jsx = (JavascriptExecutor)driver;
	jsx.executeScript("window.open('','_blank');");
//	Robot robot = new Robot();
//	robot.keyPress(KeyEvent.VK_CONTROL);
//	robot.keyPress(KeyEvent.VK_T);
//	robot.keyRelease(KeyEvent.VK_CONTROL);
//	robot.keyRelease(KeyEvent.VK_T);
	
	}

}
