package cucumberStepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FbSD {
	WebDriver driver;

	@Given("User provides the url to launch the web page")
	public void user_provides_the_url_to_launch_the_web_page() {
		 WebDriverManager.chromedriver().setup(); 
		 driver = new ChromeDriver();
		 driver.get("https://www.facebook.com"); 
		 driver.manage().window().maximize();
	}

	@When("User enters the valid username and valid password")
	public void user_enters_the_valid_username_and_valid_password() {

		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys("Hello@gmail.com");

		WebElement passElement = driver.findElement(By.id("pass"));
		passElement.sendKeys("abc@123");
	}

	@When("User enter the invalid {string} and {string}")
	public void user_enter_the_invalid_username_and_password(String username, String password) {
		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys(username);

		WebElement passElement = driver.findElement(By.id("pass"));
		passElement.sendKeys(password);
	}

}
