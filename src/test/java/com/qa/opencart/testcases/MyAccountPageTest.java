package com.qa.opencart.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.qa.opencart.factory.TestBase;
import com.qa.opencart.pages.ForgotPasswordPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.LogoutPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.pages.ResultsPage;
import com.qa.opencart.utils.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class MyAccountPageTest extends TestBase{
	
private static Logger log=LogManager.getLogger(MyAccountPageTest.class.getName());
  @Test(description="TC_01_Verifying the MyAccount page Url",priority=1)
  public void verifyMyAccountPageUrlTest() {
	  log.info("Verify the MyAccount page url test");
	Assert.assertTrue(myaccountPg.getMyAccountPageUrl().contains(Constants.ACC_PAGE_FRACTION_URL));
  }
  
  @Test(description="TC_02_Verifying the my account page title",priority=2)
  public void verifyMyAccountPageTitleTest() {
	  log.info("Verify the  my account page title Test");
	Assert.assertEquals(myaccountPg.getTitle(),Constants.MY_ACCOUNT_PAGE_TITLE);
  }
  
  @Test(description="TC_03_Verifying the My Account page elements",priority=3)
  public void verifyMyAccountPageElementsTest() throws InterruptedException {
	  log.info("Verifying the MyAccount page elements");
	Assert.assertTrue(myaccountPg.isSearchEditboxExists());
	Assert.assertTrue(myaccountPg.isLogoutExists());
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ESCAPE).perform();
  }
  
  @Test(description="TC_04_Verify My account options List ",priority=4)
  public void verifyMyAccountMenuOptionTest() throws InterruptedException {
	  log.info("TC_04_Verify My account options List");

	Assert.assertEquals(myaccountPg.getMyAccountMenuOptionList(),Constants.EXPECTED_MYACC_MENU_OPTS_LIST);

  }
  
  @Test(description="TC_05_Verify My account Header List",priority=5)
  public void verifyMyAccountHeaderListTest() throws InterruptedException {
	  log.info("TC_04_Verify My account options List");

		Assert.assertEquals(myaccountPg.getMyAccountHeaderList(),Constants.EXPECTED_MYACC_HEADER_LIST);

  }
  
  
  @Test(description="TC_06_Verify the broken links in my account page",priority=6)
  public void verifyBrokenLinksInMyAccountPageTest() throws InterruptedException, IOException {
	log.info("Verify the broken links in my account page");
	List<WebElement>myAccPageLinksList=driver.findElements(By.tagName("a"));
	for(WebElement link:myAccPageLinksList) {
		String linkUrl=link.getAttribute("href");
		verifyUrls(linkUrl);
	}
	
  }
  
  @Test(description="TC_07_Perform the product search",priority=7,dataProvider="products")
  public void performProductSearchTest(String productName) throws InterruptedException {
	log.info("TC_07_Perform the product search");
	resultPg=myaccountPg.doProductSearch(productName);
	resultPg.waitForPageLoad(2000);
	log.info("Verify Results page title");
	SoftAssert sa=new SoftAssert();
	sa.assertEquals(resultPg.getTitle(),"Search - "+productName);
	sa.assertTrue(resultPg.getSearchProductListSize()>0);
	sa.assertAll();
	resultPg.navigateToMyAccountPage();
	myaccountPg.waitForPageLoad(2000);
  }
  
  @DataProvider(name="products")
  public Object[][] productTestData(){
	  return new Object[][] {
		  {"MacBook"},
		  {"iMac"},
		  {"Samsung"}
	  };
  }
  
  @Test(description="TC_08_Logout test",priority=8)
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
	  myaccountPg.waitForPageLoad(2000);
  }

  


  @BeforeClass
  public void beforeClass() throws InterruptedException {
	 log.info("Initilizing the page classe objects");
	 homePg=new HomePage(driver);
	 regPg=new RegistrationPage(driver);
	 loginPg=new LoginPage(driver);
	 myaccountPg=new MyAccountPage(driver);
	 logoutPg=new LogoutPage(driver);
	 resultPg=new ResultsPage(driver);
	 log.info("navigate to login page");
	 homePg.navigateToLoginPage();
	 loginPg.doLogin(rb.getString("username"), rb.getString("pwd"));
	 myaccountPg.waitForPageLoad(2000);
	log.info("Verify the my account page title");
	Assert.assertEquals(myaccountPg.getTitle(),Constants.MY_ACCOUNT_PAGE_TITLE);
  }

}