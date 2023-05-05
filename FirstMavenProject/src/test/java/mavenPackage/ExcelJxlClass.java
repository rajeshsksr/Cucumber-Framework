package mavenPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelJxlClass {
	String[][] data = null;

	@DataProvider(name = "loginData")
	public String[][] loinDataProvider() throws BiffException, IOException {
		data=getExcelData();
		return data;
	}

	public static String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Properties/Excel1.xls");
		Workbook wkbk = Workbook.getWorkbook(excel);
		Sheet sheet = wkbk.getSheet(0);
		int rowcount = sheet.getRows();
		int colcount = sheet.getColumns();

		String[][] testData = new String[rowcount-1][colcount];
		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				testData[i - 1][j] = sheet.getCell(j, i).getContents();
			}
		}
		return testData;
	}
	@Test(dataProvider = "loginData")
	public void loginWithUsPw(String uname,String pword) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

		WebElement emailElement = driver.findElement(By.id("email"));
		emailElement.sendKeys(uname);

		WebElement passElement = driver.findElement(By.id("pass"));
		passElement.sendKeys(pword);
		
		
	}
}
