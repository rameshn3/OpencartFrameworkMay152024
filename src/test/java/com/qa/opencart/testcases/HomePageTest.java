package com.qa.opencart.testcases;

import org.testng.annotations.Test;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase{
	private Logger log = LogManager.getLogger(HomePageTest.class.getName());
	  @Test(description="TC_01_Verifying the opencart logo",priority=1)
	  public void verifyOpenCartLogoTest() {
		  log.info("Verify the logo element");
		Assert.assertTrue(homePg.isOpenCartLogoExists());
	  }
	  
	  @Test(description="TC_02_Verifying the opencart page title",priority=2)
	  public void verifyOpenCartPageTitleTest() {
		  log.info("Verify the opencart page title");
		Assert.assertEquals(homePg.getTitle(),Constants.HOME_PAGE_TITLE);
	  }
	  
	  @Test(description="TC_03_Verifying the featiured section cards count",priority=3)
	  public void verifyFeaturedCardsCountTest() {
		  log.info("Verifying the featiured section cards count");
		Assert.assertTrue(homePg.getFeaturedSectionCardsCount()==4);
	  }
	  
	  @Test(description="TC_04_navigate to registration page",priority=4)
	  public void navigateToRegistrationPageTest() throws InterruptedException {
		  log.info("navigate to registration page");
		homePg.navigateToRegisterPage();
		regPg.waitForPageLoad(2000);
		log.info("Verify the Registration page title");
		Assert.assertEquals(regPg.getTitle(),Constants.REGISTRATION_PAGE_TITLE);
		log.info("navigate back to home page");
		regPg.clickRegHomeIcon();
	  }
	  
	  @Test(description="TC_05_navigate to login page",priority=5)
	  public void navigateToLoginPageTest() throws InterruptedException {
		  log.info("navigate to login page");
		homePg.navigateToLoginPage();
		loginPg.waitForPageLoad(2000);
		log.info("Verify the Login page title");
		Assert.assertEquals(loginPg.getTitle(),Constants.LOGIN_PAGE_TITLE);
		log.info("navigate back to home page");
		loginPg.clickHomeIcon();
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  homePg.waitForPageLoad(2000);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  homePg.waitForPageLoad(2000);
		  Assert.assertEquals(homePg.getTitle(),Constants.HOME_PAGE_TITLE); 
	  }

	  @BeforeClass
	  public void beforeClass() {
		 log.info("Initilizing the page classe objects");
		 homePg=new HomePage(driver);
		 regPg=new RegistrationPage(driver);
		 loginPg=new LoginPage(driver);
	  }

	
}
