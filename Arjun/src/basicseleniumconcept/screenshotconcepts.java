package basicseleniumconcept;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenshotconcepts {

	//static WebDriver driver;
	static ChromeDriver driver;
	static String baseurl = "http://demo.automationtesting.in/Windows.html";
	
	static String fileWithPath = System.getProperty("user.dir")+ "\\screenshots\\arjun.png";

	public static void main(String[] args) throws InterruptedException, IOException {
	
		
		String driverpath = System.getProperty("user.dir") + "\\browser\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		driver = new ChromeDriver();
		  
		driver.get(baseurl);
		
		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot : Interface
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
		
		
	//	TakesScreenshot scrShot2 = driver;
		File SrcFile1 = driver.getScreenshotAs(OutputType.FILE);
		File DestFile1 = new File(fileWithPath);
		FileUtils.copyFile(SrcFile, DestFile);
		
		
		driver.close();


	}

}
