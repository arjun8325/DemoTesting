package com.pfms.nonreguser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/********************************************************************
 * 
 * @author Arjun
 *
 */

public class NonRegisteredTrackPaymentNEFT {
	
	WebDriver driver;
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileOutputStream fos;
	
	//String driverpath="";

	
	
	
	/*
	 * 
	 * 
	 * Opening the Chrome Browser and Enter Bharatkosh URL
	 * 
	 * 
	 */
	
	@BeforeTest()
	public void opnenbrowser()
	{
		try 
		{
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://164.100.30.225/Bharatkosh");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			System.out.println("Error while opening Browser");
		}
		
	
		
	}
	
	/*
	 * 
	 * 
	 * Automate the Payment Purpose and Clicking on Non-Registred Users
	 * 
	 * 
	 */
	
	
	@Test()
	public void ClickNonRegister() throws Exception
	
	{
		
		driver.findElement(By.xpath("//span[contains(text(),'Non-Registered Users')]")).click();
		try
		{
			file=new File("C:\\Users\\Arjun\\Desktop\\Regi.xlsx");
			fis= new FileInputStream(file);
			wb= new XSSFWorkbook(fis);
			sheet=wb.getSheet("Sheet1");
			
		}
		
		catch(Exception e)
		{
			System.out.println("Error While reading Sheet 1");
		}
		
		
		String Depositorcategory= sheet.getRow(1).getCell(0).getStringCellValue();
		String Ministry=sheet.getRow(1).getCell(1).getStringCellValue();
		
		int Amount= (int)sheet.getRow(1).getCell(3).getNumericCellValue();
		
		driver.findElement(By.xpath("//select[@id='ddlDepsitorCategory']")).sendKeys(Depositorcategory);
		driver.findElement(By.xpath("//div[@class='input-icon right']/a")).click();
		driver.findElement(By.xpath("//select[@id='ddlMinistry']")).sendKeys(Ministry);
		driver.findElement(By.xpath("//input[@id='btnsearch']")).click();
		String purpose =sheet.getRow(1).getCell(2).getStringCellValue();
		driver.findElement(By.linkText(purpose)).click();
		driver.findElement(By.xpath("//input[@id='txtAmount']")).clear();
		driver.findElement(By.xpath("//input[@id='txtAmount']")).sendKeys(String.valueOf(Amount));
		
		driver.findElement(By.xpath("//button[@id='Add_']")).click();
		
		driver.findElement(By.xpath("//button[@formaction='btnNext_Click']")).click();
		
		String exp="2";
		String Actual_val=driver.findElement(By.xpath("//a[contains(text(),'2')]")).getText();
		String msgs="Detail saved";
				
		try
		{
			fos=new FileOutputStream(file);
			if(Actual_val.equals(exp))
			{
			
				sheet.getRow(1).createCell(4).setCellValue(msgs);
			}
			else
			{
				sheet.getRow(1).getCell(4).setCellValue("Cannot Saved Detail");
			
		}
		}
			catch(IOException ex) 
			{
				ex.printStackTrace();
			}

			wb.write(fos);
			fis.close();
		
	}
	
	/*
	 * 
	 * 
	 * Automate the Depositor Detail 
	 * 
	 * 
	 */
	
	
	
	
	@Test()
	
	public void Depositordetail() throws InterruptedException, IOException
	{
		
		try
		{
			file = new File("C:\\Users\\Arjun\\Desktop\\Regi.xlsx");
			fis= new FileInputStream(file);
			wb= new XSSFWorkbook(fis);
			sheet=wb.getSheet("Sheet2");
			
		}
		
		catch(Exception e)
		{
			System.out.println("Error while reading Sheet2");
			
		}
		
		
		String Saluatation= sheet.getRow(1).getCell(0).getStringCellValue();
		String Name= sheet.getRow(1).getCell(1).getStringCellValue();
		String Address1= sheet.getRow(1).getCell(2).getStringCellValue();
		String Address2= sheet.getRow(1).getCell(3).getStringCellValue();
		String Country= sheet.getRow(1).getCell(4).getStringCellValue();
		String State= sheet.getRow(1).getCell(5).getStringCellValue();
		String District= sheet.getRow(1).getCell(6).getStringCellValue();
		String City= sheet.getRow(1).getCell(7).getStringCellValue();
		long mobileNumber = (long) sheet.getRow(1).getCell(8).getNumericCellValue();
		String Email= sheet.getRow(1).getCell(9).getStringCellValue();
		
		driver.findElement(By.id("ddlSalutation")).sendKeys(Saluatation);
		driver.findElement(By.id("txtDepositorName")).sendKeys(Name);
		driver.findElement(By.id("txtAddress1")).sendKeys(Address1);
		driver.findElement(By.id("txtAddress2")).sendKeys(Address2);
		driver.findElement(By.id("ddlCountry")).sendKeys(Country);
		driver.findElement(By.id("ddlState")).sendKeys(State);
		driver.findElement(By.id("ddlDistrict")).sendKeys(District);
		driver.findElement(By.id("txtCity")).sendKeys(City);
		driver.findElement(By.id("txtMobileNumber")).sendKeys(String.valueOf(mobileNumber));
		driver.findElement(By.id("txtEmail")).sendKeys(Email);
		
		//ClickIng the radio Button
		WebElement NEFT=driver.findElement(By.xpath("//input[@id='rbpayment' and  @value='SWIFT/NEFT/RTGS']"));
		NEFT.click();
		
	
		long BankAccount = (long) sheet.getRow(1).getCell(10).getNumericCellValue();
		
		driver.findElement(By.id("txtBankAccount")).sendKeys(String.valueOf(BankAccount));
		/*
		 * Select Bank =new Select(driver.findElement(By.id("ddlbankName")));
		 * Bank.selectByIndex(12);
		 */
		
		String Bank_Name= sheet.getRow(1).getCell(11).getStringCellValue();
		
		driver.findElement(By.id("ddlbankName")).sendKeys(Bank_Name);
		
		String Bank_ifsc= sheet.getRow(1).getCell(12).getStringCellValue();
		
		driver.findElement(By.id("txtBankIfscCode")).sendKeys(Bank_ifsc);
		
		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		
		
		WebElement ele = driver.findElement(By.xpath("//button[@id='btnSave']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
	
	//	driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("btnConfirm")).click();		
		String msg="Payment Done Succesfully ontime";
		String Expect="Download Depositer Slip";
		String Actual_val=driver.findElement(By.xpath("//a[contains(text(),'Download Depositer Slip')]")).getText();
		
		
		try
		{
			fos=new FileOutputStream(file);
			if(Actual_val.equals(Expect))
			{
			
				sheet.getRow(1).createCell(13).setCellValue(msg);
			}
			else
			{
				sheet.getRow(1).getCell(13).setCellValue("Payment Error");
			
		}
		}
			catch(IOException ex) 
			{
				ex.printStackTrace();
			}

			wb.write(fos);
			fis.close();
		
		
	}
	@AfterTest()
	public void closeAll() throws IOException
	{
		//driver.close();
		fos.close();	
	}

}
