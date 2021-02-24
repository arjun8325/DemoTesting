package com.pfms.nonreguser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NonPaymentdec

{

	WebDriver driver;
	File file,file1;
	XSSFSheet sheet,sheet1;
	FileInputStream fi,fis;
	XSSFWorkbook wb,wb1;
	FileOutputStream fos,fos1;
	
	
	@BeforeTest()
	
	public void launchbrowser()
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://164.100.30.225/Bharatkosh");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		
	}
	
	@Test
	public void createexcel()
	
	{
		
		driver.findElement(By.xpath("//span[contains(text(),'Track your Payment / payment history')]")).click();
		try {
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

	
	public void tabledata() {
		
		try {
			File file1 = new File("E:\\NewDataaa.xlsx");
			wb1 = new XSSFWorkbook();
			sheet1 = wb1.createSheet("Display Data");

				} catch (Exception ex) {

					System.out.println("Error creating file");
					ex.printStackTrace();

				}
	}
	
	WebElement table= driver.findElement(By.xpath("//*[@id='sample_1']/tbody"));
	
	List<WebElement> Totalrows=driver.findElements(By.tagName("tr"));
	{
	for(int i=0;i<Totalrows.size();i++)
	{
		
		
	List<WebElement> Totalcolumns=	Totalrows.get(i).findElements(By.tagName("td"));
	
	for(int col=0;col<Totalcolumns.size();col++)
	{
	 
		String cellvalue= Totalcolumns.get(col).getText();
		
		System.out.println(cellvalue+"\t");
	}
	
	System.out.println();
	}
	
	try {
		fos1= new FileOutputStream(file1);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	
	
	@AfterTest()
	public void close() throws IOException
	{
		wb.close();
		fi.close();
		driver.close();
		fos1.close();
		wb1.close();
	}
	
}
