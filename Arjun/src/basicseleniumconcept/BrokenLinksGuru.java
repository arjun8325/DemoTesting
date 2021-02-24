package basicseleniumconcept;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksGuru {

	
	static WebDriver driver;
	static String nurl="http://demo.guru99.com/test/newtours/";
	
	public static void main(String[] args) {
		
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		
		String driverpath=System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
		
		System.setProperty("webdriver.chrome.driver", driverpath);
		
		driver= new ChromeDriver();
		
		driver.get(nurl);
		
		driver.manage().window().maximize();
		
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		int total =links.size();
		
		System.out.println("Total Links are"+total);
		
		for(int i=0;i<links.size();i++)
		{
			String all_links=links.get(i).getText();
			System.out.println(all_links);
		}
		
		Iterator<WebElement> itr= links.iterator();
		
		
		while (itr.hasNext())
		{
			
			url=itr.next().getAttribute("href");
			
			System.out.println(url);
			
			if(url==null || url.isEmpty())
			{
				System.out.println("URL is Empty");
				continue;
			}
			if(!url.startsWith(nurl))
			{
				System.out.println("URL belong to anotherdomain");
				continue;
				
			}
			
			try {
				huc= (HttpURLConnection) (new URL(url).openConnection());
				
				huc.setRequestMethod("HEAD");
				huc.connect();
	
				respCode = huc.getResponseCode();
				System.out.println(respCode);
				
				
				if (respCode >= 400) {
					System.out.println(url + " is a broken link");
				} else {
					System.out.println(url + " is a valid link");
				}
				
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		driver.quit();
	}

}
