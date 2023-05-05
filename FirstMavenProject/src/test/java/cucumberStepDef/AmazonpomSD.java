package cucumberStepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import reusable.Amazonpom;
import reusable.ReusableClass1;

public class AmazonpomSD {
	WebDriver driver;

	ReusableClass1 obj = new ReusableClass1();

	@Given("User has to launch the application")
	public void user_has_to_launch_the_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
	}

	@When("User clicks the return text")
	public void user_clicks_the_return_text() {
		PageFactory.initElements(driver, Amazonpom.class);
		obj.click(Amazonpom.returnelement);
	}

	@When("User gives the email and clicks the login button")
	public void user_gives_the_email_and_clicks_the_login_button() {
		ReusableClass1.element2(Amazonpom.emailsignin, "hello@gmail.com");
		obj.click(Amazonpom.loginsignin);
	}
}
