package User_Panel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase7 {

	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	WebDriverWait wait;
	File src; 
	FileInputStream fis;

	@BeforeTest
	public void initialization() throws IOException{

		//Get data from excel
		src=new File("C:\\DAO_Input_ Data\\Excel\\TestCase7.xlsx");
		fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet= workbook.getSheetAt(0);

		cell = sheet.getRow(1).getCell(0);
		cell.setCellType(CellType.STRING);
		//Launch Browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(cell.getStringCellValue());
		//driver.get("https://yopmail.com/en/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void SignUp() throws IOException, InterruptedException{

		File src=new File("C:\\DAO_Input_ Data\\Excel\\TestCase7.xlsx");		 
		FileInputStream fis = new FileInputStream(src);
		workbook = new XSSFWorkbook(fis);
		sheet= workbook.getSheetAt(0);
		for(int i=1; i<=sheet.getLastRowNum(); i++){  

			//Click on Sign IN button
			driver.findElement(By.xpath("//div[contains(text(),'User Sign In')]")).click();
			Thread.sleep(2000);

			//Enter Email ID
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);
			driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(cell.getStringCellValue());


			//Enter Password
			cell = sheet.getRow(i).getCell(2);
			cell.setCellType(CellType.STRING);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();	         
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(cell.getStringCellValue());

			//Click on Remember me button
			driver.findElement(By.xpath("//*[@id=\"remember-me\"]")).click();
			Thread.sleep(2000);

			//Click on Sign in button
			driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
			Thread.sleep(5000);
			
			//Click on Profile button
			driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium userNameInitial css-1yxmbwk']")).click();
			Thread.sleep(1000);
			
			//Click on Profile name 
			driver.findElement(By.xpath("//span[@class='fw-semibold d-block']")).click();
			Thread.sleep(1000);
			
			//Click on Change Password button 
			driver.findElement(By.xpath("//li[contains(text(), \"Change Password\")]")).click();
			Thread.sleep(3000);
			
			//Enter Current Password
			cell = sheet.getRow(i).getCell(3);
			cell.setCellType(CellType.STRING);
			driver.findElement(By.xpath("//input[@id='currentPassword']")).clear();
			driver.findElement(By.xpath("//input[@id='currentPassword']")).sendKeys(cell.getStringCellValue());
			Thread.sleep(2000);
			
			//Enter New Password
			cell = sheet.getRow(i).getCell(4);
			cell.setCellType(CellType.STRING);
			driver.findElement(By.xpath("//input[@id='newPassword']")).clear();
			driver.findElement(By.xpath("//input[@id='newPassword']")).sendKeys(cell.getStringCellValue());
			Thread.sleep(2000);
			
			//Enter Confirm Password
			cell = sheet.getRow(i).getCell(5);
			cell.setCellType(CellType.STRING);
			driver.findElement(By.xpath("//input[@id='confirmPassword']")).clear();
			driver.findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(cell.getStringCellValue());
			Thread.sleep(2000);
			
			//Click on Update button
			driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
			Thread.sleep(15000);
			
			//Click on Profile button
			driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium userNameInitial css-1yxmbwk']")).click();
			Thread.sleep(1000);

			//Click on Sign Out button
			driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
			Thread.sleep(1000);
			break;
		}
	}

}
