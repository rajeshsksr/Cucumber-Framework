package reusable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookWebElementReuse1 extends ReusableClass1 {
	
	public FacebookWebElementReuse1(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	private static WebElement emailsignin;
	
	@FindBy(name="pass")
	private static WebElement passsignin;	
	
	@FindBy(name="login")
	private static WebElement loginsignin;

	public static WebElement getEmailsignin() {
		return emailsignin;
	}
	
	public static WebElement getPasssignin() {
		return passsignin;
	}
	
	public static WebElement getLoginsignin() {
		return loginsignin;
	}
}