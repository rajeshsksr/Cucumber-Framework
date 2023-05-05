/**
 * 
 */
package mavenPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mavensetupcheck {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys("Hello@gmail.com");

		WebElement passElement = driver.findElement(By.id("pass"));
		passElement.sendKeys("abc@123");

	}

}
