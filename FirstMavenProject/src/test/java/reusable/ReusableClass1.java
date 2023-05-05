
package reusable;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableClass1 {
	public static WebDriver driver;
	
	public static WebDriver browserLaunch() {
		WebDriverManager.chromedriver().setup();	
		driver=new ChromeDriver();		
		return driver;
	}
	public static void geturl(String url) {
		driver.get(url);
	}
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}
	public void implicitwait(int timeinseconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeinseconds));
	}
	public void explicitwait(int timeinseconds) {
		WebDriverWait mouseover=new WebDriverWait(driver, Duration.ofSeconds(timeinseconds));
		mouseover.until(ExpectedConditions.presenceOfElementLocated(null));
	}
	public void fluentWait() {
	Wait<WebDriver>mouseover=new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2))
			.withMessage("Hello selenium")
			.ignoring(NoSuchElementException.class);
	}		
	public boolean gettitletext() {
		String resulttitle="Facebook – log in or sign up";
		String title=driver.getTitle();
		System.out.println(title);
		
		if(resulttitle.equals(title)) {
			System.out.println("Correct url");
			return true;
		}
		else {
			System.out.println("Incorrect url");
			return false;
		}		
	}
	public void closeBrowser() {
		driver.close();
	}
	public void sendkeysToElement(WebElement element,String sendkeys) {
		element.sendKeys(sendkeys);
	}
	public static void element2(WebElement element,String sendkeys1) {
		element.sendKeys(sendkeys1);
	}
	public void elementJavascript(WebElement element,String sendkeysjs) {
		element.sendKeys(sendkeysjs);
	}
	public void click(WebElement element) {
		element.click();
	}
	public void threadmethod(int sec) throws InterruptedException {
		Thread.sleep(sec);
	}
	public static String timestamp() {
		return new SimpleDateFormat("ddMMyyyy HHmmss").format(new Date());	
	}	
	public void screenshot(String filename) throws IOException {
		TakesScreenshot scrshot=(TakesScreenshot) driver;
		File srcFile=scrshot.getScreenshotAs(OutputType.FILE);
		System.out.println("SrcFile:"+srcFile);
		
		String mylocation="D:\\rajesh-workspace\\Selenium\\Images\\"+timestamp()+".png";	
		File destFile=new File(mylocation);
		FileUtils.copyFile(srcFile, destFile);
	}
	public void contextClick(WebElement element) {
		Actions acc=new Actions(driver);
		acc.contextClick(element).perform();
	}
	public void textScript(WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String textofid=(String) jse.executeScript("return arguments[0].getText()", element);
	}
	public void highlightsScript(WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.border='5px solid blue'", element);
	}
	public void setAttributeScript(WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].setAttribute('value',elementJavascript(WebElement element,String sendkeysjs)", element);
	}
	public void getAttributeScript(WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String username=(String) jse.executeScript("return arguments[0].getAttribute('value')", element);
	}
	public void scrollScript(WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
		jse.executeScript("arguments[0].click();", element);
	}
	public void selectClass(WebElement element) {
		Select selectobj=new Select(element);		
	}
	public void selectByIndex(WebElement element,int index) {
		Select selectobj=new Select(element);
		selectobj.selectByIndex(index);
	}
	public void selectByValue(WebElement element,String value) {
		Select selectobj=new Select(element);
		selectobj.selectByValue(value);
	}
	public void selectByVisibletext(WebElement element,String text) {
		Select selectobj=new Select(element);
		selectobj.selectByVisibleText(text);
	}
	public List<WebElement> listOfWebElements(WebElement element) {
		Select selectobj=new Select(element);
		List<WebElement> list=selectobj.getOptions();	
		return list;
	}
	public void frame(WebElement element) {
		driver.switchTo().frame(element);
	}
	public void frame(String name) {
		driver.switchTo().frame(name);
	}
	public void frame(int index) {
		driver.switchTo().frame(index);
	}
	public void parentFrame() {
		driver.switchTo().parentFrame();
	}
	public void defaultcontent() {
		driver.switchTo().defaultContent();
	}
	public void dragAndDrop(WebElement dragelement,WebElement dropelement) {
		Actions acc=new Actions(driver);
		acc.dragAndDrop(dragelement, dropelement).perform();;
	}
	public void scroll(WebElement element) {
		Actions acc=new Actions(driver);
		acc.scrollToElement(element).perform();
	}
	public void mouseHover(WebElement element) {
		Actions acc=new Actions(driver);
		acc.moveToElement(element).perform();
	}
	public String text(WebElement element) {
		String printtext=element.getText();
		return printtext;
	}
	public void alert() {
		driver.switchTo().alert();
	}
}
