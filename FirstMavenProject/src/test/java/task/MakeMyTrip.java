package task;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		WebElement first= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/label"));
		first.click();
		
		WebElement from= driver.findElement(By.xpath("//input[@type='text'][@placeholder='From']"));		
		from.sendKeys("chen");
		Thread.sleep(2000);
		from.sendKeys(Keys.ARROW_DOWN);
		from.sendKeys(Keys.ENTER);
		
		WebElement second= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/label"));
		second.click();
		
		WebElement to= driver.findElement(By.xpath("//input[@type='text'][@placeholder='To']"));		
		to.sendKeys("madu");
		Thread.sleep(2000);
		to.sendKeys(Keys.ARROW_DOWN);
		to.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//div[@aria-label='Mon Mar 13 2023']")).click();
	
		WebElement search= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a"));
		search.click();
	
		WebElement closebtn= driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']"));
		
		Wait<WebDriver> flwait=new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(1))
					.ignoring(NoSuchElementException.class);
					
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4000));
		flwait.until(ExpectedConditions.elementToBeClickable(closebtn)).click();
		
		driver.findElement(By.xpath("(//span[text()='View Prices'])[1]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='LOCK PRICE'])[1]"))).click();
		
		WebElement text=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/section/div[5]/p"));
		System.out.println(text.getText());
		
	}

}
