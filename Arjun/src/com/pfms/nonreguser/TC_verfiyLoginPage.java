package com.pfms.nonreguser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_verfiyLoginPage

{
	WebDriver driver;
	
	@Test()
	public void Verifylogi()
	{
		
		
		System.setProperty("webdriver.chrome.driver", "E:\\PFMS\\NEWPFMS\\browser\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		
		driver.get("http://demosite.center/wordpress/wp-login.php?redirect_to=http%3A%2F%2Fdemosite.center%2Fwordpress%2Fwp-admin%2Fwidgets.php&reauth=1");
		driver.manage().window().maximize();
		
		
		LoginPage p= new LoginPage(driver);
		
		p.typeusername("admin");
		p.typepassword("demo123");
		p.ClickLogin();
		
		
		
	}
	
	
}


