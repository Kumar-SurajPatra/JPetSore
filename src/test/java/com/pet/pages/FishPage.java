package com.pet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pet.base.TestBase;

public class FishPage extends TestBase{
	
	@FindBy(xpath="//*[text()='Fish']")
	WebElement fishLabel;

	@FindBy(xpath="//td[text()='Angelfish']//preceding-sibling::td//a")
	WebElement angelFishId;
	
	@FindBy(xpath="//td[text()='Tiger Shark']//preceding-sibling::td//a")
	WebElement tigerSharkId;
	
	@FindBy(xpath="//td[text()='Koi']//preceding-sibling::td//a")
	WebElement koiId;
	
	@FindBy(xpath="//td[text()='Goldfish']//preceding-sibling::td//a")
	WebElement goldFishId;
	
	@FindBy(xpath="//a[text()='Return to Main Menu']")
	WebElement mainMenuBtn;
	
	public FishPage() {
	PageFactory.initElements(driver,this);
	}
	
	public boolean verifyFishLabel() {
		return fishLabel.isDisplayed();
	}
	
	public AngelFishPage selectAngelFish() {
		angelFishId.click();
		return new AngelFishPage();
	}
	
	public TigerSharkPage selectTigerShark() {
		tigerSharkId.click();
		return new TigerSharkPage();
	}
	
	public HomePage clickOnMainMenu() {
		mainMenuBtn.click();
		return new HomePage();
	}

}
