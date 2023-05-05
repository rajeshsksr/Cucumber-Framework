package cucumberStepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FbDataParameterSD {
	WebDriver driver;
	@Given("User launches the url to launch the web page")
	public void user_launches_the_url_to_launch_the_web_page() {
		WebDriverManager.chromedriver().setup(); 
		 driver = new ChromeDriver();
		 driver.get("https://www.facebook.com"); 
		 driver.manage().window().maximize();
	}

	@When("User sends the {string} and {string}")
	public void user_sends_the_and(String username, String password) {
		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys(username);

		WebElement passElement = driver.findElement(By.id("pass"));
		passElement.sendKeys(password);
	}
}
