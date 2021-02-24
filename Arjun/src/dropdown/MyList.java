package dropdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyList {

	public static void main(String[] args) {
	
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.get("http://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		WebElement element=driver.findElement(By.xpath("//select[@id='animals']"));
		
		Select se= new Select(element);
		
		List orignallist= new ArrayList();
		
		List<WebElement> options=se.getOptions();
		for(WebElement e:options)
		{
			
			orignallist.add(e.getText());
			
		}
		
		System.out.println(orignallist);
		
	  List templist= new ArrayList();
	  templist=orignallist;
	  Collections.sort(templist);
		
		System.out.println("Sorted list"+templist);

	}

}
