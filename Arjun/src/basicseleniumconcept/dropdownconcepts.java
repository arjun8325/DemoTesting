package basicseleniumconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownconcepts {
	static WebDriver driver;
	static String baseurl = "http://the-internet.herokuapp.com/dropdown";
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String driverpath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		driver = new ChromeDriver();
		
		driver.get(baseurl);
	//	driver.navigate().to(baseurl);
		
		Select listdropdown =  new Select(driver.findElement(By.id("dropdown")));
		listdropdown.selectByIndex(1);
		Thread.sleep(1000);
		listdropdown.selectByValue("2");
		Thread.sleep(1000);
		listdropdown.selectByVisibleText("Option 1");
		Thread.sleep(1000);
		System.out.println("passed");
	}

}
