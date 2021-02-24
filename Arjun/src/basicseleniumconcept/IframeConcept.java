package basicseleniumconcept;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeConcept {


	
	 static WebDriver driver;
	 static String url="https://jqueryui.com/autocomplete/";
	 
	public static void main(String[] args) {
		
		String Driver_path=System.getProperty("user.dir")+ "\\browser\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Driver_path);
		
		driver=new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		
		
		
		
		
	}

}
