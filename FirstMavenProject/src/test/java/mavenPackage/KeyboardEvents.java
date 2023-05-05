package mavenPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardEvents {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://extendsclass.com/text-compare.html");
		WebElement sourcetext=driver.findElement(By.xpath("//*[@id=\"dropZone\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[6]"));
		
		Actions acc=new Actions(driver);
		Thread.sleep(2000);
		acc.keyDown(sourcetext, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
		
		WebElement desttext=driver.findElement(By.xpath("//*[@id=\"dropZone2\"]/div[2]/div/div[6]/div[1]/div/div/div/div[5]/div[3]/pre"));
		Thread.sleep(2000);
		acc.keyDown(desttext, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();
	}
}
