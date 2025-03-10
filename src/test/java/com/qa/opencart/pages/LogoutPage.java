package com.qa.opencart.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.utils.WebDriverUtils;

public class LogoutPage extends WebDriverUtils{

	private static Logger log=LogManager.getLogger(LogoutPage.class.getName());
		
		public LogoutPage(WebDriver driver) {
			super(driver);
			
		}

		@FindBy(css="#content>p")
		private WebElement accountLoggedOffMsg;
		
		@FindBy(css="#content>h1")
		private WebElement accountLogoutHeader;

		@FindBy(css="a.btn.btn-primary")
		private WebElement continueBtn;

		public boolean isAccountLoggedOffMsgExists() {
			return isDisplayed(accountLoggedOffMsg);
		}
		
		public boolean isAccountLogoutHeaderExists() {
			return isDisplayed(accountLogoutHeader);
		}
		
		public void clickContinueBtn() throws InterruptedException {
			log.info("click on continue btn in logout page");
			click(continueBtn);
		}
		
		public String getLogoutPageTitle() {
			waitForPageLoad(2000);
			return getTitle();
		}
}