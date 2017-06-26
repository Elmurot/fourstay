package db_and_non_db_extras;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fourstay.utilities.Driver;

public class TempMail {
	
	private WebDriver driver;
	
	public TempMail(){
		this.driver = Driver.getInstance();
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy (id = "mail")
	public WebElement email;
	
	@FindBy (xpath = "(//table/tbody/tr)/td[1]/a")
	public WebElement firstInbox;
	
	@FindBy (xpath = "(//table/tbody)//td[.='Thanks for signing up at 4stay.com!']")
	public WebElement confirmation;

}
