package basicseleniumconcept;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowhandleconcept {

	// TODO Auto-generated method stub
	static WebDriver driver;
	static String baseurl = "http://demo.automationtesting.in/Windows.html";
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String driverpath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		driver = new ChromeDriver();
		  
		driver.get(baseurl);
		
		String parenttitle =  driver.getTitle();
		System.out.println("parent title : "+parenttitle);
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]")).click();	 
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> itr = windows.iterator();
		
		String parentid = itr.next();
		System.out.println("parent window session id : " + parentid);
		
		String childid = itr.next();
		System.out.println("child window session id : " + childid);

		driver.switchTo().window(childid);
		
		String childtitle =  driver.getTitle();
		System.out.println("child title : "+childtitle);
		
		driver.close();
		
		driver.switchTo().window(parentid);
		
		driver.close();
		
		

	}

}
