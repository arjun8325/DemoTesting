package com.pfms.nonreguser;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MoneyControl {

	public static void main(String[] args) throws IOException {
		
		
		
		// TODO Auto-generated method stub
		
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		
		
		driver =new ChromeDriver();
		
		
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		driver.manage().window().maximize();
		
		FileInputStream fi= new FileInputStream("C:\\Users\\Arjun\\Desktop\\Money.xlsx");
		
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		
		XSSFSheet sheet= wb.getSheet("Sheet1");
		
		
		int rowcount= sheet.getLastRowNum();
		
		int colcount=sheet.getRow(0).getLastCellNum();
		
		System.out.println("Total Rows are"+rowcount);
		
		System.out.println("Total Columns are"+colcount);
		
		
		for(int i=1;i<=rowcount;i++)
		{
			
			XSSFRow row= sheet.getRow(i);
			
			//String pr= row.getCell(0).getStringCellValue();
			XSSFCell principlecell= row.getCell(0);
			int principle= (int) principlecell.getNumericCellValue();
			
			XSSFCell rateofinterest= row.getCell(1);
			int roi= (int) rateofinterest.getNumericCellValue();
			
			XSSFCell period= row.getCell(2);
			int per= (int) period.getNumericCellValue();
			
			XSSFCell frequency= row.getCell(3);
			String freq= frequency.getStringCellValue();

			
			XSSFCell maturity= row.getCell(4);
			double mat= (double) maturity.getNumericCellValue();
			
			
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(principle));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(roi));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));
			
			Select pp= new Select(driver.findElement(By.id("tenurePeriod")));
			pp.selectByVisibleText("year(s)");
			
			Select freqn= new Select(driver.findElement(By.id("frequency")));
			freqn.selectByVisibleText(freq);
			
			
			driver.findElement(By.xpath("//body/div[@id='mc_mainWrapper']/div[2]/div[1]/div[5]/div[1]/div[1]/div[3]/form[1]/div[2]/a[1]/img[1]")).click();
			
			
			String actual_v= driver.findElement(By.xpath("//span[@id='resp_matval']")).getText();
			
			if(Double.parseDouble(actual_v)==mat)
				{
				System.out.println("Test Case Pass");
				}
			else
			{
				System.out.println("Fail");
			}
			
		}
		
	driver.findElement(By.xpath("//body/div[@id='mc_mainWrapper']/div[2]/div[1]/div[5]/div[1]/div[1]/div[3]/form[1]/div[2]/a[2]/img[1]")).clear();
		

	}

}
