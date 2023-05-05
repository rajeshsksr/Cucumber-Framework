package cucumberStepDef;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataTableWoHeaderSD {
	WebDriver driver;
	@Given("User launches the launch the web page")
	public void user_launches_the_launch_the_web_page() {
		 WebDriverManager.chromedriver().setup(); 
		 driver = new ChromeDriver();
		 driver.get("https://www.facebook.com"); 
		 driver.manage().window().maximize();
	}
	@When("User enters the below credantials")
	public void user_enters_the_below_credantials(io.cucumber.datatable.DataTable dataTable) {
		List<String>credentials=dataTable.asList(String.class);
		String username=credentials.get(0);
		String password=credentials.get(1);
		
		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys(username);

		WebElement passElement = driver.findElement(By.id("pass"));
		passElement.sendKeys(password);
	}

}
