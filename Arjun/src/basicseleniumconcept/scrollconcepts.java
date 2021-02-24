package basicseleniumconcept;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scrollconcepts {

	// TODO Auto-generated method stub
	static WebDriver driver;
	static String baseurl = "https://www.selenium.dev/";
	static JavascriptExecutor js;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String driverpath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		  
		driver.get(baseurl);
		
	    js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");//x axis , y axis
		
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");
		
		Thread.sleep(1000);
		
		  //Find element by link text and store in variable "Element"        		
     //   WebElement Element = driver.findElement(By.xpath("//h2[contains(text(),'News')]"));

        //This will scroll the page till the element is found		
     //   js.executeScript("arguments[0].scrollIntoView();", Element);
		
		Thread.sleep(1000);
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        
	    System.out.println("passed");
		
	}

}
