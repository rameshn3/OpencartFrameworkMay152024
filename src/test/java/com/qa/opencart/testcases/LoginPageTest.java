package com.qa.opencart.testcases;

import org.testng.annotations.Test;

import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.ForgotPasswordPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utils.Constants;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.BeforeClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;


public class LoginPageTest extends TestBase{
	
private static Logger log=LogManager.getLogger(LoginPageTest.class.getName());
  @Test(description="TC_01_Verifying the login page Url",priority=1)
  public void verifyLoginPageUrlTest() {
	  log.info("Verify the login page url test");
	Assert.assertTrue(loginPg.getLoginPageUrl().contains(Constants.LOGIN_PAGE_FRACTION_URL));
  }
  
  @Test(description="TC_02_Verifying the login page title",priority=2)
  public void verifyLoginPageTitleTest() {
	  log.info("Verify the login page title Test");
	Assert.assertEquals(loginPg.getTitle(),Constants.LOGIN_PAGE_TITLE);
  }
  
  @Test(description="TC_03_Verifying the Login page elements",priority=3)
  public void verifyLoginPageElementsTest() {
	  log.info("Verifying the login page elements");
	Assert.assertTrue(loginPg.isNewCustomerHeaderExists());
	Assert.assertTrue(loginPg.isreturningCustomerHeaderExists());
	Assert.assertTrue(loginPg.isloginBreadCrumbExists());
  }
  
  @Test(description="TC_04_navigate to registration page",priority=4)
  public void navigateToRegistrationPageTest() throws InterruptedException {
	  log.info("navigate to registration page from login page");
	loginPg.navigateToRegisterPage();
	regPg.waitForPageLoad(2000);
	log.info("Verify the Registration page title");
	Assert.assertEquals(regPg.getTitle(),Constants.REGISTRATION_PAGE_TITLE);
	log.info("navigate back to Login page");
	regPg.clickLoginPageLink();
  }
  
  @Test(description="TC_05_navigate to forgotPassword page",priority=5)
  public void navigateToForgotPasswordPageTest() throws InterruptedException {
	log.info("navigate to Forgot Password Page");
	loginPg.navigateToForgotPasswordPage();
	forgotpwdPg.waitForPageLoad(2000);
	log.info("Verify the forgot password page title");
	Assert.assertEquals(forgotpwdPg.getTitle(),Constants.FORGOT_PWD_PAGE_TITLE);
	log.info("navigate back to login page");
	forgotpwdPg.navigateToLoginPage();
  }
  
  
  @Test(description="TC_06_Empty credentials login test",priority=6)
  public void emptyCredLoginTest() throws InterruptedException {
	log.info("provide empty creds ");
	loginPg.doLogin("", "");
	loginPg.waitForPageLoad(2000);
	log.info("Verify the empty creds error message");
	if(loginPg.getEmptyCredErrorMsg().contains("No match")) {
	Assert.assertTrue(loginPg.getEmptyCredErrorMsg().contains(Constants.LOGIN_NOMATCH_ERR_MSG));
	}else {
		Assert.assertTrue(loginPg.getEmptyCredErrorMsg().contains(Constants.LOGIN_EXCEED_ERR_MSG));
	}
  }
  
  @Test(description="TC_07_Happypath login test",priority=7)
  public void happypathLoginTest() throws InterruptedException {
	log.info("TC_07_Happypath login test");
	loginPg.doLogin(rb.getString("username"), rb.getString("pwd"));
	myaccountPg.waitForPageLoad(2000);
	log.info("Verify the my account page title");
	Assert.assertEquals(myaccountPg.getTitle(),Constants.MY_ACCOUNT_PAGE_TITLE);
	
  }
  @Test(description="TC_08_Logout test",priority=7)
  public void logoutTest() throws InterruptedException {
	log.info("TC_08_logout test");
	myaccountPg.clickLogoutLink();
	logoutPg.waitForPageLoad(2000);
	log.info("Verify the logout page title");
	Assert.assertEquals(logoutPg.getTitle(),Constants.ACCOUNT_LOGOUT_PAGE_TITLE);
	logoutPg.clickContinueBtn();
	homePg.waitForPageLoad(2000);
	Assert.assertEquals(homePg.getTitle(),Constants.HOME_PAGE_TITLE); 
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  loginPg.waitForPageLoad(2000);
  }

  


  @BeforeClass
  public void beforeClass() throws InterruptedException {
	 log.info("Initilizing the page classe objects");
	 homePg=new HomePage(driver);
	 regPg=new RegistrationPage(driver);
	 loginPg=new LoginPage(driver);
	 myaccountPg=new MyAccountPage(driver);
	 forgotpwdPg=new ForgotPasswordPage(driver);
	 logoutPg=new LogoutPage(driver);
	 log.info("navigate to login page");
	 homePg.navigateToLoginPage();
	 
  }

}