package hookspackage;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import reusable.ReusableClass1;

public class BeforeAfterdemo extends ReusableClass1 {
//	WebDriver driver;

//	@AfterStep
//	public void beforeStep(Scenario scenario) throws IOException {
//		if (scenario.isFailed()) {
//		Date currentdate=new Date();
//	//	System.out.println(currentdate);
//		
//		String screenshotfilename=currentdate.toString().replace(" ", "-").replace(":", "-");
//	//	System.out.println(screenshotfilename);
//		
//		TakesScreenshot ts=(TakesScreenshot) driver;		
//		File screenshot=ts.getScreenshotAs(OutputType.FILE);
//		
//		FileUtils.copyFile(screenshot, new File("D:\\rajesh-workspace\\FirstMavenProject\\Images\\"+screenshotfilename+".png"));
//	}
//	}
	@Before(order=0)
	public void beforeMethod() {
		 System.out.println("This is before method");
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	}
	@Before
	public void beforeMethod1() {
		 System.out.println("This is before method1");
	}
//	@Before(order=2)
//	public void beforeMethod2() {
//		 System.out.println("This is before method2");
//	}

	@After(order=2)
	public void afterMethod() {
		System.out.println("This is after method");
		driver.close();
	}
	@After
	public void afterMethod1() {
		System.out.println("This is after method1 wo order");
	}
//	@After(order=2)
//	public void afterMethod2() {
//		System.out.println("This is after method2");
//	}
	@Before("@first")
	public void beforeMethodfirst() {
		 System.out.println("This is before first tag");
	}
//	@Before("@second")
//	public void beforeMethod1() {
//		 System.out.println("This is before second tag");
//	}
//	@Before("@third")
//	public void beforeMethod2() {
//		 System.out.println("This is before third tag");
//	}
//
	@After("@first")
	public void afterMethodfirst() {
		System.out.println("This is after first tag");
	}
//	@After("@second")
//	public void afterMethod1() {
//		System.out.println("This is after second tag");
//	}
//	@After("@third")
//	public void afterMethod2() {
//		System.out.println("This is after third tag");
//	}
//	@BeforeAll
//	public static void before_or_after_all() {
//		System.out.println("This is before all ");
//	}
//	@AfterAll
//	public static void before_or_after_all1() {
//		System.out.println("This is after all ");
//	}
	@BeforeStep
	public void beforestep() {
		System.out.println("This is before step ");
	}
	@AfterStep
	public void afterstep() {
		System.out.println("This is after step ");
	}
	
}
