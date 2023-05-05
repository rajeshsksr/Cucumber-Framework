package mavenPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelApacheClass {
	public static void main(String[] args) throws IOException {
		ExcelApacheClass exl=new ExcelApacheClass();
		exl.readExcel();
		System.out.println("usernamelist :"+usernameList);
		System.out.println("passwordlist :"+passwordList);
		exl.executeTest();
	}
	public void readExcel() throws IOException {
		FileInputStream excel = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Properties/Apacheexcel.xlsx");
		Workbook workbook=new XSSFWorkbook(excel);
		Sheet st=workbook.getSheetAt(0);
		
		Iterator<Row> rowiterator=st.iterator();
		while(rowiterator.hasNext()) {
			Row rowvalue=rowiterator.next();
			Iterator<Cell> columniterator=rowvalue.iterator();
			int i=2;
			while(columniterator.hasNext()) {
//				Cell cellvalue=columniterator.next();
//				System.out.println(cellvalue);
				if(i%2==0) {
					usernameList.add(columniterator.next().getStringCellValue());
				} else {
					passwordList.add(columniterator.next().getStringCellValue());
				}
				i++;
			}
		}
	}
	static List<String> usernameList=new ArrayList<String>();
	static List<String> passwordList=new ArrayList<String>();
	
	public void executeTest() {
		for(int i=0;i<usernameList.size();i++) {
			login(usernameList.get(i),passwordList.get(i));
		}
	}
		public void login(String uname,String pword) {
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

