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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUp {
	
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
    	src=new File("C:\\DAO_Input_ Data\\Excel\\DAO_SignUp.xlsx");
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
   		
   		File src=new File("C:\\DAO_Input_ Data\\Excel\\DAO_SignUp.xlsx");		 
   		FileInputStream fis = new FileInputStream(src);
   		workbook = new XSSFWorkbook(fis);
   		sheet= workbook.getSheetAt(0);
   			for(int i=1; i<=sheet.getLastRowNum(); i++){  
   			
   				//Click on Sign up button
   				driver.findElement(By.xpath("//div[contains(text(),'Sign Up')]")).click();
   				Thread.sleep(2000);
   				
   				//Enter User Name
   				cell = sheet.getRow(i).getCell(1);
   				cell.setCellType(CellType.STRING);
   				driver.findElement(By.xpath("//*[@id=\"name\"]")).clear();
   				driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(cell.getStringCellValue());
   				
   				//Enter Email ID
   				cell = sheet.getRow(i).getCell(2);
   				cell.setCellType(CellType.STRING);
   				driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();	         
   				driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(cell.getStringCellValue());
   				
   				//Enter Password
   				cell = sheet.getRow(i).getCell(3);
   				cell.setCellType(CellType.STRING);
   				driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();	         
   				driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(cell.getStringCellValue());
   				
   				//Enter confirm password
   				
   				cell = sheet.getRow(i).getCell(4);
   				cell.setCellType(CellType.STRING);
   				driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).clear();	         
   				driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys(cell.getStringCellValue());
   				
   				//driver.findElement(By.xpath("//*[@id=\"country\"]")).click();
   				
   			   //Click on country dropdown
   				cell = sheet.getRow(i).getCell(5);
 				cell.setCellType(CellType.STRING);
      			driver.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys(cell.getStringCellValue());
   				
//   				try {
//   				//Select Country
//   				cell = sheet.getRow(i).getCell(5);   				
//   				cell.setCellType(CellType.STRING);
//   				String countryName=cell.getStringCellValue();
//   				System.out.println(countryName);
//   				driver.findElement(By.xpath("//*[@id=\""+countryName+"\"]")).click();
//   				Thread.sleep(1000);
//   				}
//   				catch(Exception e)
//   				{System.out.println(e.getMessage());}
   				
   				//Click on term and condition checkbox
   				driver.findElement(By.xpath("//*[@id=\"terms-conditions\"]")).click();
   			
   				//Click on Sign Up Button
   				driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   			}
    }
    @AfterTest
    public void afterTest() {

	   //workbook.close();
	  //driver.close();
}

}
