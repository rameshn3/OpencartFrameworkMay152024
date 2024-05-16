package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.WebDriverUtils;

public class LoginPage extends WebDriverUtils{

	private Logger log = LogManager.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Login']")
	private WebElement loginBreadCrumb;
	
	@FindBy(xpath="//h2[normalize-space()='New Customer']")
	private WebElement newCustomerHeader;
	
	@FindBy(xpath="//a[contains(@class,'btn btn-primary')]")
	private WebElement newCustomerContinueBtn;
	
	@FindBy(xpath="//h2[normalize-space()='Returning Customer']")
	private WebElement returningCustomerHeader;
	
	@FindBy(id="input-email")
	private WebElement emailAddressEditbox;
	
	@FindBy(name="password")
	private WebElement passwordEditbox;
	
	@FindBy(linkText="Forgotten Password")
	private WebElement forgottenPasswordLink;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	

	@FindBy(css="div[class*='alert alert-danger']")
	private WebElement emptyCredsErrorMsg;
	
	@FindBy(xpath="//i[contains(@class,'fa fa-home')]")
	private WebElement loginHomeIcon;
	
	public void clickHomeIcon() throws InterruptedException {
		log.info("click on breadcrumb homeicon");
		click(loginHomeIcon);
	}
	
	public String getEmptyCredErrorMsg() throws InterruptedException {
		return getText(emptyCredsErrorMsg);
	}
	
	public String getLoginPageUrl() {
		return waitForUrlContains(Constants.LOGIN_PAGE_FRACTION_URL);
	}
	
	public void navigateToForgotPasswordPage() throws InterruptedException {
		log.info("click on forgot password link");
		click(forgottenPasswordLink);
	}
	
	public void doLogin(String email,String pwd) throws InterruptedException {
		log.info("Performing the login operation");
		sendData(emailAddressEditbox, email);
		sendData(passwordEditbox, pwd);
		log.info("click on login Button");
		click(loginBtn);
	}
	public void navigateToRegisterPage() throws InterruptedException {
		log.info("click on New Customer continue button");
		click(newCustomerContinueBtn);
	}
	
	public boolean isNewCustomerHeaderExists() {
		return isDisplayed(newCustomerHeader);
	}
	
	public boolean isreturningCustomerHeaderExists() {
		return isDisplayed(returningCustomerHeader);
	}
	
	public boolean isloginBreadCrumbExists() {
		return isDisplayed(loginBreadCrumb);
	}
}
