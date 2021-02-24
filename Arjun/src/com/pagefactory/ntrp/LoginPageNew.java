package com.pagefactory.ntrp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageNew 
{
	
	
	WebDriver driver;
	
	public LoginPageNew(WebDriver lDriver)
	{
		this.driver=lDriver;
		
		
	}
	
	@FindBy(id="user_login") WebElement username;
	@FindBy(how=How.ID,using="user_pass") WebElement password;
	@FindBy(how=How.XPATH,using="//input[@id='wp-submit']") WebElement Submit;
	
	
	
	public void loginwordpress(String uid,String Pass)
	
	{
		username.sendKeys(uid);
		password.sendKeys(Pass);
		Submit.click();
	}
	
	

}
