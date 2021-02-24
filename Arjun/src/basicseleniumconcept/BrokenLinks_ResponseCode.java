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

public class BrokenLinks_ResponseCode {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String homePage = "http://demo.guru99.com/test/newtours/";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		// Set the path for chromedriver.exe
				String path = System.getProperty("user.dir");
				System.out.println(path);
				System.setProperty("webdriver.chrome.driver", path + "\\drivers\\chromedriver.exe");

				// opening the chrome browser
				WebDriver driver = new ChromeDriver();

				// Deleting cookies
				driver.manage().deleteAllCookies();

				// hitting the url
				//driver.get("http://demo.guru99.com/test/ajax.html");

				// maximize the browser window
				driver.manage().window().maximize();

		driver.get(homePage);

		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());

		Iterator<WebElement> it = links.iterator();

		while (it.hasNext()) {

			url = it.next().getAttribute("href");

			System.out.println(url);

			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if (!url.startsWith(homePage)) {
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection) (new URL(url).openConnection());

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