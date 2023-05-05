package googleSD;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import reusable.ReusableClass1;


public class GoogleSD extends ReusableClass1 {
//	WebDriver driver;

	@Given("User has to launch google url")
	public void user_has_to_launch_google_url() {

//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://www.google.co.in");
//		driver.manage().window().maximize();
	}

	@When("User clicks i am lucky text")
	public void user_clicks_i_am_lucky_text() {
//		WebElement appsbtn= driver.findElement(By.name("q"));
//		appsbtn.sendKeys("ajhvc");
	}

	@Then("User has to view the doodles page")
	public void user_has_to_view_the_doodles_page() {
//		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}
//	@AfterStep
	public void beforeStep(Scenario scenario) throws IOException {
//		if (scenario.isFailed()) {
//		Date currentdate=new Date();
//	
//		String screenshotfilename=currentdate.toString().replace(" ", "-").replace(":", "-");
//
//		TakesScreenshot ts=(TakesScreenshot) driver;		
//		byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
//		File screenshotsys=ts.getScreenshotAs(OutputType.FILE);
//		
//		FileUtils.copyFile(screenshotsys, new File("D:\\rajesh-workspace\\FirstMavenProject\\Images\\"+screenshotfilename+".png"));
//		scenario.attach(screenshot,"image/png", screenshotfilename);
//	}
//	}
}
}
