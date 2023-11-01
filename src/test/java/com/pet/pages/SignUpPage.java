package com.pet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.pet.base.TestBase;

public class SignUpPage extends TestBase{
	
	@FindBy(xpath="//*[text()='User Information']")
	WebElement userInformationLabel;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='repeatedPassword']")
	WebElement rePwd;
	
	@FindBy(xpath="//input[@name='account.firstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='account.lastName']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='account.email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='account.phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@name='account.address1']")
	WebElement address1;
	
	@FindBy(xpath="//input[@name='account.address2']")
	WebElement address2;
	
	@FindBy(xpath="//input[@name='account.city']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='account.state']")
	WebElement state;
	
	@FindBy(xpath="//input[@name='account.zip']")
	WebElement zip;
	
	@FindBy(xpath="//input[@name='account.country']")
	WebElement country;
	
	@FindBy(xpath="//select[@name='account.languagePreference']")
	WebElement langPref;
	
	@FindBy(xpath="//select[@name='account.favouriteCategoryId']")
	WebElement favCategoryId;
	
	@FindBy(xpath="//input[@name='account.listOption']")
	WebElement listOpCheckBox;
	
	@FindBy(xpath="//input[@name='account.bannerOption']")
	WebElement myBannerCheckBox;
	
	@FindBy(xpath="//input[@name='newAccount']")
	WebElement saveBtn;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyTitle() {
		return userInformationLabel.isDisplayed();
	}
	public void createNewUser(String uid,String pwd,String fname,String lname,String email,
			String phn,String add1,String add2,String city,String state,String zip,String country,
			String lang,String category,boolean myList,boolean myBanner) {
		
		username.sendKeys(uid);
		password.sendKeys(pwd);
		rePwd.sendKeys(pwd);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		this.email.sendKeys(email);
		phone.sendKeys(phn);
		address1.sendKeys(add1);
		address2.sendKeys(add2);
		this.city.sendKeys(city);
		this.state.sendKeys(state);
		this.zip.sendKeys("zip");
		this.country.sendKeys(country);
		Select select = new Select(langPref);
		select.selectByVisibleText(lang);
		select = new Select(favCategoryId);
		select.selectByVisibleText(category);
		if(myList==true)
			listOpCheckBox.click();
		if(myBanner==true)
			myBannerCheckBox.click();
		
		saveBtn.click();		
		
	}
	
	
	

}
