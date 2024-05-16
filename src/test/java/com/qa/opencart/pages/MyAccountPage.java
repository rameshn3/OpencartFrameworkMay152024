package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.JavaScriptUtils;
import com.qa.opencart.utils.WebDriverUtils;

public class MyAccountPage extends WebDriverUtils{

	private Logger log = LogManager.getLogger(MyAccountPage.class);
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md'][contains(.,'My Account')]")
	private WebElement myAccountMenu;
	
	@FindBy(css=" input[placeholder='Search']")
	private WebElement searchEditbox;
	
	@FindBy(css="button[class='btn btn-default btn-lg']")
	private WebElement searchTorchIcon;
	
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	
	@FindBy(css="#account-account > ul > li:nth-child(2) > a")
	private WebElement accountBreadCrumb;
	
	@FindBy(xpath="//div[@id='top-links']/ul/li[2]/ul/li")
	private List<WebElement> myAccountMenuOptionList;
	
	@FindBy(xpath="//div[@id='content']/h2")
	private List<WebElement> myAccountHeadersList;
	
	@FindBy(xpath="//div[@id='content']/ul[1]/li")
	private List<WebElement> myAccountHeaderElementsList;
	
	@FindBy(xpath="//div[@id='content']/ul[2]/li")
	private List<WebElement> myOrdersHeaderElementsList;
	
	@FindBy(xpath="//div[@id='content']/ul[3]/li")
	private List<WebElement> myAffiliateAccountHeaderElementsList;
	
	@FindBy(xpath="//div[@id='content']/ul[4]/li")
	private List<WebElement> newsLetterHeaderElementsList;
	
	@FindBy(xpath="//i[@class='fa fa-home']")
	private WebElement homeIcon; 

	
	public void clickMyAccountMenuLink() throws InterruptedException {
		log.info("click on My Account menu link");
		click(myAccountMenu);
	}
	public String getMyAccountPageUrl() {
		return waitForUrlContains(Constants.ACC_PAGE_FRACTION_URL);
	}
	
	public boolean isSearchEditboxExists() {
		return isDisplayed(searchEditbox);
	}
	
	
	public boolean isLogoutExists() throws InterruptedException {
		clickMyAccountMenuLink();
		return isDisplayed(logoutLink);
	}
	public void clickLogoutLink() throws InterruptedException {
		log.info("click on Logout link");
		click(logoutLink);
	}
	
	public List<String> getMyAccountMenuOptionList() throws InterruptedException{
		clickMyAccountMenuLink();
		List<String>myAccMenuOptionsTxtList=new ArrayList<String>();
		
		for(WebElement ele:myAccountMenuOptionList) {
			myAccMenuOptionsTxtList.add(ele.getText());
		}
		return myAccMenuOptionsTxtList;
	}
	
	public List<String> getMyAccountHeaderList() throws InterruptedException{
		
		List<String>myAccHeaderTxtList=new ArrayList<String>();
		
		for(WebElement ele:myAccountHeadersList) {
			myAccHeaderTxtList.add(ele.getText());
		}
		return myAccHeaderTxtList;
	}
	
	
	public List<String> getmyAccountHeaderElementsList() throws InterruptedException{
		clickMyAccountMenuLink();
		List<String>myAccHeaderElementsTxtList=new ArrayList<String>();
		
		for(WebElement ele:myAccountHeaderElementsList) {
			myAccHeaderElementsTxtList.add(ele.getText());
		}
		return myAccHeaderElementsTxtList;
	}
	
	public List<String> getmyOrdersHeaderElementsList() throws InterruptedException{
		clickMyAccountMenuLink();
		List<String>myOrdersHeaderElementsTxtList=new ArrayList<String>();
		
		for(WebElement ele:myOrdersHeaderElementsList) {
			myOrdersHeaderElementsTxtList.add(ele.getText());
		}
		return myOrdersHeaderElementsTxtList;
	}
	
	public List<String> getmyAffiliateAccountHeaderElementsList() throws InterruptedException{
		clickMyAccountMenuLink();
		List<String>myAffiliateAccountHeaderElementsTxtList=new ArrayList<String>();
		
		for(WebElement ele:myAffiliateAccountHeaderElementsList) {
			myAffiliateAccountHeaderElementsTxtList.add(ele.getText());
		}
		return myAffiliateAccountHeaderElementsTxtList;
	}
	
	public List<String> getnewsLetterHeaderElementsList() throws InterruptedException{
		clickMyAccountMenuLink();
		List<String>newsLetterHeaderElementsTxtList=new ArrayList<String>();
		
		for(WebElement ele:newsLetterHeaderElementsList) {
			newsLetterHeaderElementsTxtList.add(ele.getText());
		}
		return newsLetterHeaderElementsTxtList;
	}
	
	public ResultsPage doProductSearch(String product) throws InterruptedException {
		log.info("searching for the product:"+product);
		if(isSearchEditboxExists()) {
			new Actions(driver).sendKeys(Keys.ESCAPE).perform();
			sendData(searchEditbox, product);
			//click(searchTorchIcon);
			new JavaScriptUtils(driver).clickElementByJS(searchTorchIcon);
			return new ResultsPage(driver);
		}
		return null;
	}
	
	
}
