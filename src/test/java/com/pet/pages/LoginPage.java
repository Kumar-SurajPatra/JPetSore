package com.pet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pet.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@name='signon']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Register Now!')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="(//a//img)[1]")
	WebElement logo;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatePetLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	
	public SignUpPage signUp() {
		signUpBtn.click();
		return new SignUpPage();
	}
}
