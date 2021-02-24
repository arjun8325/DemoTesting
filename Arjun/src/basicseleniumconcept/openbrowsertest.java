package basicseleniumconcept;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openbrowsertest {

	public static void main(String[] args) throws InterruptedException {
		
		String driverpath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ck12.org/student/");
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.findElement(By.xpath("//span[contains(text(),'sign in')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@name='login']")).sendKeys("chatterjeeamit42@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Testing12345$");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		Thread.sleep(1000);
		driver.close();
		
		System.out.println("test cases execute successfully");

	}

}
