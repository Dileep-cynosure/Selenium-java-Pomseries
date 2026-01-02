package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.TimeUtil;

public class LoginPage {

	private WebDriver driver;
	ElementUtil eleUtil;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	private By emailId = By.id("input-email");

	private By password = By.id("input-password");

	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLnk = By.linkText("Forgotten Password");
	private By registrationLnk = By.xpath("(//div[@id='account-login']//div[@class='list-group']/a)[2]");

	public String getLoginPageTitle() {

		String title = eleUtil.waitForTitleToBe(AppConstants.ACCOUNTS_PAGE_TITLE, TimeUtil.DEFAULT_TIME);
		System.out.println("the title of page" + title);
		return title;

	}

	public String getLoginPageUrl() {
		String url = eleUtil.waitForURLToBe(AppConstants.PAGE_URL, TimeUtil.DEFAULT_TIME);
		return url;

	}

	public boolean checkForgotPwdLink() {

		return eleUtil.doIsDisplayed(forgotPwdLnk);
	}

	public AccountsPage doLogin(String username, String pwd) {
		System.out.println("user creds : " + username + ":" + pwd);
		eleUtil.doSendKeys(emailId, username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);

	}

	public RegistrationPage registrationPageLink() {
		eleUtil.doClick(registrationLnk, TimeUtil.DEFAULT_TIME);
		return new RegistrationPage(driver);
	}
	
	

}
