package mavenPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLError {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setAcceptInsecureCerts(true);
		
		ChromeOptions copt=new ChromeOptions();
		copt.merge(dc);
		
		WebDriver driver=new ChromeDriver(copt);
	//	driver.get("https://expired.badssl.com/");
		driver.get("https://www.google.com");
	}
}
