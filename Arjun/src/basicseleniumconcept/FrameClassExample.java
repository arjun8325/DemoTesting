package basicseleniumconcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameClassExample {

	
	static WebDriver driver;
	static String url="https://www.globalsqa.com/demo-site/";
	
	

public static void main(String arg[]) throws InterruptedException
{
	
	String driverpath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	
	System.setProperty("webdriver.chrome.driver", driverpath);
	
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		  
		driver.get(url);
		
		
		driver.findElement(By.linkText("Frames")).click();
		
		driver.findElement(By.xpath("//li[@id='iFrame']")).click();
		
		////iframe[contains(text(),'<br>')]
		
		driver.findElement(By.xpath("//iframe[contains(text(),'<br>')]")).sendKeys("java");
		
		Thread.sleep(2000);
		/*
		 * List<WebElement>
		 * dropdown=driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));
		 * 
		 * int count=dropdown.size();
		 * 
		 * System.out.println("Total number of list"+count);
		 * 
		 * for(int i=0;i<count;i++)
		 * 
		 * { String S= dropdown.get(i).getText(); System.out.println(S);
		 * Thread.sleep(7000);
		 * 
		 * if(S.startsWith("j")) { dropdown.get(i).click(); break;
		 * 
		 * }
		 * 
		 * }
		 */
		//if(dropdrown1.)
}


}

