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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPayment

{
	
	WebDriver driver;
	File file;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileOutputStream fos;
	FileInputStream fis;
	long Amount;
	String msg,Expected_val,Actual_val;
		
	@BeforeTest()	
	public void OpenBrowser() 
	{
		/*************************Launching Web Browser**************************************/
		
		try
		{
			
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://164.100.30.225/Bharatkosh");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}
		catch(Exception e)
		{
			System.out.println("Error while Opening Chrome");
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
			System.out.println("Error while reading Sheet1");
			
		}
		
		/*********************************Entering Login Name and Password*************************/
		
	  WebElement username=	driver.findElement(By.xpath("//input[@id='UserName']"));
	  username.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
	  WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
	  password.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		
	  driver.findElement(By.id("btnSubmit")).click();
	  /*************************** Menu Navigation Click on Make Your Payment Link************************************************************/
		
		driver.findElement(By.xpath("//a[@title='Make your Payment']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Payment to GoI']")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'Payment to GoI')]")).click();
		 
		 
	}
	
		@Test(priority=2, dependsOnMethods = {"LoginUser"})
		
		public void Paymentpurpose() throws Exception
		{

			
			//driver.findElement(By.xpath("//div[@class='inner-box']/a/h5")).click();
			
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
		
		//WebElement depositorCategory = driver.findElement(By.id("ddlDepsitorCategory"));
		
		//depositorCategory.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		
		
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
			if(Actual_val.equals(Expected_val))
			{
				sheet.getRow(1).createCell(5).setCellValue(msg);
			}
			else {
				sheet.getRow(1).createCell(5).setCellValue("Payment Error can not be saved");
			}
		}
		
		catch(IOException ex) {
			ex.printStackTrace();
		}

		wb.write(fos);
		fis.close();
		
	}

	@Test(priority=2,dependsOnMethods = {"LoginUser"})
	
	public void depositor() throws IOException
	
	{
		/*************
		 * This Will Automate Depositor detail Info Module*****/
		try
		{
			file = new File("C:\\Users\\Arjun\\Desktop\\Loginpaynew.xlsx");
			fis= new FileInputStream(file);
			wb= new XSSFWorkbook(fis);
			sheet=wb.getSheet("Sheet3");
			
		}
		catch(Exception e)
		{
			System.out.println("Error Reading Sheet 3 ");
			
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
		long txtPinCode1 = (long) sheet.getRow(1).getCell(8).getNumericCellValue();
		driver.findElement(By.id("txtPinCode")).sendKeys(txtPinCode1+"");
		driver.findElement(By.id("txtTan")).sendKeys(sheet.getRow(1).getCell(9).getStringCellValue());
		driver.findElement(By.id("txtTin")).sendKeys(sheet.getRow(1).getCell(10).getStringCellValue());
		driver.findElement(By.id("txtPan")).sendKeys(sheet.getRow(1).getCell(11).getStringCellValue());
		long txtAadhaar = (long) sheet.getRow(1).getCell(12).getNumericCellValue();
		driver.findElement(By.id("txtAadhaar")).sendKeys(txtAadhaar+"");
		WebElement countryCode = driver.findElement(By.id("ddlCountryCode"));
		countryCode.sendKeys(sheet.getRow(1).getCell(13).getStringCellValue());
		long mobileNumber = (long) sheet.getRow(1).getCell(14).getNumericCellValue();
		driver.findElement(By.id("txtMobileNumber")).sendKeys(mobileNumber+"");
		driver.findElement(By.id("txtEmail")).clear();
		driver.findElement(By.id("txtEmail")).sendKeys(sheet.getRow(1).getCell(15).getStringCellValue());

		//To select mode of payment radio button
		//driver.findElement(By.id("rbpayment")).sendKeys(sheet.getRow(1).getCell(15).getStringCellValue());
			
			driver.findElement(By.xpath("//button[@id='btnSave']")).click();
			msg="Depositor Purpose Saved ";
			Expected_val="3";
			Actual_val=driver.findElement(By.xpath("//a[contains(text(),'3')]")).getText();
			try {
				fos =new FileOutputStream(file);
				if(Actual_val.equals(Expected_val)) {
					sheet.getRow(1).createCell(2).setCellValue(msg);
				}
				else {
					sheet.getRow(1).createCell(2).setCellValue("Some Error");
				}
			}
			
			catch(IOException ex) {
				ex.printStackTrace();
			}

			wb.write(fos);
			fis.close();
			
		}	 
		 @Test(priority=3, dependsOnMethods= {"depositor"})
		 
	           public void ConfirmPayment() throws InterruptedException, IOException 
		 {
			 /*************
				 * This Will Automate Confirm Info Module*****/
			 try
				{
					file = new File("C:\\Users\\Arjun\\Desktop\\Loginpaynew.xlsx");
					fis= new FileInputStream(file);
					wb= new XSSFWorkbook(fis);
					sheet=wb.getSheet("Sheet4");
					
				}
				catch(Exception e)
				{
					System.out.println("Error while opneing sheet4");
					
				}		
				//Click Confirm button for save record
				driver.findElement(By.xpath("//button[@id='btnConfirm']")).click();
				driver.findElement(By.xpath("//body/section[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[4]/label[1]/input[1]")).click();	
				driver.findElement(By.xpath("//li[@id='NetBank']")).click();
				Select ele=new Select(driver.findElement(By.id("lstggregatorBankForInternetBanking")));
				ele.selectByVisibleText("UNION BANK OF INDIA");
				driver.findElement(By.xpath("//input[@id='mycheckbox']")).click();
				driver.findElement(By.id("BtnPay")).click();
				 msg="Payment Done Successfully";
				 Expected_val = "Payment has been done successfully.";
				 Actual_val = driver.findElement(By.xpath("//p[contains(text(),'Payment has been done')]")).getText();
				
				try 
				{
					fos =new FileOutputStream(file);
					if(Actual_val.equals(Expected_val)) {
						sheet.getRow(1).createCell(1).setCellValue(msg);
					}
					else {
						sheet.getRow(1).createCell(1).setCellValue("Payment Error");
					}
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}
		
				wb.write(fos);
				fis.close();
		 }
	
	@AfterTest()
	
	public void closeAll() throws IOException
	{
		driver.close();
		fos.close();	
	}
	
}
