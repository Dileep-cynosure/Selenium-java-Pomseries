package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.Base;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;

public class RegistrationPageTest extends Base {

	@BeforeClass

	public void regSetup() {
		regPage = loginPage.registrationPageLink();

	}

	@DataProvider
	public Object[][] userRegTestData() {
		return new Object[][] { { "Arti", "automation", "9876787656", "arti@123", "yes" },
				{ "Praful", "automation", "9876787690", "praful@123", "no" },
				{ "Madhu", "automation", "9876787876", "madhu@123", "yes" } };
	}

	@DataProvider
	public Object[][] userRegData() {
		return ExcelUtil.getTestData(AppConstants.REG_ACC_DATA_SHEET);
	}

	@Test(dataProvider = "userRegData")
	public void userRegisterationTest(String firstName, String lastName, String telephone, String password,
			String subscribe) {
		Assert.assertTrue(regPage.userRegister(firstName, lastName, StringUtils.getRandomEmailId(), telephone, password,
				subscribe), AppError.USER_REG_NOT_DONE);
	}

}