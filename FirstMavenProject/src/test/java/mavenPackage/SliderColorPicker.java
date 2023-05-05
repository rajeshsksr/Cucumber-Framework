package mavenPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderColorPicker {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();		
		driver.get("https://jqueryui.com/slider/#colorpicker");
		driver.manage().window().maximize();
		
		WebElement frame=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(frame);
		
		WebElement greenslider=driver.findElement(By.xpath("//*[@id=\"green\"]/span"));
		Actions acc=new Actions(driver);
		acc.dragAndDropBy(greenslider,50,0).perform();
		Thread.sleep(2000);
		
		WebElement blueslider=driver.findElement(By.xpath("//*[@id=\"blue\"]/span"));
		acc.dragAndDropBy(blueslider,150,0).perform();
		Thread.sleep(2000);
		
		WebElement redslider=driver.findElement(By.xpath("//*[@id=\"red\"]/span"));
		acc.dragAndDropBy(redslider,-150,0).perform();
	}
}
