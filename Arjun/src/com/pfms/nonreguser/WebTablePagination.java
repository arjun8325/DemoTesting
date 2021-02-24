package com.pfms.nonreguser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTablePagination {

	
	
	
	WebDriver driver;
	
	@BeforeTest()
	public void launch_browser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://164.100.30.225/Bharatkosh");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		
		
	}

	@Test
	
	public void WebTable() throws InterruptedException

	{
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,800)");
		
		
		driver.findElement(By.xpath("//h5[contains(text(),'LOGIN / REGISTER')]")).click();
		
		driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("arjun888");

		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Diwan@8325");
		
		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Track your Payment')]")).click();
		
		
		//driver.findElement(By.id("MobileNo")).sendKeys("9876543298");
		
		
		/*
		 * driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(
		 * "arjundiwan@gmail.com"); driver.findElement(By.id("btnSendOtp")).click();
		 * driver.findElement(By.xpath("//input[@id='OTP']")).sendKeys("1234");
		 */
		driver.findElement(By.xpath("//input[@id='btnSubmit']")).click();
		Thread.sleep(2000);
		int PageSize= driver.findElements(By.xpath("//a[contains(text(),'»')]")).size();
		System.out.println("page size is"+PageSize);
		if(PageSize>0) 
		{
			
			driver.findElement(By.xpath("//a[contains(text(),'»')]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='loaderbackground']")));
			List<String> Transactions= new ArrayList<String>();
			String pageselect ="ul[class=\"pagination ng-isolate-scope\"]>li>a:nth-child(1)";
			driver.findElement(By.cssSelector(pageselect)).click();
			
			List<WebElement> Transactionele= driver.findElements(By.xpath("//table[@id='sample_1']/tbody/tr/td[1]"));
			
			for(WebElement Transactionnumber: Transactionele)
			{
				Transactions.add(Transactionnumber.getText());
			}	
	
		  for(String NewTrans :Transactions) 
		  {
			  System.out.println(NewTrans); 
			  
		  }
		  
		 
		int TotalTrans=Transactions.size();
		
		System.out.println("TotalTransaction are"+TotalTrans);
		
		
		}
	}
	
}
