package cucumberStepDef;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import reusable.FacebookWebElementReuse1;
import reusable.ReusableClass1;

public class FbPomSD extends ReusableClass1 {
	
	@Given("User provides the url")
	public void user_provides_the_url() {
	   ReusableClass1.browserLaunch();
	   ReusableClass1.geturl("https://www.facebook.com");
	   ReusableClass1.maximizeWindow();
	}
	@When("User enters usename and password")
	public void user_enters_usename_and_password() {
		
	//	PageFactory.initElements(driver, FacebookWebElementReuse1.class);
		FacebookWebElementReuse1 locator=new FacebookWebElementReuse1(driver);
		
		ReusableClass1.element2(FacebookWebElementReuse1.getEmailsignin(), "hello");
		ReusableClass1.element2(FacebookWebElementReuse1.getPasssignin(), "abc@123");
	}
}
