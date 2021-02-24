package basicseleniumconcept;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	
	static WebDriver driver;
	static String baseurl = "https://www.guru99.com/scroll-up-down-selenium-webdriver.html";
	
	public static void main(String[] args) 
	{
	
		String driverpath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		driver = new ChromeDriver();https://www.guru99.com/scroll-up-down-selenium-webdriver.html
		
		driver.manage().window().maximize();
		  
		driver.get(baseurl);
		
		List<WebElement>links=driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links"+links.size());
		
		for (int i=0;i<links.size();i++)
		{
			String S=links.get(i).getText();
			System.out.println(S);
			
		}
		
	
	}
	
	

}
