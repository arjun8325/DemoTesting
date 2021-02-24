package com.pfms.nonreguser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPaymentExcel

{
	
	WebDriver driver;
	File file;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileOutputStream fos;
	FileInputStream fis;
	long Amount,txtAadhaar,mobileNumber,txtPinCode1;
	String msg,Expected_val,Actual_val;
	
	String Driverpath="E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe";
	
	
	@BeforeTest()	
	
	public void LaunchBrowser()  
	{
		/*************************Launching Web Browser**************************************/
		
		try
		{
			
		System.setProperty("webdriver.chrome.driver", Driverpath);
		driver= new ChromeDriver();
		driver.get("http://164.100.30.225/Bharatkosh");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			System.out.println("Error while opening browser");
		}
		
	}
	
	@Test(priority=1)
	
	public void LoginUser() throws InterruptedException 
	{
		
		/***************************Click on  Login Button************************************************/
		
		driver.findElement(By.xpath("//div[@class='inner-box']/a/h5")).click();
		try
		{
			file = new File("C:\\Users\\Arjun\\Desktop\\Loginpaynew.xlsx");
			fis= new FileInputStream(file);
			wb= new XSSFWorkbook(fis);
			sheet=wb.getSheet("Sheet1");
		}
		
		catch(Exception e)
		{
			System.out.println("Error while reading");
			
		}
		
		/*********************************Entering Login Name and Password*************************/
		
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("arjun888");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Diwan@8325");
		driver.findElement(By.id("btnSubmit")).click();
		
		/*************************** Menu Navigation Click on Make Your Payment Link************************************************************/
		driver.findElement(By.xpath("//a[@title='Make your Payment']")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@title='Payment to GoI']")).click();
	}
		
		@Test(priority=2, dependsOnMethods = {"LoginUser"})
		public void Paymentprocess()
		{
			
			/***************************Click on  Login Button************************************************/
			
			try
			{
				file = new File("C:\\Users\\Arjun\\Desktop\\Loginpaynew.xlsx");		
				fis= new FileInputStream(file);
				wb= new XSSFWorkbook(fis);
				sheet=wb.getSheet("Sheet2");	
			}
			catch(Exception e)
			{
				System.out.println("Error while reading Sheet2");
				
			}
		
		Select s= new Select(driver.findElement(By.id("ddlDepsitorCategory")));
		s.selectByVisibleText("Individual");
		driver.findElement(By.xpath("//*[@id='step-1']/div[2]/div[1]/div/div/div[2]/div/div/a")).click();
		WebElement ddlMinistry = driver.findElement(By.id("ddlMinistry"));
		ddlMinistry.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		driver.findElement(By.id("btnsearch")).click();
		String searchLink = sheet.getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.linkText(searchLink)).click();
		WebElement Payment_Type=driver.findElement(By.id("ddlReceiptPaymentType"));
		Payment_Type.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
		driver.findElement(By.id("txtAmount")).clear();
		Amount= (long) sheet.getRow(1).getCell(3).getNumericCellValue();
		driver.findElement(By.id("txtAmount")).sendKeys(Amount+"");
		driver.findElement(By.id("Add_")).click();		
		driver.findElement(By.xpath("//button[@formaction='btnNext_Click']")).click();

		 msg="Payment purpose saved ";
		 Expected_val="2";
		
		 Actual_val=driver.findElement(By.xpath("//a[contains(text(),'2')]")).getText();
		
		try 
		{
			fos =new FileOutputStream(file);
			if(Actual_val.equals(Expected_val)) {
				sheet.getRow(1).createCell(5).setCellValue(msg);
			}
			else {
				sheet.getRow(1).createCell(5).setCellValue("S");
			}
		}
		
		catch(IOException ex) {
			ex.printStackTrace();
		}

		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test(priority=2,dependsOnMethods = {"LoginUser"})
	
	public void depositordetail() throws IOException, Exception
	
	/*************
	 * This Will Automate Depositor detail Info Module
	 * @throws Exception *****/
	{
		try
		{
			file = new File("C:\\Users\\Arjun\\Desktop\\Loginpaynew.xlsx");		
			fis= new FileInputStream(file);
			wb= new XSSFWorkbook(fis);
			sheet=wb.getSheet("Sheet3");
			
		}
		
		catch(Exception e)
		{
			System.out.println("Error while opening sheet 3");
			
		}			
		driver.findElement(By.id("ddlSalutation")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		driver.findElement(By.id("txtDepositorName")).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		driver.findElement(By.id("txtAddress1")).sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
		driver.findElement(By.id("txtAddress2")).sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());
		WebElement countryDrop = driver.findElement(By.id("ddlCountry"));
		countryDrop.sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());
		WebElement stateDrop = driver.findElement(By.id("ddlState"));
		stateDrop.sendKeys(sheet.getRow(1).getCell(5).getStringCellValue());
		WebElement disDrop = driver.findElement(By.id("ddlDistrict"));
		disDrop.sendKeys(sheet.getRow(1).getCell(6).getStringCellValue());
		driver.findElement(By.id("txtCity")).sendKeys(sheet.getRow(1).getCell(7).getStringCellValue());
		 txtPinCode1 = (long) sheet.getRow(1).getCell(8).getNumericCellValue();
		driver.findElement(By.id("txtPinCode")).sendKeys(txtPinCode1+"");
		driver.findElement(By.id("txtTan")).sendKeys(sheet.getRow(1).getCell(9).getStringCellValue());
		driver.findElement(By.id("txtTin")).sendKeys(sheet.getRow(1).getCell(10).getStringCellValue());
		driver.findElement(By.id("txtPan")).sendKeys(sheet.getRow(1).getCell(11).getStringCellValue());
		 txtAadhaar = (long) sheet.getRow(1).getCell(12).getNumericCellValue();
		driver.findElement(By.id("txtAadhaar")).sendKeys(txtAadhaar+"");
		WebElement countryCode = driver.findElement(By.id("ddlCountryCode"));
		countryCode.sendKeys(sheet.getRow(1).getCell(13).getStringCellValue());
		 mobileNumber = (long) sheet.getRow(1).getCell(14).getNumericCellValue();
		driver.findElement(By.id("txtMobileNumber")).sendKeys(mobileNumber+"");
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtEmail")).sendKeys(sheet.getRow(1).getCell(15).getStringCellValue());
		
		WebElement NEFT=driver.findElement(By.xpath("//input[@id='rbpayment' and  @value='SWIFT/NEFT/RTGS']"));
		NEFT.click();
		driver.findElement(By.xpath("//button[@id='btnSave']")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='btnConfirm']")).click();
			
			msg="Depositor Payment done Successfully using NEFT";			
			Expected_val="Response Status Offline";
			Actual_val=driver.findElement(By.xpath("//h3[contains(text(),'Response Status Offline')]")).getText();
			try {
				fos =new FileOutputStream(file);
				if(Actual_val.equals(Expected_val)) {
					sheet.getRow(1).createCell(16).setCellValue(msg);
				}
				else {
					sheet.getRow(1).createCell(16).setCellValue("Payment Error while Doing NEFT");
				}
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
			wb.write(fos);
			fis.close();
			
	}
	
	@AfterTest()
	
	public void closeSession() 
	{
		driver.close();
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
}