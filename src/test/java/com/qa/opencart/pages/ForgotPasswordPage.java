package com.qa.opencart.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.WebDriverUtils;

public class ForgotPasswordPage extends WebDriverUtils{
	private static Logger log=LogManager.getLogger(ForgotPasswordPage.class.getName());
	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(css="#content>h1")
	private WebElement forgotYourPasswordHeader;
	
	@FindBy(css="#content>form>fieldset>legend")
	private WebElement yourEmailAddressLegendTxt;
	
	@FindBy(css="#input-email")
	private WebElement emailAddressEditbox;
	
	@FindBy(css="input[type='submit'][value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//a[normalize-space()='Back']")
	private WebElement backBtn;
	
	public boolean isForgotYourPasswordHeaderExists() {
		return isDisplayed(forgotYourPasswordHeader);
	}
	
	public boolean isYourEmailAddressLegendTxExists() {
		return isDisplayed(yourEmailAddressLegendTxt);
	}

	public void setEmailAddress(String email) throws InterruptedException {
			log.info("Enter the email address");
			sendData(emailAddressEditbox, email);
	}
	
	public void navigateToLoginPage() {
		log.info("click on Back button");
		try {
			click(backBtn);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickForgotPasswordContinueBtn() {
		log.info("click on continue button");
		try {
			click(continueBtn);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
