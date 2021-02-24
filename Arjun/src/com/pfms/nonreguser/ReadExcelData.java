package com.pfms.nonreguser;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		
		
		
		// TODO Auto-generated method stub
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		
		driver =new ChromeDriver();
		
		driver.manage().window().fullscreen();
		
		FileInputStream fi= new FileInputStream("C:\\Users\\Arjun\\Desktop\\NewTestData.xlsx");
		
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		
		XSSFSheet sheet1= wb.getSheetAt(0);
		
		
		int rowcount= sheet1.getLastRowNum();
		
		//System.out.println(rowcount);
		
		int colcount=sheet1.getRow(0).getLastCellNum();
	//	System.out.println(colcount);
		
		for(int i=0;i<rowcount;i++)
		{
			XSSFRow currntrow=sheet1.getRow(i);
			for(int j=0;j<colcount;j++)
			{
				
				String value=currntrow.getCell(j).getStringCellValue();
				System.out.print("      "+value);
			}
				
			System.out.println();
			
		}
		

	}

}
