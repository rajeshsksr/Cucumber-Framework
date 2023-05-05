package task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in");
		driver.manage().window().maximize();

		driver.findElement(By.id("signin-block")).click();
		driver.findElement(By.id("signInLink")).click();
		
		WebElement parentframe= driver.findElement(By.xpath("//iframe[@class='modalIframe']"));

		driver.switchTo().frame(parentframe);
		Thread.sleep(2000);
		
		WebElement txt=driver.findElement(By.xpath("//span[text()='Connect using social accounts']"));
		System.out.println(txt.getText());

		Actions ac=new Actions(driver);
		
		WebElement googleframe=driver.findElement(By.xpath(" //iframe[@title='Sign in with Google Button']"));
		driver.switchTo().frame(googleframe);		
				
		WebElement signinbutton=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/span[1]"));
		ac.moveToElement(signinbutton).click().build().perform();
		
	}

}

//driver.findElement(By.id("mobileNoInp")).sendKeys("8732986862");
//Thread.sleep(2000);
//WebElement recaptchaframe= driver.findElement(By.xpath("(//iframe[@title='reCAPTCHA'])[1]"));
//driver.switchTo().frame(recaptchaframe);
//Thread.sleep(2000);
//WebElement recaptcha= driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[4]"));
//ac.moveToElement(recaptcha).click().build().perform();