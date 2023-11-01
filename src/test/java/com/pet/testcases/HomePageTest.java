package com.pet.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pet.base.TestBase;
import com.pet.pages.BirdsPage;
import com.pet.pages.FishPage;
import com.pet.pages.HomePage;
import com.pet.pages.LoginPage;
import com.pet.pages.ReptilesPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	ReptilesPage reptilesPage;
	FishPage fishPage;
	BirdsPage birdsPage;
	HomePage homePage;
	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(priority=1)
	public void verifyTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "JPetStore Demo", "Home Page title does not match or is not displayed");
	}
		
	@Test(priority=2)
	public void verifyLogoTest() {
		boolean flag = homePage.validatePetLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyFishLink() {
		fishPage = homePage.clickOnFishLink();
	}
	
	@Test(priority=4)
	public void verifyBirdsLink() {
		birdsPage = homePage.clickOnBirdsLink();
	}
	
	@Test(priority=5)
	public void verifyReptilesLink() {
		reptilesPage = homePage.clickOnReptileLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
