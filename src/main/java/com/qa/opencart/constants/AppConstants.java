package com.qa.opencart.constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	
	public static final String CONFIG_QA_FILE_PATH="./src/test/resources/config/config.properties";
	public static final String QA_FILE_PATH="./src/test/resources/config/qa.properties";
	public static final String STAGE_FILE_PATH="./src/test/resources/config/stage.properties";
	public static final String DEV_FILE_PATH="./src/test/resources/config/dev.properties";
	public static final String UAT_FILE_PATH="./src/test/resources/config/uat.properties";
	public static final String ACCOUNTS_PAGE_TITLE="My Account";
	public static final String LOGIN_PAGE_TITLE ="Account Login";
	public static final String PAGE_URL ="route=account/login";
	public static final String ACC_PAGE_FRACTION_URL ="route=account/account";
	public static final List<String> ACC_PAGE_headers = Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
	public static final String REG_PAGE_FRACTION_URL ="route=account/register";
	public static final CharSequence USER_REGISTER_SUCCESS_MESSG = "Your Account Has Been Created";
	public static final String REG_ACC_DATA_SHEET = "register";
	
	
	
//	public static final String URL_NOT_FOUND ="===URL_NOT_FOUND===";
//	public static final String FORGETLNK_NOT_FOUND ="===FORGETLNK_NOT_FOUND===";
}
