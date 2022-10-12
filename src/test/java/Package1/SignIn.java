package Package1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignIn {
	
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
    	src=new File("C:\\DAO_Input_ Data\\Excel\\DAO_Signin.xlsx");
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
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
   	public void SignUp() throws IOException, InterruptedException{
   		
   		File src=new File("C:\\DAO_Input_ Data\\Excel\\DAO_Signin.xlsx");		 
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
   				Thread.sleep(1000);
   				
   			    //Enter Currency value
   				cell = sheet.getRow(i).getCell(3);
   				cell.setCellType(CellType.STRING);
   				driver.findElement(By.xpath("//*[@id=\"currency\"]")).clear();
   				driver.findElement(By.xpath("//*[@id=\"currency\"]")).sendKeys(cell.getStringCellValue());
   				Thread.sleep(5000);
   				
   			//Click on Profile button
   				driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium userNameInitial css-1yxmbwk']")).click();
   				Thread.sleep(1000);

   				//Click on Sign Out button
   				driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
   				Thread.sleep(1000);
   				break;
   				
   			    //Click on Buy Token button
//   				driver.findElement(By.xpath("//button[contains(text(),'Buy Token')]")).click();
//   				Thread.sleep(3000);
   				
   				////button[contains(text(),'Buy Token')]
   				
//   				if(driver.findElement(By.xpath("//button[contains(text(),'Switch Network')]")).isDisplayed() ) {
//   			        //clicking on button1 if its presemt
//
//   			        WebElement clickBtn1 = driver.findElement(By.xpath("//button[contains(text(),'Switch Network')]"));
//   			        clickBtn1.click();
//
//   			 }
//   			    else if(driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).isDisplayed() ){
//   			    //Clicking on button2 if its present
//
//   			    WebElement clickBtn2 = driver.findElement(By.xpath("//button[contains(text(),'Confirm')]"));
//   			    clickBtn2.click();
//   			}
//
//   			else
//   			    {
//   			        System.out.println("No such button found");
//   			    }
   				
   			}
    }
}
