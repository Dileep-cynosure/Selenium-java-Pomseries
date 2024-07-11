package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.Base;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

public class LoginPageTest extends Base {

	@Test(priority = 1)
	public void loginPageTitleTest() {

		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
	}

	@Test(priority = 2)
	public void loginPageUrlTest() {

		String actualUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.PAGE_URL), AppError.URL_NOT_FOUND);

	}

	@Test(priority = 3)
	public void forgetPwdLnkTest() {

		Assert.assertTrue(loginPage.checkForgotPwdLink(), AppError.FORGETLNK_NOT_FOUND);

	}

	@Test(priority = 4)
	public void loginTest() {

		// String acutalTitle= loginPage.doLogin("feb2024@gmail.com", "Selenium@12345");
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE, AppError.TITLE_NOT_FOUND);

	}
}