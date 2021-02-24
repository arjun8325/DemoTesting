package basicseleniumconcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseOverConcepts {

	static WebDriver driver;
	static String baseurl = "http://demo.automationtesting.in/Windows.html";
	static String url = "https://swisnl.github.io/jQuery-contextMenu/demo.html";

	public static void main(String[] args) throws InterruptedException {
	
		
		String driverpath = System.getProperty("user.dir") + "\\browser\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		driver = new ChromeDriver();
		  
		driver.get(url);
		
		//WebElement first =  driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]"));
		//
		//WebElement second =  driver.findElement(By.xpath("//header/nav[1]/div[1]/div[2]/ul[1]/li[4]/ul[1]/li[2]/a[1]"));
		
		WebElement Button =  driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/p/span"));
		Actions act = new Actions(driver);
		//mouseover.moveToElement(first).moveToElement(second).click().build().perform();
		act.contextClick(Button).build().perform();
		
		driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		//Thread.sleep(10000);
		
		
		// (//header/nav[1]/div[1]/div[2]/ul[1]/li[4]/ul[1]/li[2]/a[1])[3]
		
	}

}
