package com.qa.opencart.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.WebDriverUtils;

public class HomePage extends WebDriverUtils{

	private Logger log = LogManager.getLogger(HomePage.class);
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "logo")
	private WebElement opencartLogo;
	
	@FindBy(xpath="//*[@id='content']/div[2]/div")
	private List<WebElement>featuredProductList;
	
	@FindBy(xpath = "//span[contains(.,'My Account')]")
	private WebElement myAccountMenu;
	
	@FindBy(xpath = "//a[contains(.,'Register')]")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[contains(.,'Login')]")
	private WebElement loginLink;
	
	public boolean isOpenCartLogoExists() {
		log.info("checking the logo in home page");
		return isDisplayed(opencartLogo); 
		
	}
	
	public void openMyAccountMenu() throws InterruptedException {
		log.info("Opening my account menu");
		click(myAccountMenu);
	}
	
	public void navigateToRegisterPage() throws InterruptedException {
		openMyAccountMenu();
		log.info("click on register link");
		click(registerLink);
	}
	public void navigateToLoginPage() throws InterruptedException {
		openMyAccountMenu();
		log.info("click on Login link");
		click(loginLink);
	}
	
	public int getFeaturedSectionCardsCount() {
		log.info("Fetching Featured section cards count");
		return featuredProductList.size();
	}
}
