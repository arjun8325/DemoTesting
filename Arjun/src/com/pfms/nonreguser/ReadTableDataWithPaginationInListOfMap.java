package com.pfms.nonreguser;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ReadTableDataWithPaginationInListOfMap {

 public static WebDriver driver;

 public static void main(String[] args) throws Exception {



	 System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
 
  compareDispalyedRowCountToActualRowCount();
 }

 public static void compareDispalyedRowCountToActualRowCount() throws Exception {

  try {
   Thread.sleep(5000);
   List<WebElement> namesElements = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
   System.out.println("size of names elements : " + namesElements.size());

   List<String> names = new ArrayList<String>();
   //Adding column1 elements to the list
   for (WebElement nameEle : namesElements) {
    names.add(nameEle.getText());
   }
   //Displaying the list elements on console
   for (WebElement s : namesElements) {
    System.out.println(s.getText());
   }
   
   //locating next button
   String nextButtonClass = driver.findElement(By.id("example_next")).getAttribute("class");

   //traversing through the table until the last button and adding names to the list defined about
   while (!nextButtonClass.contains("disabled")) {
    driver.findElement(By.id("example_next")).click();
    Thread.sleep(1000);
    namesElements = driver.findElements(By.cssSelector("#example>tbody>tr>td:nth-child(1)"));
    for (WebElement nameEle : namesElements) {
     names.add(nameEle.getText());
    }
    nextButtonClass = driver.findElement(By.id("example_next")).getAttribute("class");
   }
   //printing the whole list elements
   for (String name : names) {
    System.out.println(name);
   }
   //counting the size of the list
   int actualCount = names.size();
   System.out.println("Total number of names :" + actualCount);

   //locating displayed count 
   String displayedCountString = driver.findElement(By.id("example_info")).getText().split(" ")[5];
   int displayedCount = Integer.parseInt(displayedCountString);

   System.out.println("Total Number of Displayed Names count:" + displayedCount);

   Thread.sleep(1000);

   // Actual count calculated Vs Dispalyed Count
   if (actualCount == displayedCount) {
    System.out.println("Actual row count = Displayed row Count");
   } else {
    System.out.println("Actual row count !=  Displayed row Count");
    throw new Exception("Actual row count !=  Displayed row Count");
   }
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
}