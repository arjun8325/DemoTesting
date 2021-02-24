package dropdown;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HttpUrlConnection {
	
	

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		List<WebElement>links= driver.findElements(By.tagName("a"));
		Thread.sleep(3000);
		//System.out.println(links.size());
		for(int i=0;i<links.size();i++)
		{
			WebElement element= links.get(i);
			String url= element.getAttribute("href");
			System.out.println(url);
			URL link = new URL(url);
			HttpURLConnection  httpconn=(HttpURLConnection) link.openConnection();
			Thread.sleep(3000);
			httpconn.connect();
			int resp=httpconn.getResponseCode();
			
			if(resp>=400)
			{
				System.out.println(url+ " "+ "is a broken");
				
			}
			else
			{
				System.out.println(url+ " "+ "is a valid");
			}
		}

	}

}
