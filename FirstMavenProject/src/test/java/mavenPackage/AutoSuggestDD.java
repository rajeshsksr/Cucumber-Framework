package mavenPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDD {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]")).click();
		
		driver.findElement(By.xpath("//span[text()='From']")).click();
		WebElement search=driver.findElement(By.xpath("//input[@placeholder='From']"));
		search.sendKeys("sydney");
		Thread.sleep(2000);
		search.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		search.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//span[text()='To']")).click();
		WebElement search2=driver.findElement(By.xpath("//input[@placeholder='To']"));
		search2.sendKeys("chennai");
		Thread.sleep(2000);
		search2.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		search2.sendKeys(Keys.ENTER);
		
		
	}

}
