package com.qa.opencart.pages;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.qa.opencart.utils.TimeUtils;
import com.qa.opencart.utils.WebDriverUtils;

public class ResultsPage extends WebDriverUtils{

	private Logger log=LogManager.getLogger(ResultsPage.class.getName());
	
	public ResultsPage(WebDriver driver) {
		super(driver);
		
		
	}
	
	@FindBy(css="#content>h1")
	private WebElement searchHeader;
	
	@FindBy(css="div[class*='product-layout product-grid']")
	private List<WebElement> searchproductList;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountMenu;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountOption;
	
	public String getSearchResultsPageTitle(String productname) {
		return waitForTitleContains(productname);
	}
	public int getSearchProductListSize() {
		return searchproductList.size();
	}
	
	public void selectProduct(String productName) throws InterruptedException {
		log.debug("Selecting the product:"+productName);
		click(getElement(By.linkText(productName)));
		TimeUtils.mediumWait();
	}
	
	public void navigateToMyAccountPage() throws InterruptedException {
		log.info("click on my account menu");
		click(myAccountMenu);
		waitForElementVisible(By.xpath("//span[normalize-space()='My Account']"));
		TimeUtils.mediumWait();
		click(myAccountOption);
		TimeUtils.mediumWait();
	}
}
