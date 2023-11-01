package com.pet.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pet.base.TestBase;
import com.pet.pages.AngelFishPage;
import com.pet.pages.FishPage;
import com.pet.pages.HomePage;
import com.pet.pages.LoginPage;
import com.pet.pages.TigerSharkPage;

public class FishPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	FishPage fishPage;
	AngelFishPage angelFishPage;
	TigerSharkPage tigerSharkPage;
	
	public FishPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage =new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		fishPage = homePage.clickOnFishLink();
	}

	
	@Test(priority=1)
	public void validateFishLabel() {
		boolean flag =fishPage.verifyFishLabel();
		Assert.assertTrue(flag,"Fish Label is either absent or control isn't navigated to Fish Page");
	}
	
	@Test(priority=2)
	public void clickOnAngelFishLink() {
		angelFishPage = fishPage.selectAngelFish();
	}
	
	@Test(priority=3)
	public void clickOnTigerSharkLink() {
		tigerSharkPage =fishPage.selectTigerShark();
	}
	
	@Test(priority=4)
	public void clickOnReturnToMainMenuLink() {
		homePage = fishPage.clickOnMainMenu();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	

}
