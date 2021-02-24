package com.pfms.nonreguser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NonRegisteredUser 
{
	
	/**********Payment System***********/
	WebDriver driver;
	File file;
	XSSFSheet sheet;
	FileInputStream fi;
	XSSFWorkbook wb;
	FileOutputStream fos;
	
	//XSSFWorkSheet sheet;
	@BeforeTest()
	
	/**********Opening The URL ***********/
	
	public void launchbrowser() throws Exception
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://164.100.30.225/Bharatkosh");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
	}
	
	/**********Clicking on Non Registred link ***********/
	
	
	@Test(priority=0)	
	
	public void payment() throws FileNotFoundException ,IOException{
	
		{
		
		WebElement regi = driver.findElement(By.xpath("//span[contains(text(),'Non-Registered Users')]"));
		regi.click();
		
		
		/**********************Reading test Data from EXCEL File.********************/
		
		try
		{
			
		file= new File("E:\\TestData.xlsx");
		fi= new FileInputStream(file);
		wb= new XSSFWorkbook(fi);
		sheet = wb.getSheet("Sheet1");
		
		}
		
		catch(IOException ex)
		{
			System.out.println("Error Reading file");
		}
			
	}
	
	/**** Click on The Non-Registered Link EXCEL File. ****/
	try
	{
		
	WebElement ddlcategory = driver.findElement(By.xpath("//select[@id='ddlDepsitorCategory']"));
	
	//	WebElement depositorCategory = driver.findElement(By.id("ddlDepsitorCategory"));
	ddlcategory.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());

	}
	catch (Exception e)
	{
	System.out.println("Exception occured Element Not found occured"+e);
	}
	driver.findElement(By.xpath("//form[@id='frmMinistryInfo']//a")).click();
	
	WebElement ddlMini = driver.findElement(By.id("ddlMinistry"));
	
	ddlMini.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
	
	driver.findElement(By.id("btnsearch")).click();
	
	String searchLink = sheet.getRow(1).getCell(2).getStringCellValue();
	
	driver.findElement(By.linkText(searchLink)).click();
	
	WebElement ddlP = driver.findElement(By.id("ddlPAO"));
	
	ddlP.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
	
	WebElement ddlDDO = driver.findElement(By.id("ddlDDO"));
	
	ddlDDO.sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());
	
	driver.findElement(By.id("txtAmount")).clear();
	
	long Amount = (long) sheet.getRow(1).getCell(5).getNumericCellValue();
	
	driver.findElement(By.id("txtAmount")).sendKeys(Amount+"");
	
	driver.findElement(By.id("txtPurposeRemarks")).sendKeys(sheet.getRow(1).getCell(6).getStringCellValue());
	
	driver.findElement(By.id("Add_")).click();
	
	driver.findElement(By.xpath("//*[@id='step-1']/div[2]/div[3]/button")).click();
	String msg = "Payment Done.";
	String expectedvalue = "Depositor's Details";
	String Validatepage = driver.findElement(By.xpath("//*[@id='divDepositor']/div[1]/h3")).getText();
	try {
		fos =new FileOutputStream(file);
		if(Validatepage.equals(expectedvalue)) {
			sheet.getRow(1).createCell(7).setCellValue(msg);
		}
		else {
			sheet.getRow(1).createCell(7).setCellValue("Error");
		}
	}
	
	catch(IOException ex) {
		ex.printStackTrace();
	}

	wb.write(fos);
}

@AfterTest

/**** Closing all Session***/
public void Close() throws IOException {
	wb.close();
	fi.close();
	fos.close();
	driver.quit();
}
}
