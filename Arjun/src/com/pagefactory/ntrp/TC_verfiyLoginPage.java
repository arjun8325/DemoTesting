package com.pagefactory.ntrp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class TC_verfiyLoginPage

{
	
	
	WebDriver driver;
	LoginPageNew login_page ;
	@Test()
	
	public void Verifylogi()
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php?redirect_to=http%3A%2F%2Fdemosite.center%2Fwordpress%2Fwp-admin%2Fwidgets.php&reauth=1");
		driver.manage().window().maximize();
		login_page=PageFactory.initElements(driver,LoginPageNew.class);
		login_page.loginwordpress("admin", "demo123");
		
	
	}
	
	
}


