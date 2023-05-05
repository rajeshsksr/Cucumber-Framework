package reusable;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Amazonpom {

	@FindBy(id="nav-orders")
	public static WebElement returnelement;
	
	@FindBy(id="ap_email")
	public static WebElement emailsignin;	
	
	@FindBy(id="continue")
	public static WebElement loginsignin;
}
