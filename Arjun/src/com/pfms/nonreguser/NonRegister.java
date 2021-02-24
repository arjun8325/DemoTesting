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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NonRegister {

	WebDriver driver;
	FileInputStream fi;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileOutputStream fos;
	File f;

	@BeforeTest()
	public void setup() throws Exception {

		{

			System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			// String homepage="http://164.100.30.225/Bharatkosh";
			driver.get("http://164.100.30.225/Bharatkosh");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
	}

	@Test(priority = 0)
	public void Payment() throws Exception {

		WebElement regi = driver.findElement(By.xpath("//span[contains(text(),'Non-Registered Users')]"));
		regi.click();

		try 
		{
			File f = new File("E:\\NonRegi.xlsx");
			fi = new FileInputStream(f);
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheet("Sheet1");

		} catch (Exception ex) {

			System.out.println("Error opening excel");
			ex.printStackTrace();

		}

		WebElement dc = driver.findElement(By.id("ddlDepsitorCategory"));

		dc.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());

		driver.findElement(By.xpath("//form[@id='frmMinistryInfo']//a")).click();

		WebElement ministry = driver.findElement(By.id("ddlMinistry"));

		ministry.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());

		driver.findElement(By.id("btnsearch")).click();

		String searchLink = sheet.getRow(1).getCell(2).getStringCellValue();

		driver.findElement(By.linkText(searchLink)).click();

		WebElement PAO = driver.findElement(By.id("ddlPAO"));

		PAO.sendKeys(sheet.getRow(1).getCell(3).getStringCellValue());

		WebElement DDO = driver.findElement(By.id("ddlDDO"));

		DDO.sendKeys(sheet.getRow(1).getCell(4).getStringCellValue());

		// WebElement Amount= driver.findElement(By.id("txtAmount"));

		// Amount.sendKeys(sheet.getRow(1).getCell(5).getStringCellValue());

		driver.findElement(By.id("txtAmount")).clear();

		int Amount = (int) sheet.getRow(1).getCell(5).getNumericCellValue();

		driver.findElement(By.id("txtAmount")).sendKeys(Amount + "");

		driver.findElement(By.id("txtPurposeRemarks")).sendKeys(sheet.getRow(1).getCell(6).getStringCellValue());

		driver.findElement(By.id("Add_")).click();

		driver.findElement(By.xpath("//body/section[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[3]/button[1]")).click();
		
		String sendmsg = "Payment saved.";
		
		String expectedvalue = "Depositor's Details";
		
		String pageValidate = driver.findElement(By.xpath("//*[@id='divDepositor']/div[1]/h3")).getText();
		try {
			fos =new FileOutputStream(f);
			if(pageValidate.equals(expectedvalue)) {
				sheet.getRow(1).createCell(7).setCellValue(sendmsg);
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
	
	public void Close() throws IOException {
		wb.close();
		fi.close();
		fos.close();
		driver.quit();
	}
}
