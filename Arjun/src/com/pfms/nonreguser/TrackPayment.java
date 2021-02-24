package com.pfms.nonreguser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TrackPayment 
{

	
	/**********Payment System***********/
	
	WebDriver driver;
	File file;
	XSSFSheet sheet;
	FileInputStream fi;
	XSSFWorkbook wb;
	FileOutputStream fos;
	
	//XSSFWorkSheet sheet;
	
	/**********Opening The URL ***********/

	
	@BeforeTest()
	
	public void launchbrowser() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://164.100.30.225/Bharatkosh");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);		
	}
	
	@Test
	public void trackpayment() throws IOException, InterruptedException{
	
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		
		driver.findElement(By.xpath("//span[contains(text(),'Track your Payment / payment history')]")).click();
		try 
		{
			File f = new File("E:\\TestData.xlsx");
			fi = new FileInputStream(f);
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheet("Sheet1");

		} catch (Exception ex) {

			System.out.println("Error opening excel");
			ex.printStackTrace();

		}
	
	WebElement Country= driver.findElement(By.xpath("//select[@id='Country']"));
		
	Country.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		
	WebElement Email=driver.findElement(By.xpath("//input[@id='Email']"));
	
	Email.sendKeys((sheet.getRow(1).getCell(1).getStringCellValue()));
	
	WebElement btton=driver.findElement(By.xpath("//input[@id='btnSendOtp']"));
	
	btton.click();
	
	WebElement otp= driver.findElement(By.xpath("//input[@id='OTP']"));
	
	otp.sendKeys("1234");

	WebElement otpbutton= driver.findElement(By.xpath("//body/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[7]/input[5]"));
	
	otpbutton.click();
	
	WebElement Financialyear= driver.findElement(By.xpath("//select[@id='FinancialYear']"));
	
	Financialyear.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
	
	WebElement Status= driver.findElement(By.xpath("//select[@id='TransactionStatus']"));
	
	Status.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
	
	WebElement Searchbtton=driver.findElement(By.xpath("//input[@id='btnSubmit']"));
	
	Searchbtton.click();
	
	Thread.sleep(5000);
	
	//WebDriverWait wait =new WebDriverWait(driver,160);
	
	//WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='sample_1']/tbody/tr/td[1]")));

	/************************************CLICKING THE TRANSACTION NUMBER PAGE BY PAGE**********************************************************/
	
	List<WebElement> Transactionnumber = driver.findElements(By.xpath("//table[@id='sample_1']/tbody/tr/td[1]"));
	
	System.out.println("List Of Transactions : " + Transactionnumber.size());
	
	List<String> Trans = new ArrayList<String>();
	   //Adding column1 elements to the list
	   for(WebElement nameEle : Transactionnumber) 
	   {
	    Trans.add(nameEle.getText());
	   }
	   
	   //Displaying the list elements on console
	  	File file = new File("E:\\diwan.xlsx");
	  	XSSFWorkbook wb = new XSSFWorkbook();
 		XSSFSheet sh = wb.createSheet("Sheet1");
	 
	   for(int row=0; row<Transactionnumber.size(); row++)
 		{
 			XSSFRow rowValue = sh.createRow(row);
 			List<WebElement> totalColumns = Transactionnumber.get(row).findElements(By.tagName("td"));
 			for(int col=0; col<totalColumns.size(); col++)
 			{
 				String cellValue = totalColumns.get(col).getText();
 				System.out.print(cellValue + "\t");
 				rowValue.createCell(col).setCellValue(cellValue);
 			}
 			System.out.println();
 		}
	   
	   
 		FileOutputStream fos = new FileOutputStream(file);
 		wb.write(fos);
	 //locating next button
	   String nextbutton = driver.findElement(By.xpath("//a[contains(text(),'»')]")).getAttribute("class");

	   //traversing through the table until the last button and adding names to the list defined about
	   while (!nextbutton.contains("disabled")) 
	   {
	    driver.findElement(By.xpath("//a[contains(text(),'»')]")).click();
	
	    Transactionnumber = driver.findElements(By.xpath("//table[@id='sample_1']/tbody/tr/td[1]"));
	    
	    for (WebElement TEle : Transactionnumber)
	    {
	     Trans.add(TEle.getText());
	    }
	    
	    nextbutton = driver.findElement(By.xpath("//a[contains(text(),'»')]")).getAttribute("class");
	   }
	   //printing the transaction
	   for (String name : Trans)
	   {
	    System.out.println(name);
	    
	   }
	   //counting the size of the list
	   int actualCount = Trans.size();
	
	   System.out.println("Total number of names :" + actualCount);
	   
	  // Thread.sleep(2000);

	   //locating displayed count 
	   String displayedString = driver.findElement(By.xpath("//div[contains(text(),'Showing 1 to 25 of 39 Items')]")).getText().split(" ")[5];
	   
	   System.out.println("totaldis"+displayedString);
	   
	}    
	
	}
	@AfterTest()
	public void close() throws IOException
	{
		wb.close();
		fi.close();
		driver.close();
		
	}
	
}


