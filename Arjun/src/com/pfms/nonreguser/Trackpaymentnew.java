package com.pfms.nonreguser;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Trackpaymentnew
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		File file = new File("E:\\ExtractedWebTable.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("Sheet1");

		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://164.100.30.225/Bharatkosh");

		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Track your Payment / payment history')]")).click();
		
		WebElement Email=driver.findElement(By.xpath("//input[@id='Email']"));
		Email.sendKeys("archana1@gmail.com");
		
		WebElement btton=driver.findElement(By.xpath("//input[@id='btnSendOtp']"));
		
		btton.click();
		
		WebElement otp= driver.findElement(By.xpath("//input[@id='OTP']"));
		
		otp.sendKeys("1234");
		
		WebElement otpbutton= driver.findElement(By.xpath("//body/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/form[1]/div[7]/input[5]"));
		
		otpbutton.click();
		

		WebElement table =	 driver.findElement(By.xpath("//table[@id='sample_1']//tbody"));
		List<WebElement> totalRows = table.findElements(By.tagName("tr"));
		for(int row=0; row<totalRows.size(); row++)
		{
			XSSFRow rowValue = sh.createRow(row);
			List<WebElement> totalColumns = totalRows.get(row).findElements(By.tagName("td"));
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
		wb.close();
	}
	
}