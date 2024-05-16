package com.qa.opencart.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.WebDriverUtils;

public class RegistrationPage extends WebDriverUtils {
	private static Logger log = LogManager.getLogger(RegistrationPage.class.getName());

	public RegistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//*[@class='fa fa-home']")
	private WebElement homeIcon;

	@FindBy(css = "#content>h1")
	private WebElement registerAccountHeader;

	@FindBy(css = "#content>p>a")
	private WebElement registerAccountLoginPageLink;

	@FindBy(css = "#account>legend")
	private WebElement personalDetailsLegendTxt;

	@FindBy(id = "input-firstname")
	private WebElement firstNameEditbox;

	@FindBy(name = "lastname")
	private WebElement lastNameEditbox;

	@FindBy(id = "input-email")
	private WebElement emailEditbox;

	@FindBy(css = "#input-telephone")
	private WebElement telephoneEditbox;


	@FindBy(css = "fieldset:nth-child(1) legend:nth-child(1)")
	private WebElement passwordLegendTxt;

	@FindBy(css = "#input-password")
	private WebElement passwordEditbox;

	@FindBy(css = "#input-confirm")
	private WebElement confirmPassowrdEditbox;

	@FindBy(css = "input[value='1'][name='newsletter']")
	private WebElement subscribeYesRadioBtn;

	@FindBy(css = "input[value='0']")
	private WebElement subscribeNoRadioBtn;

	@FindBy(css = "input[value='1'][name='agree']")
	private WebElement privacypolicyCheckbox;

	@FindBy(css = "input[value='Continue']")
	private WebElement continueBtn;

	@FindBy(css = "body > div:nth-child(4) > div.alert.alert-danger")
	private WebElement agreeErrMsg;

	@FindBy(css = "body > div:nth-child(4) > div.alert.alert-danger")
	private WebElement emailExistsErrMsg;
	
	@FindBy(css = "body div[class='container'] ul[class='breadcrumb'] li:nth-child(3) a:nth-child(1)")
	private WebElement registerBreadCrumb;

	@FindBy(css = "div#content>h1")
	private WebElement accntCreatedHeader;

	@FindBy(css = "div#content>p")
	private WebElement accntCreatedSuccMsg;

	@FindBy(css = "a.btn.btn-primary")
	private WebElement accntCreatedContinueBtn;

	@FindBy(css = "body > div:nth-child(4) > ul > li:nth-child(3) > a")
	private WebElement accntCreatedBreadCrumbSuccessLink;

	@FindBy(xpath = "//a[contains(.,'contact us')]")
	private WebElement contactUsLink;

	public void clickRegHomeIcon() throws InterruptedException {
		log.info("click on breadcrumb home icon");
		click(homeIcon);
	}

	public String getAccntCreatedHeader() throws InterruptedException {
		return getText(accntCreatedHeader);
	}

	public String getAccntCreatedSuccMsg() throws InterruptedException {
		return getText(accntCreatedSuccMsg);
	}

	public boolean isAccntCreatedSuccMsgPresent() {
		return isDisplayed(accntCreatedSuccMsg);
	}

	public boolean isAccntCreatedBreadCrumbSuccessLinkPresent() {
		return isDisplayed(accntCreatedBreadCrumbSuccessLink);
	}

	public void clickOnContactUsLink() throws InterruptedException {
		log.info("clicking on BreadCrumbHomeIcon");
		click(contactUsLink);
	}

	public void clickAccntHasBeenCreatedContinueBtn() throws InterruptedException {
		log.info("clicking on accntCreatedContinueBtn");
		click(accntCreatedContinueBtn);
	}

	public String getFirstNameEditbox() {
		return firstNameEditbox.getAttribute("value");
	}

	public void setFirstNameEditbox(String firstName) throws InterruptedException {
		log.info("Type the first name value");
		sendData(firstNameEditbox, firstName);
	}

	public String getLastNameEditbox() {
		return lastNameEditbox.getAttribute("value");
	}

	public void setLastNameEditbox(String lastName) throws InterruptedException {
		log.info("Type the last name value");
		sendData(lastNameEditbox, lastName);
	}

	public String getEmailEditbox() {
		return emailEditbox.getAttribute("value");
	}

	public void setEmailEditbox(String email) throws InterruptedException {
		log.info("Type the email value");
		sendData(emailEditbox, email);
	}

	public String getTelephoneEditbox() {
		return telephoneEditbox.getAttribute("value");
	}

	public void setTelephoneEditbox(String telephone) throws InterruptedException {
		log.info("Type the telephone value");
		sendData(telephoneEditbox, telephone);
	}

	
	
	public String getPasswordEditbox() {
		return passwordEditbox.getAttribute("value");
	}

	public void setPasswordEditbox(String password) throws InterruptedException {
		log.info("Enter the password value:");
		sendData(passwordEditbox, password);
	}

	public String getConfirmPassowrdEditbox() {
		return confirmPassowrdEditbox.getAttribute("value");
	}

	public void setConfirmPassowrdEditbox(String confirmPassowrd) throws InterruptedException {
		log.info("Enter the email value:");
		sendData(confirmPassowrdEditbox, confirmPassowrd);
	}



	public void selectSubscribe(String subscribe) throws InterruptedException {
		log.info("select newsletter subscription value");
		if (subscribe.equalsIgnoreCase("Yes")) {
			log.info("Select Yes radio button");
			click(subscribeYesRadioBtn);
		} else {
			log.info("Select No radio button");
			click(subscribeNoRadioBtn);
		}
	}

	public void checkAgreeCheckbox() throws InterruptedException {
		log.info("check Agree checkbox");
		check(privacypolicyCheckbox);
	}

	public void clickContinueBtn() throws InterruptedException {
		log.info("click Continue button");
		click(continueBtn);
	}

	public void clickLoginPageLink() throws InterruptedException {
		log.info("click LoginPage Link");
		click(registerAccountLoginPageLink);
	}

	public void setPersonalDetails(String fname, String lname, String email, String tel)
			throws InterruptedException {
		setFirstNameEditbox(fname);
		setLastNameEditbox(lname);
		setEmailEditbox(email);
		setTelephoneEditbox(tel);
		
	}

	

	public void setPasswordDetails(String pwd, String confirmPwd) throws InterruptedException {
		setPasswordEditbox(pwd);
		setConfirmPassowrdEditbox(confirmPwd);
	}

}
