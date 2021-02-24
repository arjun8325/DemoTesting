package basicseleniumconcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframeconcepts {

	
	
		static WebDriver driver;
		static String baseurl = "https://jqueryui.com/autocomplete/";
		

		public static void main(String[] args) throws InterruptedException {
		
			
			String driverpath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverpath);
			
			driver = new ChromeDriver();
			  
			driver.get(baseurl);
		
			
			List<WebElement> listofiframe = driver.findElements(By.tagName("iframe"));
			int count = listofiframe.size();
			System.out.println(count);
			
			for(int i=0; i < count;i++) 
			{
				
				
				String frame_name=listofiframe.get(i).getAttribute("frame");
				System.out.println("frame name is"+frame_name);
				//System.out.println("frame page source is"+driver.getPageSource());
				
				driver.switchTo().frame(i);
				driver.findElement(By.xpath("//input[@id='tags']")).sendKeys("java");
				Thread.sleep(1000);
				List<WebElement> dropdownvalues = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
				int countvalues = dropdownvalues.size();
				System.out.println(countvalues);
				Thread.sleep(1000);
				for(int j=0; j< countvalues;j++) {
				String str=	dropdownvalues.get(j).getText();
				System.out.println(str);
				Thread.sleep(1000);
				if(str.equals("Java")) {
					dropdownvalues.get(j).click();
					break;
				}
				}
			}
		

	}

}
