package task;

import java.util.List;
import java.util.ListIterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSuggestions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("cric");
		Thread.sleep(3000);
		List<WebElement> listwe= driver.findElements(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div/ul/li"));
		
		for(WebElement e:listwe) {
		//	System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase(listwe.get(4).getText())){
			System.out.println(e.getText());	
			e.click();
			break;
			}
		}
//		Actions action=new Actions(driver);
//		WebElement target=driver.findElement(By.xpath("(//li[@class='sbct'])[5]"));
//		action.keyDown(target, Keys.ENTER).build().perform();
	
//		search.sendKeys(Keys.ARROW_DOWN);
//		search.sendKeys(Keys.ARROW_DOWN);
//		search.sendKeys(Keys.ARROW_DOWN);
//		search.sendKeys(Keys.ARROW_DOWN);
//		search.sendKeys(Keys.ARROW_DOWN);
//		search.sendKeys(Keys.ENTER);
		
		
	}

}
