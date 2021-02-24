package basicseleniumconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class getattributeconcepts {

	static WebDriver driver;
	static String baseurl = "http://elementalselenium.com/";
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String driverpath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		driver = new ChromeDriver();
		
		driver.get(baseurl);
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,2000)");
		 
		 WebElement str = driver.findElement(By.xpath("//input[@id='email']"));
				 str.sendKeys("arjun");
				 Thread.sleep(1000);
			System.out.println("data : " + str.getText());
			Thread.sleep(1000);
			System.out.println("value : " +  str.getAttribute("value"));
			Thread.sleep(1000);
		 
		 
		 
	}

}
