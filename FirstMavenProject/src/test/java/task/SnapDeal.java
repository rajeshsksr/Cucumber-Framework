package task;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		Actions action=new Actions(driver);
		WebElement men= driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		action.moveToElement(men).perform();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3000));
		
		WebElement jean= driver.findElement(By.xpath("//span[text()=\"Jeans\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(jean)).click();
		
	//	WebElement product= driver.findElement(By.xpath("(//div[@class='product-desc-rating '])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='product-desc-rating '])[2]"))).click();
		
		Set<String> window= driver.getWindowHandles();
		for(String s:window) {
		driver.switchTo().window(s);
		}
		
		WebElement addtocartbtn= driver.findElement(By.xpath("//span[text()=\"add to cart\"]"));
		wait.until(ExpectedConditions.elementToBeClickable(addtocartbtn)).click();
		
		WebElement checkoutbtn= driver.findElement(By.xpath("//a[text()=\"Proceed To Checkout\"]"));
		System.out.println(checkoutbtn.getText());
		wait.until(ExpectedConditions.elementToBeClickable(checkoutbtn)).click();
		
		
	}

}
