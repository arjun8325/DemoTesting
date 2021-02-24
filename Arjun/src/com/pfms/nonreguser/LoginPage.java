package com.pfms.nonreguser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * 
 * 
 * This will store Locator 
 * 
 */

public class LoginPage {
	
	
	WebDriver driver;
	
	By username=By.id("user_login");
	By password=By.id("user_pass");
	
	By loginButton=By.xpath("//input[@id='wp-submit']");
	
	
	public LoginPage(WebDriver driver)
	
	{
		this.driver=driver;
		
	}

	public void typeusername(String uid)
	
	{
	driver.findElement(username).sendKeys(uid);
		
	}
	
	public void typepassword(String pass)
	{
		
		driver.findElement(password).sendKeys(pass);
	}
	
	public void ClickLogin()
	{
		
		driver.findElement(loginButton).click();
	}
	
	
}
