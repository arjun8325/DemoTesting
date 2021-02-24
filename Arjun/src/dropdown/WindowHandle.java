package dropdown;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Open New Tabbed Windows')]")).click();
		
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]")).click();
		
		Set<String> s=driver.getWindowHandles();
		
		for(String i:s)
		{
			System.out.println(i);
			String tt= driver.switchTo().window(i).getTitle();
			System.out.println(tt);
			
			if(tt.contains("SeleniumHQ Browser Automation"))
			{
				driver.quit();
			
		}
		
		
		

	}

	}
}

