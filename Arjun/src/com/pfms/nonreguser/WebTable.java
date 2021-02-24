
package com.pfms.nonreguser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTable
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
	
	}
	
	/***************************FETCH TABLE DATA ROWS and COLOUMNS*****************************************/
	
	WebElement table= driver.findElement(By.xpath("//*[@id='sample_1']/tbody/tr"));
	
	
	List<WebElement> rows=driver.findElements(By.tagName("tr"));
	
	System.out.println("Number of rows are"+rows.size());
	
	List<WebElement> colums=driver.findElements(By.tagName("th"));
	
	System.out.println("Number of cloums are"+colums.size());
	
	for(WebElement column:colums)
		
	{
		String Column_name= column.getText();
		System.out.println(Column_name+"  ");
		
		
	}
	
	
	
	System.out.println("*********************  Retrieving Number of Rows******************************");
	
	for (WebElement Row:rows)
	{
		String Row_Data= Row.getText();
		System.out.println(Row_Data+ " ");
	}
		
	}
	
	
/*****************************************FECH ALL VALUES IN EXCEL*****************************************/
	
	
	
	public void insertexcel() throws Exception
	{

	WebElement table= driver.findElement(By.xpath("//*[@id='sample_1']/tbody/tr"));	
	
	List<WebElement> Totalrows=driver.findElements(By.tagName("tr"));
	{
	for(int row=0;row<Totalrows.size();row++)
	{
		
		
	XSSFRow rowvalue= sheet.createRow(row);	
	List<WebElement> Totalcolumns=	Totalrows.get(row).findElements(By.tagName("td"));
	
	for(int col=0;col<Totalcolumns.size();col++)
	{
	 
		String cellvalue= Totalcolumns.get(col).getText();
		
		System.out.println(cellvalue+"\t");
		rowvalue.createCell(col).setCellValue(cellvalue);
	}
	
	System.out.println();
	

	try {
		fos = new FileOutputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

	}
}
	}
	
	@AfterTest()
	public void close() throws IOException
	{
		wb.close();
		fi.close();
		//driver.close();
		
	}
	
}


