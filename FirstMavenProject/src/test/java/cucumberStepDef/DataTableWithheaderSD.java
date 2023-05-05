
package cucumberStepDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import hookspackage.BeforeAfterdemo;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import reusable.FacebookWebElementReuse1;
import reusable.ReusableClass1;

public class DataTableWithheaderSD {
	WebDriver driver;

	@Given("Go to login page")
	public void go_to_login_page() {
//		WebDriverManager.chromedriver().setup(); 
//		 driver = new ChromeDriver();
//		 driver.get("https://www.facebook.com"); 
//		 driver.manage().window().maximize();
	}

	@When("enter the below data")
	public void enter_the_below_data(io.cucumber.datatable.DataTable dataTable) {
		PageFactory.initElements(driver, BeforeAfterdemo.class);

		List<Map<String, String>> keyvaluepair = dataTable.asMaps(String.class, String.class);
		String userName = keyvaluepair.get(1).get("username");
		String passWord = keyvaluepair.get(1).get("password");

		FacebookWebElementReuse1 locator = new FacebookWebElementReuse1(driver);

		ReusableClass1.element2(FacebookWebElementReuse1.getEmailsignin(), userName);
		ReusableClass1.element2(FacebookWebElementReuse1.getPasssignin(), passWord);

//		WebElement emailElement = driver.findElement(By.id("email"));
//		emailElement.sendKeys(userName);
//
//		WebElement passElement = driver.findElement(By.id("pass"));
//		passElement.sendKeys(passWord);
	}
	@Before
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
	}

	@After
	public void afterMethod() {
		driver.close();
	}
}
