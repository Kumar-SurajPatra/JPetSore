package com.pet.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pet.base.TestBase;
import com.pet.pages.LoginPage;
import com.pet.pages.SignUpPage;
import com.pet.util.TestUtil;

public class SignUpPageTest extends TestBase{
	
	LoginPage loginPage;
	SignUpPage signUpPage;
	String testSheet = "SignUp";
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		signUpPage = loginPage.signUp();
	}
	
	@Test(priority=1)
	public void validateTitleTest() {
		boolean flag = signUpPage.verifyTitle();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getSignUpData() throws EncryptedDocumentException, IOException {
		Object[][]data = TestUtil.getTestData(testSheet);
		return data;
	}
	
	@Test(priority=2, dataProvider="getSignUpData")
	public void validateCreateAccountTest(String userId, String password, String firstName, 
			String lastName,String email, String phn, String add1, String add2, String city, 
			String state, String zip, String country,String lang, String category) {
		    signUpPage.createNewUser(userId,password,firstName,lastName,email,phn,add1,add2,
		    city,state, zip, country,lang,category,true,true);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
