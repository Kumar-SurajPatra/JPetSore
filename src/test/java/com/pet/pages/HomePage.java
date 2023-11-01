package com.pet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pet.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//a[text()='My Account']")
	@CacheLookup    /*this annotation is used to create a cache memory to 
	                  store the xpath to myAccount variable so the speed is enhanced*/
	WebElement myAccount;
	
	@FindBy(xpath="(//div[@id='QuickLinks']//a//img)[1]")
	WebElement fishBtn;
	
	@FindBy(xpath="(//div[@id='QuickLinks']//a//img)[2]")
	WebElement dogsBtn;
	
	@FindBy(xpath="(//div[@id='QuickLinks']//a//img)[3]")
	WebElement reptilesBtn;
	
	@FindBy(xpath="(//div[@id='QuickLinks']//a//img)[4]")
	WebElement catsBtn;
	
	@FindBy(xpath="(//div[@id='QuickLinks']//a//img)[5]")
	WebElement birdsBtn;
	
	@FindBy(xpath="//div[@id='LogoContent']//a//img")
	WebElement logo;
	
	
	//Initializing page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatePetLogo() {
		return logo.isDisplayed();
	}
	
	public FishPage clickOnFishLink() {
		fishBtn.click();
		return new FishPage();
	}
	
	public ReptilesPage clickOnReptileLink() {
		reptilesBtn.click();
		return new ReptilesPage();
	}
	
	public CatsPage clickOnCatLink() {
		catsBtn.click();
		return new CatsPage();
	}
	
	public DogsPage clickOnDogLink() {
		dogsBtn.click();
		return new DogsPage();
	}
	
	public BirdsPage clickOnBirdsLink() {
		birdsBtn.click();
		return new BirdsPage();
	}
}



